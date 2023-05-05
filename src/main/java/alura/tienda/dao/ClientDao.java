/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.dao;

import alura.tienda.models.Client;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class ClientDao {
    private EntityManager em;
    
    public ClientDao(EntityManager em) {
        this.em = em;
    }
    
    public void saved(Client client) {
        this.em.persist(client);
    }    
}
