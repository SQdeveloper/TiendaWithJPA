/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.dao;

import alura.tienda.models.Product;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class ProductDao {
    
    private EntityManager em;
    
    public ProductDao(EntityManager em) {
        this.em = em;
    }
    
    public void saved(Product product) {
        this.em.persist(product);
    }
    
    public void remove(Product product) {
        this.em.remove(product);
    }
    
    public Product queryForId(Long id) {
        return this.em.find(Product.class, id);
    }
    
    public List<Product> queryList() {
        String jpql = "SELECT P FROM Product AS P";
        return this.em.createQuery(jpql, Product.class).getResultList();
    }
    
    public List<Product> queryForName(String name) {
        String jpql = "SELECT P FROM Product AS P WHERE name=:name ";
        return this.em.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
    
    public List<Product> queryForCategory(String category) {
        String jpql = "SELECT P FROM Product AS P WHERE P.category.name=:category";
        return this.em.createQuery(jpql, Product.class).setParameter("category", category).getResultList();
    }
    
    public BigDecimal queryPriceForName(String name) {
        String jpql = "SELECT price FROM Product AS P WHERE name=:name";
        return this.em.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }
}
