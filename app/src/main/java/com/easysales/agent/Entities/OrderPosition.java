package com.easysales.agent.Entities;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class OrderPosition extends Entity {

    private OrderDoc order;
    private Nomenclature nomenclature;
    private double price;
    private int count;

    public OrderPosition(Object key) {
        super(key);
    }

    public OrderDoc getOrder() {
        return order;
    }

    public void setOrder(OrderDoc order) {
        this.order = order;
    }

    public Nomenclature getNomenclature() {
        return nomenclature;
    }

    public void setNomenclature(Nomenclature nomenclature) {
        this.nomenclature = nomenclature;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
