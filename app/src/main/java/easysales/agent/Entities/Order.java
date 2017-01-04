package easysales.agent.Entities;

import android.location.Location;
import android.os.Parcel;

import java.util.Date;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class Order extends Entity {

    private String number;
    private Date date;
    private OrderType type;
    private OrderState state;
    private Customer customer;
    private Location location;

    public Order(Object key) {
        super(key);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
