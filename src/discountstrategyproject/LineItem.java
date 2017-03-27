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
    private static final String COLUMN_SPACE_CHARACTER = "\t";
    
    public LineItem(String productId, int quantity, ReceiptDataAccessStrategy db) {
        this.product = findProduct(productId, db);
        this.quantity = quantity;
    }

    private Product findProduct(String productId, ReceiptDataAccessStrategy db) {
        return db.findProduct(productId);
    }
    
    public String getLineItemData(){
        String itemData = "";
        itemData += product.getProductId() + COLUMN_SPACE_CHARACTER;
        itemData += product.getProductName() + COLUMN_SPACE_CHARACTER;
        itemData += product.getPrice() + COLUMN_SPACE_CHARACTER;
        itemData += quantity + COLUMN_SPACE_CHARACTER;
        itemData += getSubTotal() + COLUMN_SPACE_CHARACTER;
        itemData += getDiscountAmount();       
        return itemData;
    }
    
    public double getSubTotal(){
        return product.getPrice() * this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Error: Quantity should not be less than 0.");
        }
        this.quantity = quantity;
    }
    
    public double getDiscountAmount(){
        return product.getDiscountStrategy().getDiscountAmount(product.getPrice(), quantity);
    }
    
}
