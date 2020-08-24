package se.lexcion.simon.thymeleaf_demogroup_30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomePage {

    @RequestMapping(path = "", method = RequestMethod.GET) // (Default values)
    public String index(){
        return "index.html";
    }


   // @RequestMapping(path = "/welcome", method = RequestMethod.GET) //Same
    @GetMapping("/welcome")
    public String anotherWelcomeMessage(){
        return "welcome";
    }

}
