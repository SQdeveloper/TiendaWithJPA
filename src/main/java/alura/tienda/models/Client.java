/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author PC
 */

@Entity
@Table(name="clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private PersonalData personalData;
    private String jeff = "jeff";
    
    public Client() {
        
    }
    
    public Client(String name, String dni) {
        this.personalData = new PersonalData(name, dni);            
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
                System.out.println("jeffffffffffffffffffffffffffffffffffffffffff");

        return this.personalData.getName();
    }

    public void setName(String name) {
        this.personalData.setName(name);
    }

    public String getDni() {
        return this.personalData.getDni();
    }

    public void setDni(String dni) {
        this.personalData.setDni(dni);
    }        
}
