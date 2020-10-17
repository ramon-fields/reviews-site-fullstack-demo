package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.repositories.DesignerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class DesignerController {

    @Resource
    private DesignerRepository designerRepo;

    @RequestMapping("/designers")
    public String displayDesigners(Model model) {
        model.addAttribute("designers",designerRepo.findAll());
        return "designersView";
    }
}
