/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class JPAUtil {
    
    private static EntityManagerFactory em = Persistence.createEntityManagerFactory("tienda");
    
    public static EntityManager getEntityManager() {
        return em.createEntityManager();
    }
}
