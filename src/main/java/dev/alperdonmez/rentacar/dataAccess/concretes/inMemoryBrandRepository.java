package dev.alperdonmez.rentacar.dataAccess.concretes;

import dev.alperdonmez.rentacar.dataAccess.abstracts.IBrandRepository;
import dev.alperdonmez.rentacar.entities.concretes.Brand;

import java.util.ArrayList;
import java.util.List;

public class inMemoryBrandRepository implements IBrandRepository {
    List<Brand> brands;

    public inMemoryBrandRepository() {
        brands = new ArrayList<Brand>();
        brands.add(new Brand(1,"BMW"));
        brands.add(new Brand(2,"Audi"));
        brands.add(new Brand(3,"Ford"));
        brands.add(new Brand(4,"Honda"));
        brands.add(new Brand(5,"Hyundai"));
    }

    @Override
    public List<Brand> getAll() {
        return List.of();
    }
}
