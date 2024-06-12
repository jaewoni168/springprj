package com.blog.service;
import com.blog.dto.ReplySaveRequestDto;
import com.blog.model.Board;
import com.blog.model.Reply;
import com.blog.model.User;
import com.blog.repository.BoardRepository;
import com.blog.repository.ReplyRepository;
import com.blog.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private HttpSession session;

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public Boolean 글쓰기(Board board, String user){ // title, content

        User user1= userRepository.findByUsername(user).orElse(null);

        board.setCount(0);
        board.setUser(user1);
        boardRepository.save(board);
        return true;

    }

    public Page<Board> 글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public Board 글상세보기(int id) {
        Board board =boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없습니다.");
        });
        // 조회수 증가
        board.setCount(board.getCount()+1);
        //boardRepository.save(board);
        return board;
    }

    @Transactional
    public void 글삭제하기(int id) {
        boardRepository.deleteById(id);
        // void형임 optional이 아니다.
    }

    @Transactional
    public void 글수정하기(int id, Board requestboard) {
        // 영속화 시킨다.
        Board board=boardRepository.findById(id).orElseThrow(()->{
            return new IllegalArgumentException("글 찾기 실패: 아이디를 찾을 수 없습니다.");
        }); // 영속화 완료

        board.setTitle(requestboard.getTitle());
        board.setContent(requestboard.getContent());

        // 해당함수 종료시 (서비스가 종료될때) 트랜잭션이 종료된다. 이때 더티체킹-자동업데이트가된다.
        // db flush된다. 즉 commit이 된다.

    }

    @Transactional
    public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {

        Board board=boardRepository.findById(replySaveRequestDto.getBoardId()).orElseThrow(()->{
            return new IllegalArgumentException("댓글쓰기 실패: 게시글아이디를 찾을 수 없습니다.");
        }); // 영속화 완료

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user=userRepository.findByUsername(userDetails.getUsername()).orElseThrow(()->{
            return new IllegalArgumentException("댓글쓰기 실패: 유저아이디를 찾을 수 없습니다.");
        });
//        User user = userRepository.findById(replySaveRequestDto.getUserId()).orElseThrow(()->{
//            return new IllegalArgumentException("댓글쓰기 실패: 유저아이디를 찾을 수 없습니다.");
//        });

        Reply reply = new Reply();
        reply.update(user, board, replySaveRequestDto.getContent());

        replyRepository.save(reply);

    }

    @Transactional
    public void 댓글삭제(int replyId) {
        replyRepository.deleteById(replyId);
    }

    @Transactional
    public void 댓글수정(int replyId, Reply reply) {

        Reply reply1=replyRepository.findById(replyId).orElse(null);

        reply1.setContent(reply.getContent());

    }
}
