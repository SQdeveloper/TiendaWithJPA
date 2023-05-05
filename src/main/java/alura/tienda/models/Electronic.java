/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="electronics")
public class Electronic extends Product {
    
    private String type;
    private String circuitos;
    
    public Electronic() {
        
    }        

    public Electronic(String type, String circuitos) {
        this.type = type;
        this.circuitos = circuitos;
    }
}