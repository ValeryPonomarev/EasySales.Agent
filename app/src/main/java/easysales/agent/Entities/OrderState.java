package easysales.agent.Entities;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drmiller on 16.12.2016.
 */
public enum OrderState {
    NoState(0);

    private int value;
    private static Map map = new HashMap<>();

    private OrderState(int value)
    {
        this.value = value;
    }

    static {
        for(OrderState state : OrderState.values())
        {
            map.put(state.value, state);
        }
    }

    public static OrderState valueOf(int state)
    {
        if(map.containsKey(state)) {
            return (OrderState) map.get(state);
        }
        else
            return (OrderState) map.get(1);
    }

    public int getValue()
    {
        return value;
    }
}
