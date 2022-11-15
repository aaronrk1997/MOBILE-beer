package com.tm.beer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tm.beer.model.Brewery;

@Repository
public interface BreweryRepository extends JpaRepository<Brewery, Long> {
    Brewery findBreweryByName(String name);
    List <Brewery> findBreweryByNameContaining(String name);
}
