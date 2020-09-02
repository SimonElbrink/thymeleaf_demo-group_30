package se.lexcion.simon.thymeleaf_demogroup_30.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lexcion.simon.thymeleaf_demogroup_30.dto.StudentDto;
import se.lexcion.simon.thymeleaf_demogroup_30.model.Student;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
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

    @GetMapping("/register")
    public String registerView(Model model){

        model.addAttribute("student", new StudentDto());

        return "register_form";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") StudentDto dto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "register_form";
        }else{
            Student student = new Student(dto.getName(), dto.getEmail());

            students.add(student);
        }
        return "redirect:/student";

    }


    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") Integer id){

        students.removeIf(student -> student.getId() == id);

        return "redirect:/student";
    }

}
