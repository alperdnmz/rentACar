package dev.alperdonmez.rentacar.dataAccess.abstracts;

import dev.alperdonmez.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IModelRepository extends JpaRepository<Model, Integer> {
}
