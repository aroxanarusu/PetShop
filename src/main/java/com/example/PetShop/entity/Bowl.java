package com.example.PetShop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Bowl extends Accessory{

    @Column
    private Double volume;

    @Column
    private String shape;

    public Bowl(Long id, String name, String color, String petType, Integer price, String material, Integer weight, Double volume, String shape) {
        super(id, name, color, petType, price, material, weight);
        this.volume = volume;
        this.shape = shape;
    }

    public Bowl( String name, String color, String petType, Integer price,  Integer weight, Double volume, String shape) {
        super(name, color, petType, price, weight);
        this.volume = volume;
        this.shape = shape;
    }

}
