package com.example.PetShop.repository;

import com.example.PetShop.entity.Bowl;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepsitory extends CrudRepository<Bowl, Long> {
}
