package edu.iu.c322.orderservice.model;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

public class Order {
    private int orderId;
    private int customerId;
    private float total;

    @Valid
    private Address shippingAddress;

    @Valid
    private List<Item> items;
    private Payment payment;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId && customerId == order.customerId && Float.compare(order.total, total) == 0 && shippingAddress.equals(order.shippingAddress) && items.equals(order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, customerId, total, shippingAddress, items);
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
