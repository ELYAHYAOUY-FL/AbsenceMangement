package com.example.Atelier8.controller;

import com.example.Atelier8.persistence.Seance;
import com.example.Atelier8.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/seance")
public class SeanceController {
    @Autowired
    SeanceService seanceService ;

}
