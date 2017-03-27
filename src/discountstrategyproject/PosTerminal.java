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
public class PosTerminal {
    private Receipt receipt;
    private DisplayOutputStrategy output1;
    private DisplayOutputStrategy output2;

    public PosTerminal(DisplayOutputStrategy output1, DisplayOutputStrategy output2) {
        this.output1 = output1;
        this.output2 = output2;
    }

    public final void startTransaction(String customerId, ReceiptDataAccessStrategy db) {
        this.receipt = new Receipt(customerId, db);
    }

    public final void addItemToTransaction(String productId, int quantity, ReceiptDataAccessStrategy db) {
        this.receipt.addLineItem(productId, quantity, db);
    }

    public final void endTransaction() {
        output1.displayOutput(receipt.getReceiptData());
        output2.displayOutput(receipt.getReceiptData());
    }
    
    public DisplayOutputStrategy getOutput1() {
        return output1;
    }

    public void setOutput1(DisplayOutputStrategy output1) {
        if(output1 == null){
            throw new IllegalArgumentException("Error: Output1 should not be null.");
        }
        this.output1 = output1;
    }

    public DisplayOutputStrategy getOutput2() {
        return output2;
    }

    public void setOutput2(DisplayOutputStrategy output2) {
         if(output2 == null){
            throw new IllegalArgumentException("Error: Output2 should not be null.");
        }
        this.output2 = output2;
    }
    
}
