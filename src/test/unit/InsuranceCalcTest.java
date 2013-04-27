package test.unit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InsuranceCalcTest {
	
	private InsuranceCalc calc;

	@Before
	public void setUp() throws Exception {
		calc = new InsuranceCalc();
	}

	@After
	public void tearDown() throws Exception {
		calc = null;
	}
	
	public void assertCalculate(int age, int point, double expected) {
		Assert.assertEquals(String.format("Testing with (age:%d,point:%d).\n", age, point), expected, calc.calculate(point, age), 0.0001);
	}

	@Test
	public void testCalculate() {
		assertCalculate(16, 0, 2.8*500-50);
		assertCalculate(16, 1, 500*2.8);
		assertCalculate(25, 0, 500*1.8-50);
		assertCalculate(25, 3, 500*1.8);
		assertCalculate(35, 0, 500*1-100);
		assertCalculate(35, 5, 500);
		assertCalculate(45, 0, 500*0.8-150);
		assertCalculate(45, 7, 500*0.8);
		assertCalculate(60, 0, 500*1.5-200);
		assertCalculate(65, 5, 500*1.5);
		
		try {
			calc.calculate(0, 100);
			Assert.fail();
		} catch(UnsupportedOperationException ex) {
		}
		
		try {
			calc.calculate(0, 15);
			Assert.fail();
		} catch(UnsupportedOperationException ex) {
		}
		
		try {
			calc.calculate(12, 16);
			Assert.fail();
		} catch(UnsupportedOperationException ex) {
		}
	}

}
