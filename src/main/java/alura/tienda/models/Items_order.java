/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import alura.tienda.utils.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="items_order")
public class Items_order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private int amount;
    private BigDecimal price_unitary;
    @ManyToOne  
    private Product product;
    @ManyToOne
    private Order order;
    
    public Items_order() {
        
    }

    public Items_order(int amount, Product product, Order order) {
        this.amount = amount;
        this.product = product;
        this.order = order;
        this.price_unitary = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public int getAmout() {
        return amount;
    }

    public void setAmout(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice_unitary() {
        return price_unitary;
    }

    public void setPrice_unitary(BigDecimal price_unitary) {
        this.price_unitary = price_unitary;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public BigDecimal getValue() {
        return this.price_unitary.multiply(new BigDecimal(this.amount));
    }        
}
