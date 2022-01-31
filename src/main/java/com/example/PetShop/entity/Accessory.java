package com.example.PetShop.entity;

import lombok.*;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Accessory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Column
    private String color;

    @Column
    private String petType;

    @Column
    private Integer price;

    @Column
    private String material;

    @Column
    private Integer weight;
}
