package com.example.PetShop.rest;

import com.example.PetShop.entity.Ingredient;
import com.example.PetShop.mapper.IngredientMapper;
import com.example.PetShop.repository.IngredientRepository;
import com.example.PetShop.rest.model.IngredientDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class IngredientRestController {

    private static final Logger logger = LogManager.getLogger(IngredientRestController.class);

    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    IngredientMapper ingredientMapper;

    @GetMapping("/get-ingredients")
    public ResponseEntity<Iterable<Ingredient>> getIngredients() {
        logger.info("Getting all ingredients");
        return new ResponseEntity<>(ingredientRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-ingredient/{id}")
    public ResponseEntity<IngredientDTO> getIngredientById(@PathVariable Long id) {
        logger.info("Getting ingredient with id {}.", id);
        final Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        return optionalIngredient.map(ingredient -> new ResponseEntity<>(ingredientMapper.fromEntityToDto(ingredient), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-ingredient")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        try {
            logger.info("New ingredient has been created.");
            return new ResponseEntity<>(ingredientRepository.save(ingredient), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: ingredient {} already exists", ingredient.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-ingredient/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id) {
        try {
            logger.info("The ingredient with id {} has been deleted", id);
            ingredientRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            logger.error("EmptyResultDataAccessException: ingredient with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-ingredient/{id}")
    public ResponseEntity<Void> updateIngredient(@PathVariable Long id, @RequestBody Ingredient ingredient) {
        final Optional<Ingredient> optionalIngredient = ingredientRepository.findById(id);
        if (optionalIngredient.isPresent()) {
            logger.info("The ingredient with id {} has been updated", id);
            ingredientRepository.update(ingredient.getName(), ingredient.getPrice(), ingredient.getMaxTemp(), ingredient.getMinTemp(), id);
            return ResponseEntity.ok().build();
        } else {
            logger.error("EmptyResultDataAccessException: ingredient with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
