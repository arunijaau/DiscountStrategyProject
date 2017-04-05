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
    private Customer customer;
    private LineItem[] lineItems;
    private Store store;
    private ReceiptDataAccessStrategy db;
    private final int receiptNumber;
    private static final String NEW_LINE = "\n";

    public Receipt(Store store, String customerId, ReceiptDataAccessStrategy db) {
        this.setDb(db);
        this.lineItems = new LineItem[0];
        this.customer = findCustomer(customerId);
        this.receiptNumber = this.getDb().getNextReceiptNumber();
        this.setStore(store);
    }
    
    private Customer findCustomer(String customerId){
        if(db.findCustomer(customerId) == null){
            throw new IllegalArgumentException("Error: Customer ID " + customerId + " could not be found in the current customer's list.");
        }
        return db.findCustomer(customerId);
    }

    public final void addLineItem(String productId, int quantity) {
        LineItem item = new LineItem(productId, quantity, db);
        addItemToArray(item);
    }
        
    private void addItemToArray(final LineItem item){
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        for(int i = 0; i <lineItems.length; i++){
            tempItems[i] = lineItems[i];
        }
        tempItems[tempItems.length - 1] = item;
        lineItems = tempItems;
        tempItems = null;
    }
    
    public final String getReceiptData(){
        double netTotal = 0;
        double totalDiscountAmt = 0;
        String receiptData = "";
        receiptData += getGreetingMessage() + NEW_LINE + NEW_LINE;
        receiptData += "Sold to: " + getCustomerName() + NEW_LINE;
        receiptData += "Receipt No.: " + getReceiptNumber() + NEW_LINE;
        receiptData += getColumnHeading() + NEW_LINE;
        receiptData += "-------------------------------------------------------------------------" + NEW_LINE;
        for(LineItem item: lineItems){
            receiptData += item.getLineItemData() + NEW_LINE;
            netTotal += item.getSubTotal();
            totalDiscountAmt += item.getDiscountAmount();
        }
        receiptData += "---------" + NEW_LINE;;
        receiptData += netTotal + NEW_LINE;
        receiptData += totalDiscountAmt + NEW_LINE;;
        receiptData += getCalculatedGrandTotal(netTotal,totalDiscountAmt);
        return receiptData;
    }

    public final int getReceiptNumber() {
        return this.receiptNumber;
    }
    
    private String getGreetingMessage(){
        return "Thank you for shopping at " + this.getStore().getStoreName() + "!";
    }
    
    private String getCustomerName(){
        return ((customer.getName()== null)? "" : customer.getName());
    }
    
    private String getColumnHeading(){
        return "ID\tItem\t\t\tPrice\tQty\tSubtotal\tDiscount";
    }
    
    private double getCalculatedGrandTotal(double netTotal,double totalDiscountAmt){
        return (netTotal - totalDiscountAmt);
    }

    public final ReceiptDataAccessStrategy getDb() {
        return db;
    }

    public final void setDb(ReceiptDataAccessStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("Error: Database should not be null.");
        }
        this.db = db;
    }

    public final Store getStore() {
        return store;
    }

    public final void setStore(Store store) {
        if (store == null) {
            throw new IllegalArgumentException("Error: Store should not be null.");
        }
        this.store = store;
    }
    
    
}

