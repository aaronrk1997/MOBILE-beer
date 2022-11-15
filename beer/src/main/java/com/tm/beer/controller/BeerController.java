package com.tm.beer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tm.beer.model.Beer;
import com.tm.beer.model.Brewery;
import com.tm.beer.repository.BeerRepository;
import com.tm.beer.repository.BreweryRepository;

@RestController
//@RequestMapping("/api/userprofile")
public class BeerController {

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private BreweryRepository breweryRepository;

    @GetMapping("/beers/{name}")
    public  Beer getBeerByName(@PathVariable String name) {
        return beerRepository.findBeerByName(name);
    }

    @GetMapping("/beers/search/{name}")
    public List<Beer> getBeersByNameContaining(@PathVariable String name) {
        return beerRepository.findBeerByNameContaining(name);
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @PostMapping("/beers")
    public Beer createBeer(@RequestBody Beer beer) {
        return beerRepository.save(beer);
    }

    @PutMapping("/beers/{name}")
    public Beer updateBeer(@PathVariable String name, @RequestBody Beer beer) {
        Beer beerToUpdate = beerRepository.findBeerByName(name);
        beerToUpdate.setName(beer.getName());
        beerToUpdate.setDescription(beer.getDescription());
        beerToUpdate.setPicture(beer.getPicture());
        beerToUpdate.setBarcode(beer.getBarcode());
        beerToUpdate.setAlcoholpercentage(beer.getAlcoholpercentage());
        beerToUpdate.setBrewery(beer.getBrewery());
        beerToUpdate.setType(beer.getType());
        return beerRepository.save(beerToUpdate);
    }

    @DeleteMapping("/beers/{name}")
    public void deleteBeer(@PathVariable String name) {
        beerRepository.delete(beerRepository.findBeerByName(name));
    }

    @GetMapping("/breweries/{name}")
    public  Brewery getBreweryByName(@PathVariable String name) {
        return breweryRepository.findBreweryByName(name);
    }

    @GetMapping("/breweries/search/{name}")
    public List<Brewery> getBreweriesByNameContaining(@PathVariable String name) {
        return breweryRepository.findBreweryByNameContaining(name);
    }

    @GetMapping("/breweries")
    public List<Brewery> getAllBreweries() {
        return breweryRepository.findAll();
    }

    @PostMapping("/breweries")
    public Brewery createBrewery(@RequestBody Brewery brewery) {
        return breweryRepository.save(brewery);
    }

    @PutMapping("/breweries/{name}")
    public Brewery updateBrewery(@PathVariable String name, @RequestBody Brewery brewery) {
        Brewery breweryToUpdate = breweryRepository.findBreweryByName(name);
        breweryToUpdate.setName(brewery.getName());
        breweryToUpdate.setDescription(brewery.getDescription());
        breweryToUpdate.setLogo(brewery.getLogo());
        breweryToUpdate.setBeers(brewery.getBeers());

        return breweryRepository.save(breweryToUpdate);
    }

    @DeleteMapping("/breweries/{name}")
    public void deleteBrewery(@PathVariable String name) {
        breweryRepository.delete(breweryRepository.findBreweryByName(name));
    }


    
}
