package org.example;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private int qty;
    private double cost;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Product(){

    }

    public Product(String id, String name, int qty, double cost, String category) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.cost = cost;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", cost=" + cost +
                ", category='" + category + '\'' +
                '}';
    }
}
