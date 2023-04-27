/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import java.math.BigDecimal;
import javax.persistence.Entity;
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
    private int amout;
    private BigDecimal price_unitary;
    @ManyToOne  
    private Product product;
    @ManyToOne
    private Order order;
    
    public Items_order() {
        
    }

    public Items_order(int amout, Product product, Order order) {
        this.amout = amout;
        this.product = product;
        this.order = order;
        this.price_unitary = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
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
    
    
}
