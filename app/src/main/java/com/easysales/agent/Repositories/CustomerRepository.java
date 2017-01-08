package com.easysales.agent.Repositories;

import android.content.ContentValues;
import android.content.Context;

import java.util.List;

import com.easysales.agent.Entities.Customer;
import com.easysales.agent.Entities.CustomerFactory;
import com.easysales.agent.Entities.EntityFactoryBuilder;
import easysales.androidorm.Entity.IEntityFactoryBuilder;
import easysales.androidorm.Repository.RepositoryDB;

/**
 * Created by drmiller on 16.12.2016.
 */
public class CustomerRepository extends RepositoryDB<Customer> {

    public CustomerRepository(Context context)
    {
        super(context);
    }

    @Override
    protected String GetTableName() {
        return "Customer";
    }

    @Override
    protected String GetTableCreateQuery() {
        return "CREATE TABLE `" + GetTableName() + "` (\n" +
                "\t`" + CustomerFactory.FieldNames.Key + "`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                "\t`" + CustomerFactory.FieldNames.Name + "`\tTEXT,\n" +
                "\t`" + CustomerFactory.FieldNames.LocationLatitude + "`\tREAL,\n" +
                "\t`" + CustomerFactory.FieldNames.LocationLongitude + "`\tREAL\n" +
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
    protected void PersistNewItem(Customer entity) {
        ContentValues values = new ContentValues();
        values.put(CustomerFactory.FieldNames.Name, entity.getName());
        if(entity.getLocation() != null) {
            values.put(CustomerFactory.FieldNames.LocationLatitude, entity.getLocation().getLatitude());
            values.put(CustomerFactory.FieldNames.LocationLongitude, entity.getLocation().getLongitude());
        }

        GetDatabase().insertOrThrow(GetTableName(), null, values);
    }

    @Override
    protected void PersistUpdatedItem(Customer entity) {
        ContentValues values = new ContentValues();
        values.put(CustomerFactory.FieldNames.Name, entity.getName());
        if(entity.getLocation() != null) {
            values.put(CustomerFactory.FieldNames.LocationLatitude, entity.getLocation().getLatitude());
            values.put(CustomerFactory.FieldNames.LocationLongitude, entity.getLocation().getLongitude());
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

    public List<Customer> FindCustomersByName(String name){
        return BuildEntitiesFromSql(String.format("%1$s WHERE Name = \"%2$s\"", GetBaseQuery(), name));
    }
}
