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
        Store store1 = new Store("Kohls");
        ReceiptDataAccessStrategy db = new InMemoryDataAccess();
        DisplayOutputStrategy output1 = new GuiOutputStrategy();
        DisplayOutputStrategy output2 = new ConsoleOutputStrategy();
        PosTerminal pos = new PosTerminal(store1, db, output1, output2);
        
        pos.startTransaction("100");
        pos.addItemToTransaction("A101", 2);
        pos.addItemToTransaction("B205", 2);
        pos.endTransaction();
    }
}
