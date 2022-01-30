package com.example.PetShop.rest;


import com.example.PetShop.entity.Bowl;
import com.example.PetShop.mapper.BowlMapper;
import com.example.PetShop.repository.BowlRepository;
import com.example.PetShop.rest.model.BowlDTO;
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
public class BowlRestController {

    private static final Logger logger = LogManager.getLogger(BowlRestController.class);

    @Autowired
    BowlRepository bowlRepository;

    @Autowired
    BowlMapper bowlMapper;

    @GetMapping("/get-bowls")
    public ResponseEntity<Iterable<Bowl>> getBowls() {
        logger.info("Getting all bowls");
        return new ResponseEntity<>(bowlRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-bowl/{id}")
    public ResponseEntity<BowlDTO> getBowlById(@PathVariable Long id) {
        final Optional<Bowl> optionalBowl = bowlRepository.findById(id);
        return optionalBowl.map(bowl -> new ResponseEntity<>(bowlMapper.fromEntityToDto(bowl), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-bowl")
    public ResponseEntity<Bowl> createBowl(@RequestBody Bowl bowl) {
        try {
            return new ResponseEntity<>(bowlRepository.save(bowl), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: bowl {} already exists", bowl.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-bowl/{id}")
    public ResponseEntity<Void> deleteBowl(@PathVariable Long id) {
        try {
            bowlRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException e) {
            logger.error("EmptyResultDataAccessException: bowl with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-bowl/{id}")
    public ResponseEntity<Void> updateBowl(@PathVariable Long id, @RequestBody Bowl bowl) {
        bowlRepository.update(bowl.getName(), bowl.getColor(), bowl.getPetType(), bowl.getPrice(), bowl.getMaterial(), bowl.getWeight(), bowl.getVolume(), bowl.getShape(), id);
        return ResponseEntity.ok().build();
    }

}
