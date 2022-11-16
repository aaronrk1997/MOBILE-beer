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

    @GetMapping("/beers/{beerName}")
    public  Beer getBeerByBeerName(@PathVariable String beerName) {
        return beerRepository.findBeerByBeerName(beerName);
    }

    @GetMapping("/beers/{beerId}")
    public  Beer getBeerByBeerId(@PathVariable String beerId) {
        return beerRepository.findBeerByBeerId(parseLong(beerId));
    }

    @GetMapping("/beers/search/{beerName}")
    public List<Beer> getBeersByBeerNameContaining(@PathVariable String beerName) {
        return beerRepository.findBeerByBeerNameContaining(beerName);
    }

    @GetMapping("/beers")
    public List<Beer> getAllBeers() {
        return beerRepository.findAll();
    }

    @PostMapping("/beers")
    public Beer createBeer(@RequestBody Beer beer) {
        return beerRepository.save(beer);
    }

    @PutMapping("/beers/{beerName}")
    public Beer updateBeer(@PathVariable String beerName, @RequestBody Beer beer) {
        Beer beerToUpdate = beerRepository.findBeerByBeerName(beerName);
        beerToUpdate.setName(beer.getName());
        beerToUpdate.setDescription(beer.getDescription());
        beerToUpdate.setPicture(beer.getPicture());
        beerToUpdate.setBarcode(beer.getBarcode());
        beerToUpdate.setAlcoholpercentage(beer.getAlcoholpercentage());
        beerToUpdate.setBrewery(beer.getBrewery());
        beerToUpdate.setType(beer.getType());
        return beerRepository.save(beerToUpdate);
    }

    @DeleteMapping("/beers/{beerName}")
    public void deleteBeer(@PathVariable String beerName) {
        beerRepository.delete(beerRepository.findBeerByBeerName(beerName));
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
