package com.coffees.coffeesystem.service;

import com.coffees.coffeesystem.domain.Coffee;
import com.coffees.coffeesystem.repository.CoffeeRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Coffee}.
 */
@Service
@Transactional
public class CoffeeService {

    private final Logger log = LoggerFactory.getLogger(CoffeeService.class);

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    /**
     * Save a coffee.
     *
     * @param coffee the entity to save.
     * @return the persisted entity.
     */
    public Coffee save(Coffee coffee) {
        log.debug("Request to save Coffee : {}", coffee);
        return coffeeRepository.save(coffee);
    }

    /**
     * Partially update a coffee.
     *
     * @param coffee the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Coffee> partialUpdate(Coffee coffee) {
        log.debug("Request to partially update Coffee : {}", coffee);

        return coffeeRepository
            .findById(coffee.getId())
            .map(existingCoffee -> {
                if (coffee.getCoffeeName() != null) {
                    existingCoffee.setCoffeeName(coffee.getCoffeeName());
                }
                if (coffee.getCoffeeType() != null) {
                    existingCoffee.setCoffeeType(coffee.getCoffeeType());
                }
                if (coffee.getCoffeeSize() != null) {
                    existingCoffee.setCoffeeSize(coffee.getCoffeeSize());
                }
                if (coffee.getCoffeePrice() != null) {
                    existingCoffee.setCoffeePrice(coffee.getCoffeePrice());
                }

                return existingCoffee;
            })
            .map(coffeeRepository::save);
    }

    /**
     * Get all the coffees.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Coffee> findAll(Pageable pageable) {
        log.debug("Request to get all Coffees");
        return coffeeRepository.findAll(pageable);
    }

    /**
     * Get one coffee by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Coffee> findOne(Long id) {
        log.debug("Request to get Coffee : {}", id);
        return coffeeRepository.findById(id);
    }

    /**
     * Delete the coffee by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Coffee : {}", id);
        coffeeRepository.deleteById(id);
    }
}
