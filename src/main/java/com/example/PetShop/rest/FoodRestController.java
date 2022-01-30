package com.example.PetShop.rest;


import com.example.PetShop.entity.Food;
import com.example.PetShop.entity.Ingredient;
import com.example.PetShop.mapper.FoodMapper;
import com.example.PetShop.mapper.IngredientMapper;
import com.example.PetShop.repository.FoodRepository;
import com.example.PetShop.repository.IngredientRepository;
import com.example.PetShop.rest.model.FoodDTO;
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
public class FoodRestController {

    private static final Logger logger = LogManager.getLogger(FoodRestController.class);

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodMapper foodMapper;

    @GetMapping("/get-foods")
    public ResponseEntity<Iterable<Food>> getFoods() {
        logger.info("Getting all foods");
        return new ResponseEntity<>(foodRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-food/{id}")
    public ResponseEntity<FoodDTO> getFoodById(@PathVariable Long id) {
        final Optional<Food> optionalFood = foodRepository.findById(id);
        return optionalFood.map(food -> new ResponseEntity<>(foodMapper.fromEntityToDto(food), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-food")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        try {
            return new ResponseEntity<>(foodRepository.save(food), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: food with id {} already exists", food.getId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-food/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        try {
            foodRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException e) {
            logger.error("EmptyResultDataAccessException: food with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-food/{id}")
    public ResponseEntity<Void> updateFood(@PathVariable Long id, @RequestBody Food food) {
        foodRepository.update(food.getFoodType(), food.getDescription(), food.getWeight(), food.getFlavour(), food.getPetType(),id);
        return ResponseEntity.ok().build();
    }
}
