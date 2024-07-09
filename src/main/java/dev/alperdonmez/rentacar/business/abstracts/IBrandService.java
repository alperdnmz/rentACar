package dev.alperdonmez.rentacar.business.abstracts;

import dev.alperdonmez.rentacar.entities.concretes.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> getAll();
}
