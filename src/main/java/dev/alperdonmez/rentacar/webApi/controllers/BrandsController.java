package dev.alperdonmez.rentacar.webApi.controllers;

import dev.alperdonmez.rentacar.business.abstracts.IBrandService;
import dev.alperdonmez.rentacar.business.requests.CreateBrandRequest;
import dev.alperdonmez.rentacar.business.requests.UpdateBrandRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllBrandsResponse;
import dev.alperdonmez.rentacar.business.responses.GetByIdBrandResponse;
import dev.alperdonmez.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController{
    private IBrandService brandService;

   /* @Autowired
    public BrandsController(IBrandService brandService) {
        this.brandService = brandService;
    }*/

    @GetMapping()
    public List <GetAllBrandsResponse> getAll(){
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    public GetByIdBrandResponse getById(@PathVariable int id){
        return brandService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody() CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PutMapping
    public void update(@RequestBody() UpdateBrandRequest updateBrandRequest){
        this.brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.brandService.delete(id);
    }
}
