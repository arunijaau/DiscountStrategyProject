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
    private ProductDiscountStrategy discount;

    public Product(String productId, String productName, double price, ProductDiscountStrategy discount) {
        this.setProductId(productId);
        this.setProductName(productName);
        this.setPrice(price);
        this.setDiscountAmount(discount);
    }

    
    
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        if(productId == null || productId.isEmpty()){
            throw new IllegalArgumentException("Error: Product ID should not be null or empty.");
        }
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if(productName == null || productName.isEmpty()){
            throw new IllegalArgumentException("Error: Product name should not be null or empty.");
        }
        this.productName = productName;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price >= 0){
            throw new IllegalArgumentException("Error: Product price should not be less than 0.");
        }
        this.price = price;
    }
    
    public ProductDiscountStrategy getDiscountAmount() {
        return discount;
    }

    public void setDiscountAmount(ProductDiscountStrategy discount) {
        if(discount == null){
            throw new IllegalArgumentException("Error: discount strategy should not be null.");
        }
        this.discount = discount;
    }
    
}
