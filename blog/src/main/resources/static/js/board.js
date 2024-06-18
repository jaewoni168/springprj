let index={
    init:function(){
    //회원가입
        $('#btn-write').on('click',()=>{
            this.save();
        });
        $('#btn-delete').on('click',()=>{
            this.deleteById();
        });
        $('#btn-update').on('click',()=>{
            this.update();
        });
        $('#btn-reply-save').on('click',()=>{
            this.replySave();
        });
    },

    replyDelete : function(boardId, replyId){
           $.ajax({
             type: "DELETE",
             url: `/api/board/${boardId}/reply/${replyId}`,
             dataType: "json"
            }).done(function(resp){
           alert("댓글삭제 성공");
           location.href = `/board/${boardId}`;
          }).fail(function(error){
           alert(JSON.stringify(error));
          });
         },

   replyUpdate : function(boardId, replyId){
   let data={
   content:$("#reply-content").val(),
   }
   console.log(boardId,replyId,data)
   $.ajax({
   type: "PUT",
   url: `/api/board/${boardId}/reply/${replyId}`,
   data:JSON.stringify(data),
   contentType:"application/json; charset=utf-8",
   dataType:"json"
   }).done(function(resp){
   alert("댓글수정 성공");
   location.href = `/board/${boardId}`;
   }).fail(function(error){
   alert(JSON.stringify(error));
   });
   },

    replySave:function(){
        let data={
              boardId:$("#boardId").val(),
              userId:$("#userId").val(),
              content:$("#reply-content").val(),
            }
           console.log(data);

           $.ajax({
              type:"POST",
              url:`/api/board/${data.boardId}/reply`,
              data:JSON.stringify(data),
               contentType:"application/json; charset=utf-8",
              dataType:"json"
            }).done(function(resp){
               console.log(resp)
               alert("댓글이 등록되었습니다.");
               location.href=`/board/${data.boardId}`;
            }).fail(function(error){
                  console.log(error);
                 alert(JSON.stringify(error));
            });
         },

    // 수정하기
    update:function(){
        var id=$('#id').val();
           let data={
              title:$("#title").val(),
             content:$("#content").val()
        }

      $.ajax({
             type:"PUT",
            url:'/api/board/'+id,
            data:JSON.stringify(data),
            contentType:"application/json; charset=utf-8",
          dataType:"json"
       }).done(function(resp){
         alert("수정이 완료되었습니다.");
           location.href="/";
       }).fail(function(error){
         alert(JSON.stringify(error));
      });
    },

// 삭제하기
    deleteById:function(){
        var id=$('#id').text();
        $.ajax({
          type:"DELETE",
          url:'/api/board/'+id
        }).done(function(resp){
            alert("삭제가 되었습니다.");
           location.href="/";
        }).fail(function(error){
          alert(JSON.stringify(error));
        });
     },

// 글쓰기
    save:function(){
       let data={
            title:$("#title").val(),
            content:$("#content").val(),
       }

    $.ajax({
        type:"POST",
        url:'/api/board',
        data:JSON.stringify(data),
         contentType:"application/json; charset=utf-8",
         dataType:"json"
    }).done(function(resp){
         if(resp.data==1){
             alert("글쓰기가 완료되었습니다.");
             location.href="/";
          }else{
               alert("로그인을 해주세요.");
               location.href="/auth/loginForm";
          }
       }).fail(function(error){
           alert(JSON.stringify(error));
       });
    }
 }
    index.init();