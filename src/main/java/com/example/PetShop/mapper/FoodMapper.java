package com.example.PetShop.mapper;

import com.example.PetShop.entity.Food;
import com.example.PetShop.rest.model.FoodDTO;
import org.springframework.stereotype.Component;

@Component
public class FoodMapper {

//    public Food fromDtoToEntity(FoodDTO foodDto){return new Food(foodDto.getId(), foodDto.getFoodType(), foodDto.getDescription(), foodDto.getWeight(), foodDto.getFlavour(), foodDto.getPetType());}

    public FoodDTO fromEntityToDto(Food food){return new FoodDTO(food.getId(), food.getFoodType(), food.getDescription(), food.getWeight(), food.getFlavour(), food.getPetType());}

}
