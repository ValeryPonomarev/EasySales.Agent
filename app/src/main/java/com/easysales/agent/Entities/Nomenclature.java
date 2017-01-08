package com.easysales.agent.Entities;

import android.media.Image;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class Nomenclature extends Entity {

    private String name;
    private Image image;
    private double price;
    private NomenclatureGroup group;

    public Nomenclature(Object key) {
        super(key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public NomenclatureGroup getGroup() {
        return group;
    }

    public void setGroup(NomenclatureGroup group) {
        this.group = group;
    }
}
