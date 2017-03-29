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
public class ConsoleOutputStrategy implements DisplayOutputStrategy {

    @Override
    public final void displayOutput(final String receiptData) {
        System.out.println(receiptData);
    }
    
}
