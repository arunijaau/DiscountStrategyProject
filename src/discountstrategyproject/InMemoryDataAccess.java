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
public class InMemoryDataAccess implements InvoiceDataAccessStrategy {

    private final Customer[] customers; 

    public InMemoryDataAccess() {
        this.customers = new Customer[]{new Customer("100", "John Smith"),
            new Customer("200", "Sally Johns"),
            new Customer("300", "Bob Clementi")};
        
    }

    @Override
    public final Customer findCustomer(final String customerId) {
        if (customerId == null || customerId.isEmpty()) {
            throw new IllegalArgumentException("Error: Customer ID should not be null or empty.");
        }

        Customer customer = null;
        for (Customer cust : customers) {
            if (customerId.equals(cust.getCustomerId())) {
                customer = cust;
                break;
            }
        }
        return customer;
    }

    @Override
    public final Product findProduct(final String productId) {
        
        
        return null;
    }

}
