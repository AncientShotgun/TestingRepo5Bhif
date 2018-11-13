package at.htlgrieskirchen.jsf.workshop;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Pratt Christopher
 */
@ManagedBean
@RequestScoped
public class Product {

    private String catalogNumber;
    private String producer;
    private String productName;
    private double price;
    private int amount;

    public Product() {
    }

    public Product(String catalogNumber, String producer, String productName,
            double price, int amount) {
        this.catalogNumber = catalogNumber;
        this.producer = producer;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

    public String getCatalogNumber() {
        return catalogNumber;
    }

    public void setCatalogNumber(String catalogNumber) {
        this.catalogNumber = catalogNumber;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getTotalPrice() {
        return price * amount;
    }
}

