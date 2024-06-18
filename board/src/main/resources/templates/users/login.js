let index={
     init:function(){
      let _this=this;
  $('#btn-login').on('click',function(){
        _this.login();
 });
      // $('#btn-save').on('click',()=>{
          // _this.save();
           // });
},
 login:function(){
     let data={
          username: $('#username').val(),
         password: $('#password').val()
    };
console.log(data);

$.ajax({
type:"POST",
        url:'/home/userLogin',
         data:JSON.stringify(data), // http body 데이터
            contentType:"application/json; charset=utf-8", // body데이터가 어떤 타입인지(MIME)
          dataType:"json" // 요청을 서버로 해서 응답이 왔을때 기본적으로 모든것이 문자열(모양은 json)
       }).done(function(resp){
        console.log(resp.username);
              alert("로그인이 완료되었습니다.");
              location.href="/articles";
              sessionStorage.setItem('username', resp.username);
         }).fail(function(error){
               // alert(JSON.stringify(error));
            alert("아이디가 없거나 패스워드가 잘못되었습니다.");
              $('#username').val("").focus(),
            $('#password').val("")
            console.log(error);
           });
     }
}
index.init();