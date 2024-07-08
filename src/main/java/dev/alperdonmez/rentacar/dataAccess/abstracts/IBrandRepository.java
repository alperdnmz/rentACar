package dev.alperdonmez.rentacar.dataAccess.abstracts;

import dev.alperdonmez.rentacar.entities.concretes.Brand;

import java.util.List;

public interface IBrandRepository {
    List<Brand> getAll();
}
