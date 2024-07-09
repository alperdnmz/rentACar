package dev.alperdonmez.rentacar.business.concretes;

import dev.alperdonmez.rentacar.business.abstracts.IBrandService;
import dev.alperdonmez.rentacar.dataAccess.abstracts.IBrandRepository;
import dev.alperdonmez.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements IBrandService {
    private IBrandRepository brandRepository;

    @Autowired
    public BrandManager(IBrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAll() {
        return brandRepository.getAll();
    }
}
