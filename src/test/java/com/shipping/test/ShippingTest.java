package com.shipping.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.shipping.service.ShippingService;

@RunWith(Parameterized.class)
public class ShippingTest {
	ShippingService service = null;
	
	@Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][] {
            {2, 100, 1000},
            {10, 100, 1500},
            {25, 100, 2000},
            {10, 1, 15},
            {100, 50, 1000},
            {0, 100,1000}
            
        });
    }
	
    double weight;
    int distance;
    double expectedValue;
    
    public ShippingTest(double weight, int distance, double expectedValue) {
        this.weight = weight;
        this.distance = distance;
        this.expectedValue = expectedValue;
        
    }
	
	
	@BeforeClass
	public static void first() {
		
		System.out.println("Before All");
	}

	@AfterClass
	public static void last() {
		//bill = new EbillService();
		System.out.println("After All");
	}
	
	@Before
	public void firstEvery() {
		
		System.out.println("Before");
	}

	@After
	public void lastEvery() {
		
		System.out.println("After");
	}

	@Test
	public void testCalculateShippingCost_LightPackage() {
		service = new ShippingService(this.weight, this.distance);
		assertEquals(this.expectedValue, service.calculateShippingCost(), 0.001);
	}

	/*@Test
	public void testCalculateShippingCost_MediumPackage() {
		service = new ShippingService(10, 100);
		assertEquals(1500, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_HeavyPackage() {
		service = new ShippingService(25, 100);
		assertEquals(2000, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_MinimalDistance() {
		service = new ShippingService(10, 1); // Minimal distance with a medium weight package
		assertEquals(15, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_VeryHeavyPackage() {
		service = new ShippingService(100, 50); // Very heavy package with moderate distance
		assertEquals(1000, service.calculateShippingCost(), 0.001);
	}

	@Test
	public void testCalculateShippingCost_ZeroWeightPackage() {
		service = new ShippingService(0, 100); // Edge case: zero weight (should handle as the lightest package)
		assertEquals(1000, service.calculateShippingCost(), 0.001);
	}*/
}