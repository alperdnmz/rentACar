package dev.alperdonmez.rentacar.business.abstracts;

import dev.alperdonmez.rentacar.business.requests.CreateBrandRequest;
import dev.alperdonmez.rentacar.business.requests.UpdateBrandRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllBrandsResponse;
import dev.alperdonmez.rentacar.business.responses.GetByIdBrandResponse;
import dev.alperdonmez.rentacar.entities.concretes.Brand;

import java.util.List;

public interface IBrandService {
    List<GetAllBrandsResponse> getAll();
    GetByIdBrandResponse getById(int id);
    void add(CreateBrandRequest createBrandRequest);
    void update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);
}
