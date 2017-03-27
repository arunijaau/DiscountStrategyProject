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
    private String formatter = "\t";
    
    public LineItem(String productId, int quantity, ReceiptDataAccessStrategy db) {
        this.product = findProduct(productId, db);
        this.quantity = quantity;
    }

    private Product findProduct(String productId, ReceiptDataAccessStrategy db) {
        return db.findProduct(productId);
    }
    
    public String getLineItemData(){
        String itemData = "";
        itemData += product.getProductId() + formatter;
        itemData += product.getProductName() + formatter;
        itemData += product.getPrice() + formatter;
        itemData += quantity + formatter;
        itemData += getSubTotal() + formatter;
        itemData += product.getDiscountAmount();       
        return itemData;
    }
    
    private double getSubTotal(){
        return product.getPrice() * this.quantity;
    }
    
}
