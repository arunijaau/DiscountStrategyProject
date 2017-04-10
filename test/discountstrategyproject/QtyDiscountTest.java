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

                }

            }
        }

    }
    
   
    

    /**
     * Test of getDiscountAmount method, of class QtyDiscount.
     */
    @Test
    public void testGetDiscountAmount() {

    }

    /**
     * Test of getPercentOff method, of class QtyDiscount.
     */
    /**
     * Test of setPercentOff method, of class QtyDiscount.
     */
    

}
