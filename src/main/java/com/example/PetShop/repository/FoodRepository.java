package com.example.PetShop.repository;

import com.example.PetShop.entity.Food;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FoodRepository extends CrudRepository<Food, Long> {

    @Transactional
    @Modifying
    @Query("update Food f set f.foodType = ?1 , f.description = ?2 , f.weight = ?3 , f.flavour = ?4 , f.petType = ?5  where f.id = ?6")
    void update(String foodType, String description, Integer weight, String flavour, String petType, Long id);
}
