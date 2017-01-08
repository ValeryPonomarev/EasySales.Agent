package com.easysales.agent.Entities;

import easysales.androidorm.Entity.IEntityFactory;
import easysales.androidorm.Entity.IEntityFactoryBuilder;

/**
 * Created by drmiller on 16.12.2016.
 */
public class EntityFactoryBuilder implements IEntityFactoryBuilder {
    @Override
    public IEntityFactory GetFactory(String s) {
        switch (s)
        {
            case "OrderDoc":
                return new OrderFactory();
            case "Customer":
                return new CustomerFactory();
        }

        throw new IllegalArgumentException("Фабрика " + s + " отсутствует в словаре");
    }
}
