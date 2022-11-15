package com.tm.beer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.beer.model.Beer;
import com.tm.beer.utils.enums.BeerType;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    Beer findBeerByBeerName(String beerName);
    List<Beer> findBeerByType(BeerType type);
    List<Beer> findBeerByNameContaining(String name);

}