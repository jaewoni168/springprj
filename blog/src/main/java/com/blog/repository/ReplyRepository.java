package com.blog.repository;

import com.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
    @Modifying
    @Query(value="INSERT INTO reply (user_Id, board_Id, content, create_date) VALUES(?1,?2,?3, now())", nativeQuery = true)
    int mySave(int userId,int boardId, String content);

}
