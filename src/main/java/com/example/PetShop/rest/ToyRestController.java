package com.example.PetShop.rest;

import com.example.PetShop.entity.Toy;
import com.example.PetShop.mapper.ToyMapper;
import com.example.PetShop.repository.ToyRepository;
import com.example.PetShop.rest.model.ToyDTO;
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
public class ToyRestController {

    private static final Logger logger = LogManager.getLogger(ToyRestController.class);

    @Autowired
    ToyRepository toyRepository;

    @Autowired
    ToyMapper toyMapper;

    @GetMapping("/get-toys")
    public ResponseEntity<Iterable<Toy>> getToys() {
        logger.info("Getting all toys");
        return new ResponseEntity<>(toyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-toy/{id}")
    public ResponseEntity<ToyDTO> getToyById(@PathVariable Long id) {
        logger.info("Getting toy with id {}.", id);
        final Optional<Toy> optionalToy = toyRepository.findById(id);
        return optionalToy.map(toy -> new ResponseEntity<>(toyMapper.fromEntityToDto(toy), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @PostMapping("/create-toy")
    public ResponseEntity<Toy> createToy(@RequestBody Toy toy) {
        try {
            logger.info("New toy has been created.");
            return new ResponseEntity<>(toyRepository.save(toy), HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            logger.error("DataIntegrityViolationException: toy {} already exists", toy.getName());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-toy/{id}")
    public ResponseEntity<Void> deleteToy(@PathVariable Long id) {
        try {
            logger.info("The toy with id {} has been deleted", id);
            toyRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            logger.error("EmptyResultDataAccessException: toy with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/update-toy/{id}")
    public ResponseEntity<Void> updateToy(@PathVariable Long id, @RequestBody Toy toy) {
        final Optional<Toy> optionalToy = toyRepository.findById(id);
        if (optionalToy.isPresent()) {
            logger.info("The toy with id {} has been updated", id);
            toyRepository.update(toy.getName(), toy.getColor(), toy.getPetType(), toy.getPrice(), toy.getMaterial(), toy.getWeight(), toy.getType(), toy.getToySize(), id);
            return ResponseEntity.ok().build();
        } else {
            logger.error("EmptyResultDataAccessException: toy with id {} doesn't exists", id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
