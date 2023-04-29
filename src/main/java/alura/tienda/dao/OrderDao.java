/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.dao;

import alura.tienda.models.Order;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class OrderDao {
    
    private EntityManager em;
    
    public OrderDao(EntityManager em) {
        this.em = em;
    }
    
    public void saved(Order order) {
        this.em.persist(order);
    }
    
    public BigDecimal getSumationValues() {
        String jpql = "SELECT SUM(p.valueAll) FROM Order AS p";
        return this.em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
    
    public List<Object[]> getRelatario() {
        String jpql = "SELECT product.name, "
                    + "SUM(item.amount), "
                    + "MAX(orderd.date) "
                    + "FROM Order as orderd "
                    + "JOIN orderd.items as item "
                    + "JOIN item.product as product";
        
        return this.em.createQuery(jpql, Object[].class).getResultList();
    }
}
