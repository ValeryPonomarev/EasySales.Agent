package easysales.agent.Entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drmiller on 16.12.2016.
 */
public enum OrderType {
    Bid(0), Order(1), Remove(2);

    private int value;
    private static Map map = new HashMap<>();

    private OrderType(int value)
    {
        this.value = value;
    }

    static {
        for(OrderType type : OrderType.values())
        {
            map.put(type.value, type);
        }
    }

    public static OrderType valueOf(int type)
    {
        if(map.containsKey(type)) {
            return (OrderType) map.get(type);
        }
        else
            return (OrderType) map.get(1);
    }

    public int getValue()
    {
        return value;
    }
}
