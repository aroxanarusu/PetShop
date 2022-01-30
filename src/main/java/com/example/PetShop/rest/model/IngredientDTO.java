package com.example.PetShop.rest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {

    private Long id;

    private String name;

    private Double price;

    private Integer maxTemp;

    private Integer minTemp;
}
