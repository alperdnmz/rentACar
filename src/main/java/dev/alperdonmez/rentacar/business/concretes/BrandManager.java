package dev.alperdonmez.rentacar.business.concretes;

import dev.alperdonmez.rentacar.business.abstracts.IBrandService;
import dev.alperdonmez.rentacar.business.requests.CreateBrandRequest;
import dev.alperdonmez.rentacar.business.responses.GetAllBrandsResponse;
import dev.alperdonmez.rentacar.dataAccess.abstracts.IBrandRepository;
import dev.alperdonmez.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements IBrandService {
    private IBrandRepository brandRepository;

    @Autowired
    public BrandManager(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
        for(Brand brand : brands){
            GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
            responseItem.setBrand_id(brand.getBrand_id());
            responseItem.setName(brand.getName());

            brandsResponse.add(responseItem);
        }
        return brandsResponse;
    }

    @Override
    public void add(CreateBrandRequest createBrandRequest) {
        Brand brand = new Brand();
        brand.setName(createBrandRequest.getName());
        this.brandRepository.save(brand);
    }
}
