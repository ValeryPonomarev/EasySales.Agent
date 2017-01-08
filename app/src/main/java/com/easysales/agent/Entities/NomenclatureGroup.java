package com.easysales.agent.Entities;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class NomenclatureGroup extends Entity {

    private String name;

    public NomenclatureGroup(Object key) {
        super(key);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
