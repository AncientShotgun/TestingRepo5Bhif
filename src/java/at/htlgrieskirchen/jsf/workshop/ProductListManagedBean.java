/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.htlgrieskirchen.jsf.workshop;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Pratt Christopher
 */
@ManagedBean
@SessionScoped
public class ProductListManagedBean {

    private List<Product> productList;

    public ProductListManagedBean() {
        populateproductList();
    }

    private void populateproductList() {
        ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance()
                .getExternalContext().getContext();
        String realPath = ctx.getRealPath("/");
        try (XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(realPath + "/Resources/products.xml")))) {
            productList = (List<Product>) dec.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductListManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
