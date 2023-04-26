/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.pruebas;

import alura.tienda.dao.CategoryDao;
import alura.tienda.dao.ProductDao;
import alura.tienda.models.Category;
import alura.tienda.models.Product;
import alura.tienda.utils.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class Main {
    
    public static void main(String[] args) {
        //We instace the models
        Category phone = new Category("phone");
        Category book = new Category("book");       

        Product product = new Product("iphone", "dispositivo electronico", new BigDecimal("1000"), phone);     
        Product product1 = new Product("stephen", "dispositivo electronico", new BigDecimal("1233"), book);        
        
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        //We instance the dao
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        
        //We Saved the entitys
        categoryDao.saved(phone);
        categoryDao.saved(book);

        productDao.saved(product);
        productDao.saved(product1);   

        System.out.println(productDao.queryPriceForName("stephen"));
        
        em.getTransaction().commit();        
        em.close();

    }
}
