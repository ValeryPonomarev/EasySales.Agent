package com.easysales.agent;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.easysales.agent.Entities.Customer;
import com.easysales.agent.Entities.OrderDoc;
import com.easysales.agent.Repositories.CustomerRepository;
import com.easysales.agent.Repositories.OrderRepository;
import com.easysales.agent.Repositories.RepositoryFactory;

import org.junit.Test;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class RepositoryTest extends ApplicationTestCase<Application> {
    private static String Tag = "testOrderRepository";
    public RepositoryTest() {
        super(Application.class);
    }

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        orderRepository = RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.ORDERDOC_REPOSITORY);
        customerRepository = RepositoryFactory.GetRepository(getContext(), RepositoryFactory.RepositoryNames.CUSTOMER_REPOSITORY);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

    }

    @Test
    public void testOrderRepository() throws Exception {
        assertNotNull("Repository not found", orderRepository);
        int countOrdersBefore = orderRepository.FindAllList().size();
        OrderDoc order = new OrderDoc();
        order.setNumber("test");
        orderRepository.Add(order);
        int countOrdersAfter = orderRepository.FindAllList().size();
        assertEquals("OrderDoc has not created", countOrdersAfter, countOrdersBefore + 1);
        assertTrue("OrderDoc with number [test] not found", orderRepository.FindOrdersByNumber("test").size() > 0);
        order = orderRepository.FindOrdersByNumber("test").get(0);
        order.setNumber("testUpdated");
        orderRepository.Set(order.getKey(), order);
        assertTrue("Update failed. OrderDoc with number [testUpdated] not found", orderRepository.FindOrdersByNumber("testUpdated").size() > 0);
        order.setNumber("test");
        orderRepository.Set(order.getKey(), order);
        for (OrderDoc o : orderRepository.FindOrdersByNumber("test")) {
            orderRepository.Remove(o);
        }
        assertEquals("OrderDoc has not deleted", orderRepository.FindOrdersByNumber("test").size(), 0);
    }

    public void testCustomerRepository() throws Exception {
        assertNotNull("Repository not found", customerRepository);
        int countOrdersBefore = customerRepository.FindAllList().size();
        Customer entity = new Customer();
        entity.setName("test");
        customerRepository.Add(entity);
        int countEntitiesAfter = customerRepository.FindAllList().size();
        assertEquals("OrderDoc has not created", countEntitiesAfter, countOrdersBefore + 1);
        assertTrue("OrderDoc with number [test] not found", customerRepository.FindCustomersByName("test").size() > 0);
        entity = customerRepository.FindCustomersByName("test").get(0);
        entity.setName("testUpdated");
        customerRepository.Set(entity.getKey(), entity);
        assertTrue("Update failed. OrderDoc with number [testUpdated] not found", customerRepository.FindCustomersByName("testUpdated").size() > 0);
        entity.setName("test");
        customerRepository.Set(entity.getKey(), entity);
        for (Customer testEntity : customerRepository.FindCustomersByName("test")) {
            customerRepository.Remove(testEntity);
        }
        assertEquals("OrderDoc has not deleted", customerRepository.FindCustomersByName("test").size(), 0);
    }
}