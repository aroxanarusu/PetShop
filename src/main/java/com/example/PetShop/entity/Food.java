package com.example.PetShop.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Food")

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String foodType;

    @Column
    private String description;

    @Column
    private Integer weight;

    @Column
    private String flavour;

    @Column
    private String petType;

    @ManyToMany(targetEntity = Ingredient.class, cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JsonManagedReference
    private List<Ingredient> ingredients = new ArrayList<>();

    public void addIngerdientToFood(Ingredient ingredient) {
        ingredients.add(ingredient);
        ingredient.addFoodToIngredient(this);
    }

    public Food(Long id, String foodType, String description, Integer weight, String flavour, String petType) {
        this.id = id;
        this.foodType = foodType;
        this.description = description;
        this.weight = weight;
        this.flavour = flavour;
        this.petType = petType;
    }
}
