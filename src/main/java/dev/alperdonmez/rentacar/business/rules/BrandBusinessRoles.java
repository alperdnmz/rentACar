package dev.alperdonmez.rentacar.business.rules;

import dev.alperdonmez.rentacar.core.utilities.exceptions.BusinessException;
import dev.alperdonmez.rentacar.dataAccess.abstracts.IBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandBusinessRoles {
    private IBrandRepository brandRepository;

    public void checkIfBrandNameExists(String name) {
        if(this.brandRepository.existsByName(name)){
            throw new BusinessException("Brand " + name + " already exists");
        }
    }
}
