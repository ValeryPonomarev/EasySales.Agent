package com.easysales.androidui.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.easysales.androidui.Data.BaseEntityCursorAdapter;
import com.easysales.androidui.R;

import easysales.androidorm.Repository.IRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseListFragment extends BaseFragment
    implements AdapterView.OnItemClickListener {
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
        gridView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.fragment_list_context_menu, menu);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_list_menu, menu);
    }

    public void Refresh(){
        adapter.changeCursor(GetRepository().FindAll());
    }

    public void Add(){

    }

    public void Delete(){

    }

    protected int GetLayoutId(){
        return R.layout.fragment_base_list;
    }

    protected int GetGridViewId(){
        return R.id.fragment_base_list_gridview;
    }



}
