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
public interface ReceiptDataAccessStrategy {

    public abstract Customer findCustomer(String customerId);

    public abstract Product findProduct(String productId);
    
}
