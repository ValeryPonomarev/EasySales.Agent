package com.easysales.agent.Data;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.easysales.agent.Entities.Customer;
import com.easysales.agent.Entities.EntityFactoryBuilder;
import com.easysales.agent.R;
import com.easysales.agent.Repositories.CustomerRepository;
import com.easysales.agent.Repositories.RepositoryFactory;

import easysales.androidorm.Entity.IEntityFactoryBuilder;

/**
 * Created by drmiller on 08.01.2017.
 */

public class CustomerCursorAdapter extends BaseEntityCursorAdapter<Customer> {
    private IEntityFactoryBuilder entityFactoryBuilder;

    public CustomerCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        entityFactoryBuilder = new EntityFactoryBuilder();
    }

    @Override
    protected boolean IsGroup(Cursor cursor, int position) {
        return false;
    }

    @Override
    protected void PopulateView(View view, Customer entity) {
        TextView titleView = (TextView)view.findViewById(R.id.baseEntityCursorItem_Title);
        titleView.setText(entity.getName());
    }

    @Override
    protected Customer BuildEntity(Cursor cursor) {
        return (Customer)entityFactoryBuilder.GetFactory("Customer").BuildEntity(cursor);
    }
}
