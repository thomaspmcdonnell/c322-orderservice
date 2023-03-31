package edu.iu.c322.orderservice.repository;

import edu.iu.c322.orderservice.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public List<Order> findAll() {
        return orders;
    }
    public int create(Order order) {
        int id = orders.size() + 1;
        order.setOrderId(id);
        orders.add(order);
        return id;
    }
    public String delete(int orderId) {
        String result = "order does not exist so there is nothing to delete";
        for(int i =0; i < orders.size(); i++) {
            if(orders.get(i).getOrderId() == orderId) {
                orders.remove(i);
                result = "order #" + orderId + " was deleted and cancelled";
            }
        }
        return result;
    }
    public List<Order> findCustomerOrders(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        if(!orders.isEmpty()) {
            for(int i =0; i < orders.size(); i++) {
                if(orders.get(i).getCustomerId() == customerId) {
                    customerOrders.add(orders.get(i));
                }
            }
        }

        return customerOrders;
    }
}
