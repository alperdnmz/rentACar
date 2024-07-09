package dev.alperdonmez.rentacar.webApi.controllers;

import dev.alperdonmez.rentacar.business.abstracts.IBrandService;
import dev.alperdonmez.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController{
    private IBrandService brandService;

    @Autowired
    public BrandsController(IBrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public List <Brand> getAll(){
        return brandService.getAll();
    }
}
