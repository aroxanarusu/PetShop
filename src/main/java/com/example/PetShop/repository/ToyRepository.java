package com.example.PetShop.repository;

import com.example.PetShop.entity.Toy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ToyRepository extends CrudRepository<Toy, Long> {

    @Transactional
    @Modifying
    @Query("update Toy t set t.name = ?1 , t.color = ?2 , t.petType = ?3 , t.price = ?4 , t.material = ?5 , t.weight = ?6 , t.type = ?7 , t.size= ?8  where t.id = ?9")
    void update(String name, String color, String petType, Integer price, String material, Integer weight, String type, Integer size, Long id);
}
