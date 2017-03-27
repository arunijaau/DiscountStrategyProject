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
public class Store {
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        if(storeName == null || storeName.isEmpty()){
            throw new IllegalArgumentException("Error: Store name should not be null or empty.");
        }
        this.storeName = storeName;
    }
}
