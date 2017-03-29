/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import javax.swing.JOptionPane;

/**
 *
 * @author Aruni
 */
public class GuiOutputStrategy implements DisplayOutputStrategy{

   
    @Override
    public final void displayOutput(final String receiptData) {
        JOptionPane.showMessageDialog(null, receiptData);
    }
    
}
