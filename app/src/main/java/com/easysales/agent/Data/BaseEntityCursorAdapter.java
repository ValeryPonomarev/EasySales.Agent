package com.easysales.agent.Data;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easysales.agent.R;

import easysales.androidorm.Entity.Entity;

/**
 * Created by drmiller on 08.01.2017.
 */

public abstract class BaseEntityCursorAdapter<T extends Entity> extends CursorAdapter {
    private LayoutInflater inflater;
    private static final int ViewTypeItem = 0;
    private static final int ViewTypeGroup = 1;

    public BaseEntityCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        inflater = LayoutInflater.from(context);
    }

    protected abstract boolean IsGroup(Cursor cursor, int position);
    protected abstract void PopulateView(View view, T entity);
    protected abstract T BuildEntity(Cursor cursor);

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) return ViewTypeItem;
        if(IsGroup(getCursor(), position)) {
            return ViewTypeGroup;
        }

        return ViewTypeItem;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view;

        if(getItemViewType(cursor.getPosition())== ViewTypeGroup) {
            view = inflater.inflate(getGroupItemView(), parent, false);
        }
        else {
            view = inflater.inflate(getItemView(), parent, false);
        }
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        PopulateView(view, getCurrentEntity(cursor, cursor.getPosition()));
    }

    @Override
    public Object getItem(int position) {
        return getCurrentEntity(getCursor(), position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected int getItemView(){
        return R.layout.base_entity_cursor_item;
    }

    protected int getGroupItemView() {
        return R.layout.base_entity_cursor_group_item;
    }

    protected T getCurrentEntity(Cursor cursor, int position)
    {
        int currentPosition = cursor.getPosition();
        cursor.moveToPosition(position);
        T result = BuildEntity(cursor);
        cursor.moveToPosition(currentPosition);
        return result;
    }
}
