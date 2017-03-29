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
public class QtyDiscount implements ProductDiscountStrategy {
    private double percentOff;
    private int minimumQuantity;

    public QtyDiscount(double percentOff, int minQuantity) {
        this.setPercentOff(percentOff);
        this.setQuantity(minQuantity);
    }
    
    @Override
    public final double getDiscountAmount(final double price, final int quantity) {
       return (quantity >= this.minimumQuantity)? (getCalculatedDiscountAmount(price,quantity)): 0;
    }
    
    public final double getPercentOff() {
        return percentOff;
    }

    public final void setPercentOff(double percentOff) {
        if(percentOff <= 0 || percentOff > 1){
            throw new IllegalArgumentException("Error: Percent-off discount cannot be less than or equal to 0 or greater than 1.");
        }
        this.percentOff = percentOff;
    }

    private void setQuantity(int minQty) {
        if(minQty <= 0){
            throw new IllegalArgumentException("Error: Quantity should be greater than 0.");
        }
        this.minimumQuantity = minQty;
    }

    private double getCalculatedDiscountAmount(double price, int quantity) {
        return price * this.percentOff * quantity;
    }
    
}
