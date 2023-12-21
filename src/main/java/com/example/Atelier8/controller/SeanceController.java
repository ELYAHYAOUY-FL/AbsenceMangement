package com.example.Atelier8.controller;

import com.example.Atelier8.persistence.Seance;
import com.example.Atelier8.persistence.Student;
import com.example.Atelier8.services.SeanceService;
import com.example.Atelier8.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/seance")
public class SeanceController {
    @Autowired
    private SeanceService seanceService ;
    @GetMapping("/listsenace")
    public String getAllSeances(Model model) {
        List<Seance> Seances = seanceService.getAll();
        model.addAttribute("Seances", Seances); // Add retrieved students to the model
        return "ListSeance"; // Return the name of your Thymeleaf HTML file
    }

    @GetMapping("/addSeance")
    public String index(Model model) {
        model.addAttribute("seance", new Seance());
        return "AddSeances";
    }

    @PostMapping("/saveSeance")
    public String save(@ModelAttribute("seance") Seance seance) {
        seanceService.save(seance);
        return "redirect:/seance/listsenace";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Optional<Seance> seance = seanceService.getOne(id);
        model.addAttribute("seance", seance);
        return "AddSeances"; // Assuming your Thymeleaf template is named "addStudent.html"
    }

    // Handle form submission for both add and edit
    @PostMapping({"/add", "/edit/{id}"})
    public String processStudentForm(@ModelAttribute Seance seance) {
        seanceService.save(seance);
        return "redirect:/seance/listsenace";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id){
        seanceService.delete(seanceService.getOne(id).get()  );

        return "redirect:/seance/listsenace" ;
    }

}
