/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlgrieskirchen.jsf.workshop;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pratt Christopher
 */
@ManagedBean
@SessionScoped
public class ShoppingCartManagedBean {

    private List<Product> shoppingCart;

    public ShoppingCartManagedBean() {
        shoppingCart = new ArrayList<>();
    }

    public List<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String add(Product p) {
        boolean productFound = false;
        for (Product product : shoppingCart) {
            if (product.getCatalogNumber().equals(p.getCatalogNumber())) {
                product.setAmount(product.getAmount() + 1);
                productFound = true;
            }
        }
        if (!productFound) {

            p.setAmount(1);
            shoppingCart.add(p);
        }
        return "cartview";
    }

    public String getSum() {
        DecimalFormat df = new DecimalFormat("#0.00");
        double sum = 0.0;
        for (Product p : shoppingCart) {
            sum += p.getTotalPrice();
        }
        return df.format(sum);
    }

}
