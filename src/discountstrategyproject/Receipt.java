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
    private Store store;
    private ReceiptDataAccessStrategy db;
    private final int receiptNumber;
    private String newLine = "\n";

    public Receipt(String customerId, ReceiptDataAccessStrategy db) {
        this.db = db;
        this.receiptNumber = db.getNextReceiptNumber();
        this.customer = findCustomer(customerId);
    }
    
    private Customer findCustomer(String customerId){
        return db.findCustomer(customerId);
    }

    public final void addLineItem(String productId, int quantity) {
        LineItem item = new LineItem(productId, quantity, db);
    }
        
    public final void addItemToArray(final LineItem item){
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        for(int i = 0; i <lineItems.length; i++){
            tempItems[i] = lineItems[i];
        }
        tempItems[tempItems.length - 1] = item;
        lineItems = tempItems;
        tempItems = null;
    }
    
    public final String getReceiptData(){
        String receiptData = "";
        receiptData += getGreetingMessage() + newLine + newLine;
        receiptData += "Sold to: " + customer.getName() + newLine;
        receiptData += "Receipt No.: " + getReceiptNumber();
        for(LineItem item: lineItems){
            receiptData += item.getLineItemData() + newLine;
        }
        
        return receiptData;
    }

    public final int getReceiptNumber() {
        return this.receiptNumber;
    }
    
    private String getGreetingMessage(){
        return "Thank you for shopping at " + store.getStoreName();
    }
}
