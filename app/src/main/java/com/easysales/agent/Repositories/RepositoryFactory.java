package com.easysales.agent.Repositories;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import easysales.androidorm.Repository.IRepository;

/**
 * Created by drmiller on 05.01.2017.
 */

public final class RepositoryFactory {
    public static class RepositoryNames
    {
        public static final String ORDERDOC_REPOSITORY = "OrderRepository";
        public static final String CUSTOMER_REPOSITORY = "CustomerRepository";
    }

    private static Map<String, Object> repositories = new HashMap<String, Object>();

    public static <TRepository extends IRepository> TRepository GetRepository(Context context, String name) {
        Object repository = null;
        if (repositories.containsKey(name))
        {
            repository = repositories.get(name);
        }
        else
        {
            switch (name)
            {
                case RepositoryNames.ORDERDOC_REPOSITORY:
                    repository = new OrderRepository(context);
                    break;
                case RepositoryNames.CUSTOMER_REPOSITORY:
                    repository = new CustomerRepository(context);
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Repository %1$s not found!", name));
            }
        }

        return (TRepository)repository;
    }
}
