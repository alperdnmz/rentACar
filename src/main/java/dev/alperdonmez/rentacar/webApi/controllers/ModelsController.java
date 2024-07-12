package dev.alperdonmez.rentacar.webApi.controllers;

import dev.alperdonmez.rentacar.business.abstracts.IModelService;
import dev.alperdonmez.rentacar.business.requests.CreateModelRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllModelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
@AllArgsConstructor
public class ModelsController {
    private IModelService modelService;

    @GetMapping
    public List<GetAllModelResponse> getAll(){
        return modelService.getAll();
    }

    @PostMapping()
    @ResponseStatus(code= HttpStatus.CREATED)
    public void add(@RequestBody() CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }
}
