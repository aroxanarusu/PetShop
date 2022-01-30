package com.example.PetShop.repository;

import com.example.PetShop.entity.Ingredient;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    @Transactional
    @Modifying
    @Query("update Ingredient i set i.name = ?1 , i.price = ?2 , i.maxTemp = ?3 , i.minTemp = ?4 where i.id = ?5")
    void update(String name, Double price, Integer maxTemp, Integer minTemp, Long id);
}
