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

}
