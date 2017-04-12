/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategyproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Aruni
 */
public class ProductTest {

    private Product instance;

    public ProductTest() {
    }

    @Before
    public void setUp() {
        instance = new Product("A101", "Men's Dress Shirt", 35.50, new QtyDiscount(0.10, 5));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDiscountStrategy method, of class Product.
     */
    /**
     * Test of setDiscountStrategy method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDiscountStrategyShouldNotAllowNull() {
        instance.setDiscountStrategy(null);
    }

    /**
     * Test of getProductId method, of class Product.
     */
    /**
     * Test of setProductId method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetProductIdShouldNotAllowNull() {
        instance.setProductId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProductIdShouldNotAllowEmpty() {
        instance.setProductId("");
    }

    /**
     * Test of getProductName method, of class Product.
     */
    /**
     * Test of setProductName method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetProductNameShouldNotAllowNull() {
        instance.setProductName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProductNameShouldNotAllowEmpty() {
        instance.setProductName("");
    }

    /**
     * Test of getPrice method, of class Product.
     */

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPriceShouldNotAllowValuesLessThanOrEqualToZero() {
        double[] invalidPrices = {0.00, -1.20, -0.50, -98.00};

        for (double price : invalidPrices) {
            try {
                instance.setPrice(price);
                fail("Invalid prices were accepted.");
            } catch (IllegalArgumentException e) {
                //success
            }
        }
    }

    @Test
    public void testSetPriceShouldAllowValuesGreaterThanZero() {
        double[] validPrices = {1.00, 6.50, 50.00, 98.00};

        for (double price : validPrices) {
            instance.setPrice(price);
        }
    }

}
