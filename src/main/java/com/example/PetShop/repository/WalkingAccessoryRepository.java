package com.example.PetShop.repository;

import com.example.PetShop.entity.WalkingAccessory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface WalkingAccessoryRepository extends CrudRepository<WalkingAccessory, Long> {

    @Transactional
    @Modifying
    @Query("update WalkingAccessory w set w.name = ?1 , w.color = ?2 , w.petType = ?3 , w.price = ?4 , w.material = ?5 , w.weight = ?6 , w.type = ?7 , w.length = ?8, w.size= ?9  where w.id = ?10")
    void update(String name, String color, String petType, Integer price, String material, Integer weight, String type, Integer length, String size, Long id);
}
