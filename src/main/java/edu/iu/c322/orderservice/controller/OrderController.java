package edu.iu.c322.orderservice.controller;

import edu.iu.c322.orderservice.OrderserviceApplication;
import edu.iu.c322.orderservice.model.Order;
import edu.iu.c322.orderservice.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

//    @GetMapping
//    public List<Order> findAll() {
//        return repository.findAll();
//    }
    @GetMapping("/{id}")
    public List<Order> getOrders(@PathVariable int id) {
        return repository.findCustomerOrders(id);
    }

    @PostMapping
    public int create(@Valid @RequestBody Order order) {

        return repository.create(order);
    }
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable int id) {
        return repository.delete(id);
    }

}
