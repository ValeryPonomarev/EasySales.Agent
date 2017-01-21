package com.easysales.agent.Serivces;

import android.location.Location;

import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.Entities.OrderState;
import com.easysales.agent.Entities.OrderType;

import java.util.Calendar;

/**
 * Created by drmiller on 15.01.2017.
 */

public final class OrderDocService {
    public static OrderDoc GetTestOrderDoc()
    {
        return new OrderDoc(null, "test", Calendar.getInstance().getTime(), OrderType.Bid, OrderState.NoState, null, new Location("dummy"));
    }
}
