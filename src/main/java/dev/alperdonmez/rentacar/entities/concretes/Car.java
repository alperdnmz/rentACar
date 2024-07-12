package dev.alperdonmez.rentacar.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

@Table(name="cars")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "plate", unique = true)
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state; // 1-Avaliable 2-Rented 3-Maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}
