package com.pch.class1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam("name") String name, Model model ){
        model.addAttribute("name", name);
        return "hello-Template"; // <html> 태그까지 전부 화면으로 전송된다.
    }

    @GetMapping("hello-string")
    @ResponseBody // http 응답 body에 값을 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; //return 한 내용만 전송된다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){ // 객체는 json 방식으로 전송됨.
        //객체처리는 Jackson, gson 등의 라이브러리를 사용해 json형식으로 변환 해줌
        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        //getter, setter는 java bean 표준 방식. property 접근 방식이라고도 부름.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
