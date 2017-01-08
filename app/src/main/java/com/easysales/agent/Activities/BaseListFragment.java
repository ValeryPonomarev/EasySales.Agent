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
public abstract class BaseListFragment extends Fragment {
    protected BaseEntityCursorAdapter adapter;

    public BaseListFragment() {
        // Required empty public constructor
    }

    protected abstract BaseEntityCursorAdapter GetAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(GetLayoutId(), container, false);
        GridView gridView = (GridView)view.findViewById(GetGridViewId());
        adapter = GetAdapter();
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getContext(), "Your action", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }

    protected int GetLayoutId(){
        return R.layout.fragment_base_list;
    }

    protected int GetGridViewId(){
        return R.id.fragment_base_list_gridview;
    }



}
