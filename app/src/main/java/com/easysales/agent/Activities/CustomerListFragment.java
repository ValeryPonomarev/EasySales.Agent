package com.easysales.agent.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.easysales.agent.Data.BaseEntityCursorAdapter;
import com.easysales.agent.Data.CustomerCursorAdapter;
import com.easysales.agent.Entities.Customer;
import com.easysales.agent.R;
import com.easysales.agent.Repositories.RepositoryFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerListFragment extends BaseListFragment {

    private CustomerCursorAdapter adapter;

    public CustomerListFragment() {
    }

    @Override
    protected BaseEntityCursorAdapter GetAdapter() {
        return new CustomerCursorAdapter(getActivity(), RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.CUSTOMER_REPOSITORY).FindAll(), 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

}
