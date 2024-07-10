package dev.alperdonmez.rentacar.business.concretes;

import dev.alperdonmez.rentacar.business.abstracts.IBrandService;
import dev.alperdonmez.rentacar.business.requests.CreateBrandRequest;
import dev.alperdonmez.rentacar.business.requests.UpdateBrandRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllBrandsResponse;
import dev.alperdonmez.rentacar.business.responses.GetByIdBrandResponse;
import dev.alperdonmez.rentacar.core.utilities.mappers.IModelMapperService;
import dev.alperdonmez.rentacar.dataAccess.abstracts.IBrandRepository;
import dev.alperdonmez.rentacar.entities.concretes.Brand;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements IBrandService {
    private IBrandRepository brandRepository;
    private IModelMapperService modelMapperService;

    @Autowired
    public BrandManager(IBrandRepository brandRepository, IModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();

       /* List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for(Brand brand : brands){
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setBrand_id(brand.getBrand_id());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);
        }*/

        List<GetAllBrandsResponse> brandsResponse = brands.stream().map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
        return brandsResponse;
    }

    @Override
    public GetByIdBrandResponse getById(int id) {
        Brand brand = this.brandRepository.findById(id).orElseThrow();
        GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
        return response;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        /*Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());*/

        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);

        this.brandRepository.save(brand);
    }

    @Override
    public void update(UpdateBrandRequest updateBrandRequest) {
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);
    }
}
