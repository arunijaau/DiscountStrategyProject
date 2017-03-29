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
    private ReceiptDataAccessStrategy db;
    private DisplayOutputStrategy output1;
    private DisplayOutputStrategy output2;
    private Store store;

    public PosTerminal(Store store1, ReceiptDataAccessStrategy db, DisplayOutputStrategy output1, DisplayOutputStrategy output2) {
        this.setStore(store1);
        this.setDb(db);
        this.setOutput1(output1);
        this.setOutput2(output2);
    }

    public final void startTransaction(String customerId) {
        this.receipt = new Receipt(this.store, customerId, this.db);
    }

    public final void addItemToTransaction(String productId, int quantity) {
        this.receipt.addLineItem(productId, quantity);
    }

    public final void endTransaction() {
        db.saveReceipt(this.receipt);
        this.output1.displayOutput(this.receipt.getReceiptData());
        this.output2.displayOutput(this.receipt.getReceiptData());
    }

    public final DisplayOutputStrategy getOutput1() {
        return this.output1;
    }

    public final void setOutput1(DisplayOutputStrategy output1) {
        if (output1 == null) {
            throw new IllegalArgumentException("Error: Output1 should not be null.");
        }
        this.output1 = output1;
    }

    public final DisplayOutputStrategy getOutput2() {
        return this.output2;
    }

    public final void setOutput2(DisplayOutputStrategy output2) {
        if (output2 == null) {
            throw new IllegalArgumentException("Error: Output2 should not be null.");
        }
        this.output2 = output2;
    }

    public final ReceiptDataAccessStrategy getDb() {
        return this.db;
    }

    public final void setDb(ReceiptDataAccessStrategy db) {
        if (db == null) {
            throw new IllegalArgumentException("Error: Database should not be null.");
        }
        this.db = db;
    }

    public final Store getStore() {
        return this.store;
    }

    public final void setStore(Store store) {
        if (store == null) {
            throw new IllegalArgumentException("Error: Store should not be null.");
        }
        this.store = store;
    }

}
