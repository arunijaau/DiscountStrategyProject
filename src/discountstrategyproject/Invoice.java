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
public class Invoice {
    private final Customer customer;
    private LineItem[] lineItems;

    public Invoice(String customerId, InvoiceDataAccessStrategy db) {
        this.customer = findCustomer(customerId, db);
    }
    
    private Customer findCustomer(String customerId, InvoiceDataAccessStrategy db){
        return db.findCustomer(customerId);
        
    }

    public final void addLineItem(String productId, int quantity, InvoiceDataAccessStrategy db) {
        LineItem item = new LineItem(productId, quantity, db);
    }
        
}
