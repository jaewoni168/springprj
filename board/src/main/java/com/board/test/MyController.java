package com.board.test;

import com.board.dto.Mydata;
import com.board.dto.UserForm;
import com.board.entity.User;
import com.board.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;

@Controller
@Slf4j
public class MyController {

    @GetMapping("/hellotest")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name,
                        Model model) {
        String message = "Hello, " + name + "!";
        model.addAttribute("message", message);
        return "hello"; // hello.html 뷰를 반환
    }
    @GetMapping("/hellotest2")
    public String hello2(Model model) {
        String name = "Welcome, ";
        String message = "Hello";
        // String[] fruits={"사과","배","바나나","망고"};
        ArrayList<String> fruits=new ArrayList<>();
        fruits.add("사과");
        fruits.add("배");
        fruits.add("바나나");

        model.addAttribute("message", message);
        model.addAttribute("name", name);
        model.addAttribute("fruits", fruits);
        log.info("과일 : " +fruits);
        return "hello"; // hello.html 뷰를 반환
    }

    @GetMapping("/redirect")
    public String redirectToAnotherPage(RedirectAttributes redirectAttributes) {
        // 플래시 속성 추가
        redirectAttributes.addFlashAttribute("message", "This is a flash message!");

        // 리다이렉트할 URL 리턴
        return "redirect:/anotherPage";
    }

    @GetMapping("/anotherPage")
    public String showAnotherPage(@ModelAttribute("message") String message) {
        // 리다이렉트된 페이지에서 플래시 속성을 사용
        System.out.println("Flash Message: " + message);
        return "anotherPage";     // anotherPage.mustache
    }

    @PostMapping("/api/person")
    public ResponseEntity<Person> person(@RequestBody Person person){
        return ResponseEntity.status(HttpStatus.OK).body(person);
    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/api/save")
    public ResponseEntity saveUser(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body("User saved" + user) ;
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<String> getData(@PathVariable Long id) {
        if (id == 1L) {
            return ResponseEntity.ok("Data with ID 1 found");
        } else {
            return ResponseEntity.notFound().build();
        }
        //return ResponseEntity.status(HttpStatus.OK);
    }

    @PostMapping("/api/create")
    public ResponseEntity<Mydata> create(@RequestBody Mydata myData) {
        log.info("myData : " + myData);
        return ResponseEntity.ok(myData);
    }

//    @GetMapping("/api/test")
//    public String newTestForm() {
//        return "test";
//    }

    @PostMapping("/api/processForm")
    public String process(@RequestBody UserForm user,RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("userTest", user);

        log.info("user:"+user);
        return "redirect:/api/processForm";
    }

    @GetMapping("/api/processForm")
    public ResponseEntity<String> processForm(@ModelAttribute("userTest") UserForm userTest) {
        // public String processForm(@RequestParam String username, @RequestParam String password) {
        log.info("userTest : " + userTest.toString());
        String result = userTest.getUsername()+" " + userTest.getPassword()+" "+userTest.getEmail();
        log.info("result : " + result);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/usersTest/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        // id에 해당하는 사용자를 데이터베이스에서 조회하고 user 변수에 저장하는 로직을 가정합니다.
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            // 사용자가 존재하는 경우 200 OK 상태 코드와 사용자 객체를 응답으로 반환
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            // 사용자가 존재하지 않는 경우 404 Not Found 상태 코드를 반환
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
