package dev.alperdonmez.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Table(name="brands")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brand_id")
    private int brand_id;

    @Column(name="name")
    private String name;

    /*public Brand() {
    }

    public Brand(int brand_id, String name) {
        this.brand_id = brand_id;
        this.name = name;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/
}
