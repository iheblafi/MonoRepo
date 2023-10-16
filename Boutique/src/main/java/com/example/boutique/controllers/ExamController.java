package com.example.boutique.controllers;

import com.example.boutique.entities.CentreCommercial;
import com.example.boutique.services.ExamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping("/center")
public class ExamController {
    private ExamServiceImpl examService;

    @Autowired
    public ExamController(ExamServiceImpl examService){
        this.examService= examService;
    }
    @PostMapping("/add")
    void addCentre(@RequestBody CentreCommercial centreCommercial) {
       examService.ajoutCentre(centreCommercial);
    }
}
