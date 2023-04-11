package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.OrderserviceApplication;
import edu.iu.c322.orderservice.model.Item;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public int create(@RequestBody Order order){

        for(int i = 0; i < order.getItems().size(); i++){
            Item item = order.getItems().get(i);
            item.setOrder(order);
        }
        long millis=System.currentTimeMillis();
        order.setOrderPlaced(new java.sql.Date(millis));
        Order addedOrder = repository.save(order);
        return addedOrder.getId();
    }

    @GetMapping("/{customerId}")
    public List<Order> findByCustomer(@PathVariable int customerId){
        return repository.findByCustomerId(customerId);
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> findByOrderId(@PathVariable int orderId){
        return repository.findById(orderId);
    }

    @GetMapping("/order/{orderId}/{itemId}")
    public Item findItem(@PathVariable int orderId,@PathVariable int itemId) {
        Optional<Order> order = repository.findById(orderId);
        Order orderFound = order.get();
        for(int i =0; i < orderFound.getItems().size(); i++) {
            if(orderFound.getItems().get(i).getId() == itemId) {
                return orderFound.getItems().get(i);
            }
        }
        return null;
    }

}
