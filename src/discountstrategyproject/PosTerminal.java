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
public class PosTerminal {
    private Invoice invoice;

    public final void startTransaction(String customerId, InvoiceDataAccessStrategy db) {
        this.invoice = new Invoice(customerId, db);
    }

    public final void addItemToTransaction(String productId, int quantity, InvoiceDataAccessStrategy db) {
        this.invoice.addLineItem(productId, quantity, db);
    }

    public final void endTransaction() {
        
    }
    
}
