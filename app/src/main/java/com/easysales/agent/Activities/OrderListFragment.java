package com.easysales.agent.Activities;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.easysales.agent.Data.BaseEntityCursorAdapter;
import com.easysales.agent.Data.OrderCursorAdapter;
import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.R;
import com.easysales.agent.Repositories.RepositoryFactory;
import com.easysales.agent.UI.BaseListFragment;

import easysales.androidorm.Repository.IRepository;

public class OrderListFragment extends BaseListFragment {

    public OrderListFragment() {
    }

    @Override
    public void MainAction() {
        OrderDoc customer = new OrderDoc();
        customer.setNumber(getString(R.string.newOrderDocNumber));
        GetRepository().Add(customer);
        Refresh();
        Toast.makeText(getContext(), "MainAction", Toast.LENGTH_LONG).show();
    }

    @Override
    protected BaseEntityCursorAdapter GetAdapter() {
        return new OrderCursorAdapter(getContext(), GetRepository().FindAll(), 0);
    }

    @Override
    protected IRepository GetRepository() {
        return RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.ORDERDOC_REPOSITORY);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
