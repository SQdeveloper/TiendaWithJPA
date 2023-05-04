/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.pruebas;

import alura.tienda.dao.CategoryDao;
import alura.tienda.dao.ClientDao;
import alura.tienda.dao.OrderDao;
import alura.tienda.dao.ProductDao;
import alura.tienda.models.Category;
import alura.tienda.models.Client;
import alura.tienda.models.Items_order;
import alura.tienda.models.Order;
import alura.tienda.models.Product;
import alura.tienda.utils.JPAUtil;
import alura.tienda.vo.RelatorioDeVenta;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class RegisterOrder {
    
    public static void main(String[] args) {
        initializeValues();
        
        EntityManager em = JPAUtil.getEntityManager();
        
        ProductDao productDao = new ProductDao(em);
        
        productDao.queryForParameter("iphone", null, null);

        em.close();                 
    }
    
    public static void initializeValues() {
        //We instace the models
        Category phone = new Category("phone");
        Category book = new Category("book");       

        Product product = new Product("iphone", "dispositivo electronico", new BigDecimal("1000"), phone);     
        Product product1 = new Product("stephen", "dispositivo electronico", new BigDecimal("1233"), book);        
        
        //We instanced EntityManager with JPAUtil
        EntityManager em = JPAUtil.getEntityManager();     
        
        //We begin transaction
        em.getTransaction().begin();
        
        //We instanced the daos
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        ClientDao clientDao     = new ClientDao(em);        
        OrderDao orderDao       = new OrderDao(em);
        
        //We saved category(book) and product(product);
        categoryDao.saved(phone);
        productDao.saved(product);

        //We create and persist Client
        Client client = new Client("Jefferson", "342434");
        clientDao.saved(client);
        
        //We create and persist(saved) Order
        Order order = new Order(client);
        order.addItem(new Items_order(5, product, order));
        order.addItem(new Items_order(7, product, order));

        orderDao.saved(order);                
        
//        List<RelatorioDeVenta> relatorio =  orderDao.getRelatario();
//        
//        relatorio.forEach(System.out::println);
        

        em.getTransaction().commit();        
        em.close();
    }
}
