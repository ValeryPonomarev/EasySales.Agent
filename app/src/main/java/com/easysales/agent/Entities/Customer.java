package com.easysales.agent.Entities;

import android.location.Location;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class Customer extends Entity {
    private String name;
    private Location location;

    public Customer() {this(null);}

    public Customer(Object key) {
        this(key, "", null);
    }

    public Customer(Object key, String name, Location location){
        super(key);
        this.name = name;
        this.location = location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setLocation(double latitude, double longitude) {
        this.location = new Location("dummyprovider");
        location.setLatitude(latitude);
        location.setLongitude(longitude);
    }
}
