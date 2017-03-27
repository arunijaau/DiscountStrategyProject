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
        for(LineItem item: lineItems){
            receiptData += item.getLineItemData() + NEW_LINE;
            netTotal += item.getSubTotal();
            totalDiscountAmt += item.getDiscountAmount();
        }
        receiptData += netTotal + NEW_LINE;
        receiptData += totalDiscountAmt;
        receiptData += getCalculatedGrandTotal(netTotal,totalDiscountAmt);
        return receiptData;
    }

    public final int getReceiptNumber() {
        return this.receiptNumber;
    }
    
    private String getGreetingMessage(){
        return "Thank you for shopping at " + store.getStoreName() + "!";
    }
    
    private String getCustomerName(){
        return (customer.getName()== null)? "" : customer.getName();
    }
    
    private String getColumnHeading(){
        return "ID\tItem";
    }
    
    private double getCalculatedGrandTotal(double netTotal,double totalDiscountAmt){
        return netTotal - totalDiscountAmt;
    }
}

