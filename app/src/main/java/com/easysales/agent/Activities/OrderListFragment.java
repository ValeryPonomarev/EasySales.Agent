package com.easysales.agent.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.easysales.androidui.Data.BaseEntityCursorAdapter;
import com.easysales.agent.Data.OrderCursorAdapter;
import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.R;
import com.easysales.agent.Repositories.RepositoryFactory;
import com.easysales.androidui.Fragment.BaseListFragment;

import easysales.androidorm.Entity.Entity;
import easysales.androidorm.Repository.IRepository;

public class OrderListFragment extends BaseListFragment {

    public OrderListFragment() {
    }

    @Override
    protected BaseEntityCursorAdapter GetAdapter() {
        return new OrderCursorAdapter(getContext(), GetRepository().FindAll(), 0);
    }

    @Override
    protected IRepository GetRepository() {
        return RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.ORDERDOC_REPOSITORY);
    }

    @Override
    protected Entity CreateNewEntity() {
        OrderDoc orderDoc = new OrderDoc();
        orderDoc.setNumber(getString(R.string.newOrderDocNumber));
        return orderDoc;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), adapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
    }
}
