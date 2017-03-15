/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

/**
 *
 * @author Aruni
 */
public class LineItem {
    private Product product;
    private int quantity;
    
    public LineItem(String productId, int quantity, InvoiceDataAccessStrategy db) {
        this.product = findProduct(productId, db);
    }

    private Product findProduct(String productId, InvoiceDataAccessStrategy db) {
        return db.findProduct(productId);
        
    }
    
}
