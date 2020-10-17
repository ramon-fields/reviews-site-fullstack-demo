package com.example.fullstackdemo.controllers;

import com.example.fullstackdemo.models.Brand;
import com.example.fullstackdemo.repositories.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Optional;

@Controller
public class BrandController {

    @Resource
    private BrandRepository brandRepo;

    @RequestMapping("/brands")
    public String displayBrands(Model model) {
        model.addAttribute("brands",brandRepo.findAll());
        return "brandsView";
    }

    @GetMapping("/brands/{id}")
    public String displaySingleBrand(@PathVariable long id, Model model) {
        Optional<Brand> retrievedBrand = brandRepo.findById(id);
        Brand foundBrand = retrievedBrand.get();
        model.addAttribute("brand", foundBrand);
        return "brandView";
    }
}