package com.example.PetShop.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FoodDTO {

    private Long id;

    private String foodType;

    private String description;

    private Integer weight;

    private String flavour;

    private String petType;
}
