package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.models.Division;
import com.example.fullstackdemo.repositories.DivisionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class DivisionController {

    @Resource
    private DivisionRepository divisionRepo;

    @RequestMapping({"/divisions", "/",""})
    public String displayDivisions(Model model) {
        model.addAttribute("divisions",divisionRepo.findAll());
        return "divisionsView";
    }

    @GetMapping("/divisions/{type}")
    public String displaySingleDivision(@PathVariable String type, Model model) {
        Division retrievedDivision = divisionRepo.findDivisionByType(type);
        model.addAttribute("division", retrievedDivision);
        return "divisionView";
    }
}