package com.jet.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {
    //What method -- GET
    //URI -- /hello-world
    //method - "Hello World"
//    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }
    //hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
//        throw new RuntimeException("Some Error has happened");
//
    }

    @GetMapping(path = "/hello-world/{name}")
    public HelloWorldBean helloWorldTo(@PathVariable("name") String  name) {
        String s = "Hello World " + name;
        return new HelloWorldBean(s);
    }
}
