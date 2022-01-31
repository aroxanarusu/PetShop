package com.example.PetShop.mapper;

import com.example.PetShop.entity.Ingredient;
import com.example.PetShop.rest.model.IngredientDTO;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper {

//    public Ingredient fromDtoToEntity(IngredientDTO ingredientDto){return new Ingredient(ingredientDto.getId(), ingredientDto.getName(), ingredientDto.getPrice(), ingredientDto.getMaxTemp(), ingredientDto.getMinTemp());}

    public IngredientDTO fromEntityToDto(Ingredient ingredient){return new IngredientDTO(ingredient.getId(), ingredient.getName(), ingredient.getPrice(), ingredient.getMaxTemp(), ingredient.getMinTemp());}

}
