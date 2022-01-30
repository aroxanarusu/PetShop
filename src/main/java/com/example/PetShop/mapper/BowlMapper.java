package com.example.PetShop.mapper;

import com.example.PetShop.entity.Bowl;
import com.example.PetShop.rest.model.BowlDTO;
import org.springframework.stereotype.Component;

@Component
public class BowlMapper {

    public Bowl fromDtoToEntity(BowlDTO bowlDto) {return new Bowl(bowlDto.getId(), bowlDto.getName(), bowlDto.getColor(), bowlDto.getPetType(), bowlDto.getPrice(), bowlDto.getMaterial(),bowlDto.getWeight(), bowlDto.getVolume(), bowlDto.getShape());}

    public BowlDTO fromEntityToDto(Bowl bowl){return new BowlDTO(bowl.getId(), bowl.getName(), bowl.getColor(), bowl.getPetType(), bowl.getPrice(),bowl.getMaterial(), bowl.getWeight(), bowl.getVolume(), bowl.getShape(), "Bol de mancare pentru animale");}
}
