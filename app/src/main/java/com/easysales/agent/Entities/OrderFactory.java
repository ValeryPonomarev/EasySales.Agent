package com.easysales.agent.Entities;

import android.database.Cursor;

import java.util.Date;

import easysales.androidorm.Entity.IEntityFactory;

/**
 * Created by drmiller on 16.12.2016.
 */
public class OrderFactory implements IEntityFactory<OrderDoc> {

    public static class FieldNames
    {
        public static final String Key = "_id";
        public static final String Number = "Number";
        public static final String Date = "Date";
        public static final String Type = "Type";
        public static final String State = "State";
        public static final String Customer = "Customer";
        public static final String LocationLatitude = "LocationLatitude";
        public static final String LocationLongitude = "LocationLongitude";
    }

    @Override
    public OrderDoc BuildEntity(Cursor cursor) {
        OrderDoc order = new OrderDoc(cursor.getInt(cursor.getColumnIndex(FieldNames.Key)));
        order.setNumber(cursor.getString(cursor.getColumnIndex(FieldNames.Number)));
        order.setDate(new Date(cursor.getLong(cursor.getColumnIndex(FieldNames.Date))));
        order.setType(OrderType.valueOf(cursor.getInt(cursor.getColumnIndex(FieldNames.Type))));
        order.setState(OrderState.valueOf(cursor.getInt(cursor.getColumnIndex(FieldNames.State))));
        order.setCustomer(null);
        order.setLocation(cursor.getDouble(cursor.getColumnIndex(FieldNames.LocationLatitude)), cursor.getDouble(cursor.getColumnIndex(FieldNames.LocationLongitude)));
        return order;
    }
}
