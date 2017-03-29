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
        itemData += quantity + COLUMN_SPACE_CHARACTER;
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
        return quantity;
    }

    public final void setQuantity(int quantity) {
        if(quantity < 0){
            throw new IllegalArgumentException("Error: Quantity should not be less than 0.");
        }
        this.quantity = quantity;
    }
    
    public final double getDiscountAmount(){
        return product.getDiscountStrategy().getDiscountAmount(product.getPrice(), quantity);
    }
    
}
