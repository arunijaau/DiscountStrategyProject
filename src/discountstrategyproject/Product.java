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
public class Product {

    private String productId;
    private String productName;
    private double price;
    private ProductDiscountStrategy discountStrategy;
   

    public Product(String productId, String productName, double price, ProductDiscountStrategy discountStrategy) {
        this.setProductId(productId);
        this.setProductName(productName);
        this.setPrice(price);
        this.setDiscountStrategy(discountStrategy);
    }

    public final ProductDiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public final void setDiscountStrategy(ProductDiscountStrategy discountStrategy) throws IllegalArgumentException {
        if(discountStrategy == null){
            throw new IllegalArgumentException("Discount strategy should not be null.");
        }
        this.discountStrategy = discountStrategy;
    }

    
    
    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) throws IllegalArgumentException {
        if(productId == null || productId.isEmpty()){
            throw new IllegalArgumentException("Error: Product ID should not be null or empty.");
        }
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) throws IllegalArgumentException {
        if(productName == null || productName.isEmpty()){
            throw new IllegalArgumentException("Error: Product name should not be null or empty.");
        }
        this.productName = productName;
    }
    
    public final double getPrice() {
        return price;
    }

    public final void setPrice(double price) throws IllegalArgumentException {
        if(price <= 0){
            throw new IllegalArgumentException("Error: Product price should not be less than 0.");
        }
        this.price = price;
    }
    
    

   
}
