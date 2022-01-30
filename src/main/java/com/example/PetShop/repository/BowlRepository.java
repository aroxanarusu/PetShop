package com.example.PetShop.repository;

import com.example.PetShop.entity.Bowl;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface BowlRepository extends CrudRepository<Bowl, Long> {

    @Transactional
    @Modifying
    @Query("update Bowl b set b.name = ?1 , b.color = ?2 , b.petType = ?3 , b.price = ?4 , b.material = ?5 , b.weight = ?6 , b.volume = ?7 , b.shape= ?8  where b.id = ?9")
    void update(String name, String color, String petType, Integer price, String material, Integer weight, Double volume, String shape, Long id);
}
