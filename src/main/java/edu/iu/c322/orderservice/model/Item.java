package edu.iu.c322.orderservice.model;

import jakarta.validation.constraints.NotEmpty;

public class Item {
    @NotEmpty(message = "name cannot be empty.")
    private String name;
    private int quantity;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
