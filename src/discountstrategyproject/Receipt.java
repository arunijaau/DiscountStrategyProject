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
public class Receipt {
    private final Customer customer;
    private LineItem[] lineItems;

    public Receipt(String customerId, ReceiptDataAccessStrategy db) {
        this.customer = findCustomer(customerId, db);
    }
    
    private Customer findCustomer(String customerId, ReceiptDataAccessStrategy db){
        return db.findCustomer(customerId);
        
    }

    public final void addLineItem(String productId, int quantity, ReceiptDataAccessStrategy db) {
        LineItem item = new LineItem(productId, quantity, db);
    }
        
    public void addItemToArray(final LineItem item){
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        for(int i = 0; i <lineItems.length; i++){
            tempItems[i] = lineItems[i];
        }
        tempItems[tempItems.length - 1] = item;
        lineItems = tempItems;
        tempItems = null;
    }
    
    public String getReceiptData(){
        String receiptData = "";
        for(LineItem item: lineItems){
            receiptData += item.getLineItemData();
        }
        
        return receiptData;
    }
}
