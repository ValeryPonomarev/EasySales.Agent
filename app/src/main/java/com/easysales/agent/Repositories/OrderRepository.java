package com.easysales.agent.Repositories;

import android.content.ContentValues;
import android.content.Context;

import com.easysales.agent.Entities.OrderFactory;

import java.util.List;

import com.easysales.agent.Entities.EntityFactoryBuilder;
import com.easysales.agent.Entities.OrderDoc;

import easysales.androidorm.Entity.IEntityFactoryBuilder;
import easysales.androidorm.Repository.RepositoryDB;

/**
 * Created by drmiller on 16.12.2016.
 */
public class OrderRepository extends RepositoryDB<OrderDoc> {

    public OrderRepository(Context context)
    {
        super(context);
    }

    @Override
    protected String GetTableName() {
        return "OrderDoc";
    }

    @Override
    protected String GetTableCreateQuery() {
        return "CREATE TABLE `" + GetTableName() + "` (\n" +
                "\t`" + OrderFactory.FieldNames.Key + "`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t`" + OrderFactory.FieldNames.Number + "`\tTEXT,\n" +
                "\t`" + OrderFactory.FieldNames.Date + "`\tREAL,\n" +
                "\t`" + OrderFactory.FieldNames.Type + "`\tINTEGER,\n" +
                "\t`" + OrderFactory.FieldNames.State + "`\tINTEGER,\n" +
                "\t`" + OrderFactory.FieldNames.Customer + "`\tINTEGER,\n" +
                "\t`" + OrderFactory.FieldNames.LocationLatitude + "`\tREAL,\n" +
                "\t`" + OrderFactory.FieldNames.LocationLongitude + "`\tREAL\n" +
                ");";
    }

    @Override
    protected String GetTableUpdateQuery() {
        return String.format("DROP TABLE IF EXISTS `%1$s`", GetTableName());
    }

    @Override
    protected String GetBaseQuery() {
        return String.format("SELECT * FROM `%1$s`", GetTableName());
    }

    @Override
    protected String GetBaseWhereClause() {
        return " WHERE _id = %1$s";
    }

    @Override
    protected void PersistNewItem(OrderDoc entity) {
        ContentValues values = new ContentValues();
        values.put(OrderFactory.FieldNames.Number, entity.getNumber());
        values.put(OrderFactory.FieldNames.Date, entity.getDate().getTime());
        values.put(OrderFactory.FieldNames.Type, entity.getType().getValue());
        values.put(OrderFactory.FieldNames.State, entity.getState().getValue());
        if(entity.getCustomer() != null){
            values.put(OrderFactory.FieldNames.Customer, (int)entity.getCustomer().getKey());
        }

        if(entity.getLocation() != null) {
            values.put(OrderFactory.FieldNames.LocationLatitude, entity.getLocation().getLatitude());
            values.put(OrderFactory.FieldNames.LocationLongitude, entity.getLocation().getLongitude());
        }

        GetDatabase().insertOrThrow(GetTableName(), null, values);
    }

    @Override
    protected void PersistUpdatedItem(OrderDoc entity) {
        ContentValues values = new ContentValues();
        values.put(OrderFactory.FieldNames.Number, entity.getNumber());
        values.put(OrderFactory.FieldNames.Date, entity.getDate().getTime());
        values.put(OrderFactory.FieldNames.Type, entity.getType().getValue());
        values.put(OrderFactory.FieldNames.State, entity.getState().getValue());
        if(entity.getCustomer() != null){
            values.put(OrderFactory.FieldNames.Customer, (int)entity.getCustomer().getKey());
        }
        if(entity.getLocation() != null) {
            values.put(OrderFactory.FieldNames.LocationLatitude, entity.getLocation().getLatitude());
            values.put(OrderFactory.FieldNames.LocationLongitude, entity.getLocation().getLongitude());
        }

        GetDatabase().update(GetTableName(), values, "_id = ?", new String[]{entity.getKey().toString()});
    }

    @Override
    protected int GetTableVersion() {
        return 2;
    }

    @Override
    protected IEntityFactoryBuilder GetEntityFactoryBuilder() {
        return new EntityFactoryBuilder();
    }

    public List<OrderDoc> FindOrdersByNumber(String number){
        return BuildEntitiesFromSql(String.format("%1$s WHERE Number = \"%2$s\"", GetBaseQuery(), number));
    }
}
