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
public class DiscountStrategyProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InvoiceDataAccessStrategy db = new InMemoryDataAccess();
        PosTerminal pos = new PosTerminal();
        
        pos.startTransaction("100",db);
        pos.addItemToTransaction("A100", 2, db);
        pos.addItemToTransaction("A101", 2);
        pos.endTransaction();
    }
}
