package com.tm.beer.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "brewery")
public class Brewery {

    //---------------Attributes-----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "breweryId")
    private Long breweryId;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Description")
    private String Description;

    @Column(name = "Logo")
    private String Logo;

    @OneToMany(mappedBy = "brewery", cascade = CascadeType.ALL)
    private List<Beer> beers;

    //---------------Constructors-----------------
    public Brewery() {
        //Empty Constructor for jpa
    }

    public Brewery(String name, String description, String logo, List<Beer> beers) {
        setName(name);
        setDescription(description);
        setLogo(logo);
        setBeers(beers);
    }

    //---------------Getters and Setters-----------------

    public Long getBreweryId() {
        return this.breweryId;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getLogo() {
        return this.Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }

    public List<Beer> getBeers() {
        return this.beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
    

    //---------------Use cases-----------------


}
