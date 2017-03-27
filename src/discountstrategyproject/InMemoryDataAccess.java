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
public class InMemoryDataAccess implements ReceiptDataAccessStrategy {

    private final Customer[] customers; 
    private final Product[] products;

    public InMemoryDataAccess() {
        this.customers = new Customer[]{new Customer("100", "John Smith"),
            new Customer("200", "Sally Johns"),
            new Customer("300", "Bob Clementi")};
        
        this.products = new Product[] {new Product("A101", "MLB Brewer's Hat",19.95, new PercentOffDiscount(0.15)),
            new Product("B205", "Men's Dress Shirt", 35.50, new QtyDiscount(0.10,5)),
            new Product("C222","Women's Socks", 9.50, new NoDiscount())
    };
        
        
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
        if(productId == null || productId.isEmpty()){
            throw new IllegalArgumentException("Error: Product ID should not be null or empty.");
        }
        
        Product product = null;
        for (Product prod : products){
            if(productId.equals(prod.getProductId())){
                product = prod;
                break;
            }
        }
        return product;
    }

}
