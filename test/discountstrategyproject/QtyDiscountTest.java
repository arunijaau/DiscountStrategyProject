/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ajayasooriya
 */
public class QtyDiscountTest {

    public QtyDiscountTest() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void testConstructorForValidMinQtyAndPercentOffCombinations() {
        int[] goodMinQuantities = {1, 100, 500};
        double[] goodDiscountPercents = {.1, .8, .3, .7};

        for (int qty : goodMinQuantities) {
            for (double perct : goodDiscountPercents) {
                QtyDiscount d = new QtyDiscount(perct, qty);
            }
        }

    }

    @Test
    public void testConstructorForInvalidMinQtyAndPercentOffCombinations() {
        int[] invalidQuantities = {-1, 0};
        double[] invalidPercents = {-1, -0.1, 1.1, 2.0, 100.0};

        for (int qty : invalidQuantities) {
            for (double perct : invalidPercents) {
                try {
                    QtyDiscount d = new QtyDiscount(perct, qty);
                    fail("Invalid values accepted.");
                } catch (IllegalArgumentException e) {
                    // success
                }
            }
        }

    }

    /**
     * Test of getDiscountAmount method, of class QtyDiscount.
     */
    @Test
    public void testGetDiscountAmountShouldNotAllowInputLessThanOrEqualToZero() {
        double[] invalidPrices = {0, -0.5, -1, -10};
        int[] invalidQty = {0, -1, -6, -100};
        QtyDiscount discount = new QtyDiscount(0.2, 4);

        for (double price : invalidPrices) {
            for (int qty : invalidQty) {
                try {
                    discount.getDiscountAmount(price, qty);
                    fail("Bad vlues less than zero were accepted.");
                } catch (IllegalArgumentException e) {
                    // success
                }
                
            }
        }
    }

    @Test
    public void testGetDiscountAmountShouldAllowInputGreaterThanZero() {
        double[] validPrices = {0.50, 1.00, 104.00, 1000.00};
        int[] validQty = {1, 6, 50, 100};
        QtyDiscount discount = new QtyDiscount(0.2, 4);

        for (double price : validPrices) {
            for (int qty : validQty) {
                discount.getDiscountAmount(price, qty);
            }
        }
    }
    
    @Test
    public void testGetDiscountAmountShouldBeZeroWithQtyLessThanMinQty(){
        QtyDiscount discount = new QtyDiscount(0.2, 4);
        double expected = 0;
        double actual = discount.getDiscountAmount(10,3);
        assertEquals(expected,actual,0.009);
    }
    
    @Test
    public void testGetDiscountAmountShouldNotBeZeroWithQtyGreaterThanMinQty(){
        QtyDiscount discount = new QtyDiscount(0.2, 4);
        double expected = 10 * 0.2 * 5;
        double actual = discount.getDiscountAmount(10,5);
        assertEquals(expected,actual,0.01);
    }
    
//    @Test
//    public void testConstructorGoodMinQtyShoulBeGreaterThanZero() {
//        try {
//            QtyDiscount d = new QtyDiscount(.10, 5);
//        } catch (IllegalArgumentException e) {
//            fail("Good values were not accepted.");
//        }
//    }
    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorBadMinQtyCannotBeLessThanZero() {
//        QtyDiscount d = new QtyDiscount(.10, -1);
//    }
    
//    @Test(expected = IllegalArgumentException.class)
//    public void testConstructorPercentOffShouldNotBeGreaterThanOne() {
//        QtyDiscount d = new QtyDiscount(2, 3);
//    }

    /**
     * Test of getPercentOff method, of class QtyDiscount.
     */
    /**
     * Test of setPercentOff method, of class QtyDiscount.
     */
}
