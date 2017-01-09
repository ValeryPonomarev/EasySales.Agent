package com.easysales.agent.UI;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.easysales.agent.Data.BaseEntityCursorAdapter;
import com.easysales.agent.R;

import easysales.androidorm.Repository.IRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseListFragment extends BaseFragment {
    protected BaseEntityCursorAdapter adapter;

    public BaseListFragment() {
        // Required empty public constructor
    }

    protected abstract BaseEntityCursorAdapter GetAdapter();
    protected abstract IRepository GetRepository();

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

    public void Refresh(){
        adapter.changeCursor(GetRepository().FindAll());
    }

    protected int GetLayoutId(){
        return R.layout.fragment_base_list;
    }

    protected int GetGridViewId(){
        return R.id.fragment_base_list_gridview;
    }



}
