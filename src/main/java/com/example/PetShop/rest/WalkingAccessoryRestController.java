package com.example.PetShop.rest;

import com.example.PetShop.entity.Toy;
import com.example.PetShop.entity.WalkingAccessory;
import com.example.PetShop.mapper.WalkingAccessoryMapper;
import com.example.PetShop.repository.WalkingAccessoryRepository;
import com.example.PetShop.rest.model.ToyDTO;
import com.example.PetShop.rest.model.WalkingAccessoryDTO;
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
public class WalkingAccessoryRestController {

    private static final Logger logger = LogManager.getLogger(WalkingAccessoryRestController.class);

    @Autowired
    WalkingAccessoryRepository walkingAccessoryRepository;

    @Autowired
    WalkingAccessoryMapper walkingAccessoryMapper;

    @GetMapping("/get-walkingAccessories")
    public ResponseEntity<Iterable<WalkingAccessory>> getWalkingAccessory() {
        logger.info("Getting all accessories");
        return new ResponseEntity<>(walkingAccessoryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-walkingAccessory/{id}")
    public ResponseEntity<WalkingAccessoryDTO> getWalkingAccessoryById(@PathVariable Long id) {
        final Optional<WalkingAccessory> optionalWalkingAccessory = walkingAccessoryRepository.findById(id);
        return optionalWalkingAccessory.map(walkingAccessory -> new ResponseEntity<>(walkingAccessoryMapper.fromEntityToDto(walkingAccessory), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-walkingAccessory")
    public ResponseEntity<WalkingAccessory> createWalkingAccessory(@RequestBody WalkingAccessory walkingAccessory) {
        try {
            return new ResponseEntity<>(walkingAccessoryRepository.save(walkingAccessory), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: walking accessory {} already exists", walkingAccessory.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-walkingAccessory/{id}")
    public ResponseEntity<Void> deleteWalkingAccessory(@PathVariable Long id) {
        try {
            walkingAccessoryRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException e) {
            logger.error("EmptyResultDataAccessException: walking accessory with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-walkingAccessory/{id}")
    public ResponseEntity<Void> updateWalkingAccessory(@PathVariable Long id, @RequestBody WalkingAccessory walkingAccessory) {
        walkingAccessoryRepository.update(walkingAccessory.getName(), walkingAccessory.getColor(), walkingAccessory.getPetType(), walkingAccessory.getPrice(), walkingAccessory.getMaterial(), walkingAccessory.getWeight(), walkingAccessory.getType(), walkingAccessory.getLength(), walkingAccessory.getSize(), id);
        return ResponseEntity.ok().build();
    }
}
