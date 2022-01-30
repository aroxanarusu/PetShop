package com.example.PetShop.mapper;

import com.example.PetShop.entity.Toy;
import com.example.PetShop.rest.model.ToyDTO;
import org.springframework.stereotype.Component;

@Component
public class ToyMapper {

    public Toy fromDtoToEntity(ToyDTO toyDto) {return new Toy(toyDto.getId(), toyDto.getName(), toyDto.getColor(), toyDto.getPetType(), toyDto.getPrice(), toyDto.getMaterial(),toyDto.getWeight(), toyDto.getType(), toyDto.getSize());}
    public ToyDTO fromEntityToDto(Toy toy){return new ToyDTO(toy.getId(), toy.getName(), toy.getColor(), toy.getPetType(), toy.getPrice(), toy.getMaterial(),toy.getWeight(), toy.getType(), toy.getSize(), "Jucarie pentru animale");}
}
