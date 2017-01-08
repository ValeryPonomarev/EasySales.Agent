package com.easysales.agent.Entities;

import android.database.Cursor;
import easysales.androidorm.Entity.IEntityFactory;

/**
 * Created by drmiller on 16.12.2016.
 */
public class CustomerFactory implements IEntityFactory<Customer> {

    public static class FieldNames
    {
        public static final String Key = "_id";
        public static final String Name = "Name";
        public static final String LocationLatitude = "LocationLatitude";
        public static final String LocationLongitude = "LocationLongitude";
    }

    @Override
    public Customer BuildEntity(Cursor cursor) {
        Customer entity = new Customer(cursor.getInt(cursor.getColumnIndex(FieldNames.Key)));
        entity.setName(cursor.getString(cursor.getColumnIndex(FieldNames.Name)));
        entity.setLocation(cursor.getDouble(cursor.getColumnIndex(FieldNames.LocationLatitude)), cursor.getDouble(cursor.getColumnIndex(FieldNames.LocationLongitude)));
        return entity;
    }
}
