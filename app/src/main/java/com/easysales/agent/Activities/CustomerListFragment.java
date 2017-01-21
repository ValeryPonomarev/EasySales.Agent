package com.easysales.agent.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.easysales.androidui.Data.BaseEntityCursorAdapter;
import com.easysales.agent.Data.CustomerCursorAdapter;
import com.easysales.agent.Entities.Customer;
import com.easysales.agent.R;
import com.easysales.agent.Repositories.RepositoryFactory;
import com.easysales.androidui.Fragment.BaseListFragment;

import easysales.androidorm.Repository.IRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends BaseListFragment {

    public CustomerListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void MainAction() {
        Customer customer = new Customer();
        customer.setName(getString(R.string.newCustomerName));
        GetRepository().Add(customer);
        Refresh();
        Toast.makeText(getContext(), "MainAction", Toast.LENGTH_LONG).show();
    }

    @Override
    protected BaseEntityCursorAdapter GetAdapter() {
        return new CustomerCursorAdapter(getActivity(), GetRepository().FindAll(), 0);
    }

    @Override
    protected IRepository GetRepository() {
        return RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.CUSTOMER_REPOSITORY);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(), adapter.getItem(position).toString(), Toast.LENGTH_LONG).show();
    }
}
