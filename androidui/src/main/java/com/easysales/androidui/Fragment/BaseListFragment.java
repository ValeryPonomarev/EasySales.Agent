package com.easysales.androidui.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.easysales.androidui.Data.BaseEntityCursorAdapter;
import com.easysales.androidui.R;

import easysales.androidorm.Entity.Entity;
import easysales.androidorm.Repository.IRepository;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseListFragment extends BaseFragment
    implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    protected BaseEntityCursorAdapter adapter;

    public BaseListFragment() {
        // Required empty public constructor
    }

    protected abstract BaseEntityCursorAdapter GetAdapter();
    protected abstract IRepository GetRepository();
    protected abstract Entity CreateNewEntity();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(GetLayoutId(), container, false);
        GridView gridView = (GridView)view.findViewById(GetGridViewId());
        adapter = GetAdapter();
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);
        gridView.setOnItemLongClickListener(this);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.fragment_list_menu, menu);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        GetListItemPopupMenu(view, position).show();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = super.onOptionsItemSelected(item);
        int itemId = item.getItemId();
        if (itemId == R.id.fList_menu_action_add) {
            MainAction();
            result = true;
        }
        return result;
    }

    @Override
    public void MainAction() {
        AddItem();
        Refresh();
    }

    public void Refresh(){
        adapter.changeCursor(GetRepository().FindAll());
    }

    public Entity AddItem(){
        Entity entity = CreateNewEntity();
        GetRepository().Add(entity);
        return entity;
    }

    public void RemoveItem(int index){
        Entity entity = (Entity)adapter.getItem(index);
        GetRepository().Remove(entity);
    }

    protected int GetLayoutId(){
        return R.layout.fragment_base_list;
    }

    protected int GetGridViewId(){
        return R.id.fragment_base_list_gridview;
    }

    protected PopupMenu GetListItemPopupMenu(View view, final int position) {
        PopupMenu popupMenu = new PopupMenu(this.getContext(), view);
        popupMenu.inflate(R.menu.fragment_list_popup_menu);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int i = item.getItemId();
                if (i == R.id.fList_popup_action_remove) {
                    RemoveItem(position);
                    Refresh();
                    return true;
                } else {
                    return false;
                }
            }
        });
        return popupMenu;
    }
}
