package com.easysales.agent.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easysales.agent.Data.BaseEntityCursorAdapter;
import com.easysales.agent.R;

public class OrderListFragment extends BaseListFragment {

    public OrderListFragment() {
    }

    @Override
    protected BaseEntityCursorAdapter GetAdapter() {
        return null;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
}
