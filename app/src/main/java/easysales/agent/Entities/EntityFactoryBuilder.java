package easysales.agent.Entities;

import easysales.androidorm.Entity.IEntityFactory;
import easysales.androidorm.Entity.IEntityFactoryBuilder;

/**
 * Created by drmiller on 16.12.2016.
 */
public class EntityFactoryBuilder implements IEntityFactoryBuilder {
    @Override
    public IEntityFactory GetFactory(String s) {
        switch (s)
        {
            case "Order":
                return new OrderFactory();
        }

        throw new IllegalArgumentException("Фабрика " + s + " отсутствует в словаре");
    }
}
