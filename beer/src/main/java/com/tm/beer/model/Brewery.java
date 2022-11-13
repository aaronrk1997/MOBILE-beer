package com.tm.beer.model;

import javax.persistence.*;

@Entity
@Table(name = "brewery", indexes = @Index(columnList = "breweryidId"))
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

    //TODO ADD RELATION TO BEER HERE

    //---------------Constructors-----------------
    public Brewery() {
        //Empty Constructor for jpa
    }

    public Brewery(String name, String description, String logo) {
        Name = name;
        Description = description;
        Logo = logo;
    }

    //---------------Getters and Setters-----------------

    public Long getBreweryId() {
        return this.breweryId;
    }

    public String getName() {
        return this.Name;
    }

    private void setName(String name) {
        this.Name = name;
    }

    public String getDescription() {
        return this.Description;
    }

    private void setDescription(String description) {
        this.Description = description;
    }

    public String getLogo() {
        return this.Logo;
    }

    private void setLogo(String logo) {
        this.Logo = logo;
    }
    
}
