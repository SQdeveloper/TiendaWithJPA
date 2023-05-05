/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.models;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
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
@Table(name="categories")
public class Category {

    @EmbeddedId
    private CategoryId categoryId;        
    
    public Category() {
        
    }
    
    public Category(String name) {
        this.categoryId = new CategoryId(name, 456);
    }

    public String getName() {
        return this.categoryId.getName();
    }

    public void setName(String name) {
        this.categoryId.setName(name);
    }        
}
