package com.easysales.agent.Data;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;

import com.easysales.agent.Entities.Customer;
import com.easysales.agent.Entities.EntityFactoryBuilder;
import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.R;

import easysales.androidorm.Entity.IEntityFactoryBuilder;

/**
 * Created by drmiller on 08.01.2017.
 */

public class OrderCursorAdapter extends BaseEntityCursorAdapter<OrderDoc> {
    private IEntityFactoryBuilder entityFactoryBuilder;

    public OrderCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        entityFactoryBuilder = new EntityFactoryBuilder();
    }

    @Override
    protected boolean IsGroup(Cursor cursor, int position) {
        return false;
    }

    @Override
    protected void PopulateView(View view, OrderDoc entity) {
        TextView titleView = (TextView)view.findViewById(R.id.baseEntityCursorItem_Title);
        titleView.setText(entity.getNumber());
    }

    @Override
    protected OrderDoc BuildEntity(Cursor cursor) {
        return (OrderDoc)entityFactoryBuilder.GetFactory("OrderDoc").BuildEntity(cursor);
    }
}
