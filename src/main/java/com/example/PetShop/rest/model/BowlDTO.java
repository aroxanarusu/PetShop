package com.example.PetShop.rest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BowlDTO {

    private Long id;

    private String name;

    private String color;

    private String petType;

    private Integer price;

    private String material;

    private Integer weight;

    private Double volume;

    private String shape;

    private String description;
}
