package dev.alperdonmez.rentacar.business.abstracts;

import dev.alperdonmez.rentacar.business.requests.CreateModelRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllModelResponse;

import java.util.List;

public interface IModelService {
    List<GetAllModelResponse> getAll();
    void add(CreateModelRequest createModelRequest);
}
