/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author PC
 */

@Embeddable
public class PersonalData implements Serializable{
    
    private String name;
    private String dni;
    
    public PersonalData() {
        
    }
    
    public PersonalData(String name, String dni) {
        this.name = name;
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }        
}
