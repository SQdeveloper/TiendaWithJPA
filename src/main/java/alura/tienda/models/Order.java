/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private BigDecimal valueAll = new BigDecimal("0000");
    @ManyToOne    
    private Client client;
    
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL)
    private List<Items_order> items = new ArrayList();
    
    public Order(Client client) {
        this.client = client;
        this.date = LocalDate.now();        
    }

    public void addItem(Items_order item) {
        item.setOrder(this);
        items.add(item);
        this.valueAll = item.getValue();
    }

    public void setValueAll(BigDecimal number) {
        this.valueAll = number;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }        
}
