package com.example.PetShop.mapper;

import com.example.PetShop.entity.WalkingAccessory;
import com.example.PetShop.rest.model.WalkingAccessoryDTO;
import org.springframework.stereotype.Component;

@Component
public class WalkingAccessoryMapper {


    public WalkingAccessory fromDtoToEntity(WalkingAccessoryDTO walkingAccessoryDTO) {return new WalkingAccessory(walkingAccessoryDTO.getId(), walkingAccessoryDTO.getName(), walkingAccessoryDTO.getColor(), walkingAccessoryDTO.getPetType(), walkingAccessoryDTO.getPrice(), walkingAccessoryDTO.getMaterial(),walkingAccessoryDTO.getWeight(), walkingAccessoryDTO.getType(), walkingAccessoryDTO.getLength(),walkingAccessoryDTO.getSize());}
    public WalkingAccessoryDTO fromEntityToDto(WalkingAccessory walkingAccessory){return new WalkingAccessoryDTO(walkingAccessory.getId(), walkingAccessory.getName(), walkingAccessory.getColor(), walkingAccessory.getPetType(), walkingAccessory.getPrice(), walkingAccessory.getMaterial(),walkingAccessory.getWeight(), walkingAccessory.getType(), walkingAccessory.getLength(),walkingAccessory.getSize(), "Accesori pentru plimbarea animalelor");}
}
