/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alura.tienda.vo;

import java.time.LocalDate;

/**
 *
 * @author PC
 */
public class RelatorioDeVenta {
    
    private String nameProduct;
    private Long amountProduct;
    private LocalDate dateLastSale;
    
    public RelatorioDeVenta(String nameProduct, Long amountProduct, LocalDate dateLastSale) {
        this.nameProduct = nameProduct;
        this.amountProduct = amountProduct;
        this.dateLastSale = dateLastSale;
    }
    
    @Override
    public String toString() {
        return "RelatorioDeVenta[" + this.nameProduct + ", " + this.amountProduct + ", " + dateLastSale + "]";
    }
}
