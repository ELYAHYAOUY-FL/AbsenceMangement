package com.example.Atelier8.controller;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.services.StudentService;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/addStudent")
    public String index(Model mode){

        mode.addAttribute("student" , new Student());
        return "AddStudents" ;
    }
    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student ){
        studentService.save(student);

        return "redirect:/student/list" ;
    }

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students); // Add retrieved students to the model
        return "ListStudent"; // Return the name of your Thymeleaf HTML file
    }
}
