package com.example.Atelier8.controller;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.services.StudentService;
import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students); // Add retrieved students to the model
        return "ListStudent"; // Return the name of your Thymeleaf HTML file
    }
    @GetMapping("/addStudent")
    public String index(Model model) {
        model.addAttribute("student", new Student());
        return "AddStudents";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("student") Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Optional<Student> student = studentService.getOne(id);
        model.addAttribute("student", student);
        return "AddStudents"; // Assuming your Thymeleaf template is named "addStudent.html"
    }

    // Handle form submission for both add and edit
    @PostMapping({"/add", "/edit/{id}"})
    public String processStudentForm(@ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/student/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        studentService.delete(studentService.getOne(id).get()  );

        return "redirect:/student/list" ;
    }

}
