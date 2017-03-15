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
public class Customer {
    private String name;
    private String customerId;

    public Customer(String customerId, String name) {
        this.setName(name);
        this.setCustomerId(customerId);
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Error: Customer name cannot be null or empty.");
        }
        this.name = name;
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        if(customerId == null || customerId.isEmpty()){
            throw new IllegalArgumentException("Error: Customer ID cannot be null or empty.");
        }
        this.customerId = customerId;
    }
    
}
