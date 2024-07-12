package dev.alperdonmez.rentacar.dataAccess.abstracts;

import dev.alperdonmez.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
    boolean existsByName(String name);
}
