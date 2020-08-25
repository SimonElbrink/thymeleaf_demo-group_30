package se.lexcion.simon.thymeleaf_demogroup_30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    List<String> texts = Arrays.asList("This", "Should", "Be", "Displayed", "In", "A", "Table");

    @RequestMapping(path = "/", method = RequestMethod.GET) // (Default values)
    public String index(){
        //Resolves to the file "index.html" inside "src\main\resources\templates" folder.
        return "index";
    }


   // @RequestMapping(path = "/welcome", method = RequestMethod.GET) //Same
    @GetMapping("/welcome")
    public String anotherWelcomeMessage(){
        return "welcome";
    }

    @GetMapping("/showtext")
    public String showAListOfText(Model model){

        model.addAttribute("allText", texts);

        return "textList";
    }



}
