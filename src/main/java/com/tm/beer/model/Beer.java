package com.tm.beer.model;


import javax.persistence.*;

import com.tm.beer.utils.enums.BeerType;

@Entity
@Table(name = "beer")
public class Beer {
    //---------------Attributes-----------------
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beerId")
    private Long beerId;

    @Column(unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "picture")
    private String picture;

    @Column(name = "barcode")
    private String barcode;

    @Column(name = "alcoholpercentage")
    private float alcoholpercentage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "breweryId")
    private Brewery brewery;

    private String type;

    //---------------Constructors-----------------
    public Beer() {
        //Empty Constructor for jpa
    }

    public Beer(String name, String description, String picture, String barcode, float alcoholpercentage, Brewery brewery, String type) {
        setName(name);
        setDescription(description);
        setPicture(picture);
        setBarcode(barcode);
        setAlcoholpercentage(alcoholpercentage);
        setBrewery(brewery);
        setType(type);
    }

    public Long getId() {
        return beerId;
    }

    public void setId(Long id) {
        this.beerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public float getAlcoholpercentage() {
        return alcoholpercentage;
    }

    public void setAlcoholpercentage(float alcoholpercentage) {
        this.alcoholpercentage = alcoholpercentage;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
