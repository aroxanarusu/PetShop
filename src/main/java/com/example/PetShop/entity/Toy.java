package com.example.PetShop.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Toy extends Accessory{

    @Column
    private String type;

    @Column
    private Integer size;

    public Toy(Long id, String name, String color, String petType, Integer price, String material, Integer weight, String type, Integer size) {
        super(id, name, color, petType, price, material, weight);
        this.type = type;
        this.size = size;
    }
}
