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
public class NoDiscount implements ProductDiscountStrategy {

   
    @Override
    public final double getDiscountAmount(final double price, final int quantity) {
        return 0;
    }
    
}
