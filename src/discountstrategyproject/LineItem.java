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
        this.setQuantity(quantity);
    }

    private Product findProduct(String productId, ReceiptDataAccessStrategy db) {
        if(db.findProduct(productId) == null){
            throw new IllegalArgumentException("Error: Product ID: " + productId + " could not be found in the current products list.");
        }
        return db.findProduct(productId);
    }
    
    public final String getLineItemData(){
        String itemData = "";
        itemData += product.getProductId() + COLUMN_SPACE_CHARACTER;
        itemData += product.getProductName() + COLUMN_SPACE_CHARACTER;
        itemData += product.getPrice() + COLUMN_SPACE_CHARACTER;
        itemData += this.quantity + COLUMN_SPACE_CHARACTER;
        itemData += getSubTotal() + COLUMN_SPACE_CHARACTER;
        itemData += getDiscountAmount();       
        return itemData;
    }
    
    public final double getSubTotal(){
        return product.getPrice() * this.quantity;
    }

    public final Product getProduct() {
        return product;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(int qty) {
        if(qty <= 0){
            throw new IllegalArgumentException("Error: Quantity should be greater than 0.");
        }
        this.quantity = qty;
    }
    
    public final double getDiscountAmount(){
        return product.getDiscountStrategy().getDiscountAmount(product.getPrice(), this.quantity);
    }
    
}
