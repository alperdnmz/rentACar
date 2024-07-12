package dev.alperdonmez.rentacar.business.concretes;

import dev.alperdonmez.rentacar.business.abstracts.IModelService;
import dev.alperdonmez.rentacar.business.requests.CreateModelRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllModelResponse;
import dev.alperdonmez.rentacar.core.utilities.mappers.IModelMapperService;
import dev.alperdonmez.rentacar.dataAccess.abstracts.IModelRepository;
import dev.alperdonmez.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements IModelService {

    private IModelRepository modelRepository;
    private IModelMapperService modelMapperService;

    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> modelsResponse = models.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllModelResponse.class)).collect(Collectors.toList());
        return modelsResponse;
    }

    @Override
    public void add(CreateModelRequest createModelRequest) {
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);

        this.modelRepository.save(model);
    }

}
