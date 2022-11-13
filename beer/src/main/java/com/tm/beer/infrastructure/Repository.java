package com.tm.beer.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tm.beer.model.Beer;

public interface Repository extends JpaRepository<Beer, Long> {
    
}
