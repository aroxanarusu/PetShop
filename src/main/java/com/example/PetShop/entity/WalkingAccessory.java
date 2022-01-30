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
public class WalkingAccessory extends Accessory{

    @Column
    private String type;

    @Column
    private Integer length;

    @Column
    private String size;

    public WalkingAccessory(Long id, String name, String color, String petType, Integer price, String material, Integer weight, String type, Integer length, String size) {
        super(id, name, color, petType, price, material, weight);
        this.type = type;
        this.length = length;
        this.size = size;
    }
}
