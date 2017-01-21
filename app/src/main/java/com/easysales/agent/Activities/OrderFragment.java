package com.easysales.agent.Activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.R;
import com.easysales.androidui.Fragment.BaseObjectFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends BaseObjectFragment {

    private OrderDoc orderDoc;

    public OrderFragment() {
        // Required empty public constructor
    }

    @Override
    public void MainAction() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        orderDoc = getArguments().getParcelable("Order");
        TextView view_Number = (TextView)view.findViewById(R.id.fOrder_Number);
        view_Number.setText(orderDoc.getNumber());

        // Inflate the layout for this fragment
        return view;
    }

}
