package se.lexcion.simon.thymeleaf_demogroup_30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexcion.simon.thymeleaf_demogroup_30.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private List<Student> students;

    @PostConstruct
    public void init(){
        if(students == null){
             students = new ArrayList<>();
        }

        students.add(new Student("Simon", "Simon@lexicon.se"));
        students.add(new Student("Erik", "Erik@lexicon.se"));
    }

    @GetMapping()
    public String getAll(Model model){
        model.addAttribute(students);

        return "student_view";
    }




}
