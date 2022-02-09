package com.coffees.coffeesystem.repository;

import com.coffees.coffeesystem.domain.Coffee;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Coffee entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {}
