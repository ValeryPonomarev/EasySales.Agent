package com.easysales.agent.Entities;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.Date;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 16.12.2016.
 */
public class OrderDoc extends Entity implements Parcelable {

    private String number;
    private Date date;
    private OrderType type;
    private OrderState state;
    private Customer customer;
    private Location location;

    public OrderDoc() {this(null);}

    public OrderDoc(Object key) {
        this(key, "", new Date(Calendar.getInstance().getTimeInMillis()), OrderType.Bid, OrderState.NoState, null, null);
    }

    public OrderDoc(Object key, String number, Date date, OrderType type, OrderState state, Customer customer, Location location){
        super(key);
        this.number = number;
        this.date = date;
        this.type = type;
        this.state = state;
        this.customer = customer;
        this.location = location;
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

    //region Parselable

    public static final Parcelable.Creator<OrderDoc> CREATOR = new Parcelable.Creator<OrderDoc>() {
        public OrderDoc createFromParcel(Parcel in) {
            return new OrderDoc(in);
        }

        public OrderDoc[] newArray(int size) {
            return new OrderDoc[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Object key = getKey();
        int intKey = 0;
        if(key != null) intKey = (int)key;

        dest.writeInt(intKey);
        dest.writeString(getNumber());
        dest.writeIntArray(new int[] { intKey, getType().getValue(), getState().getValue()});
        if(getCustomer() != null)
        {
            dest.writeInt((int)getCustomer().getKey());
        }
        dest.writeLong(getDate().getTime());
        dest.writeDoubleArray(new double[] {getLocation().getLatitude(), getLocation().getLongitude()});
    }
    //endregionb
}
