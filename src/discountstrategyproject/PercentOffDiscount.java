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
public class PercentOffDiscount implements ProductDiscountStrategy {

    private double percentOff;

    public PercentOffDiscount(double percentOff) {
        this.setPercentOff(percentOff);
    }

    @Override
    public final double getDiscountAmount(final double price, final int quantity) {
        return price * this.percentOff * quantity;
    }

    public double getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(double percentOff) {
        if(percentOff <= 0 || percentOff > 1){
            throw new IllegalArgumentException("Error: Percent-off discount cannot be less than or equal to 0 or greater than 1.");
        }
        this.percentOff = percentOff;
    }
}
