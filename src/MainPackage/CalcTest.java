package MainPackage;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CalcTest tests four separate school loan monthly repayments calculated by the PaybackCalc object
 * 
 * @author kreed
 */
public class CalcTest 
{
	private static PaybackCalc case1;
	private static PaybackCalc case2;
	private static PaybackCalc case3;
	private static PaybackCalc case4;
	
	/**
	 * Constructs 4 PaybackCalc objects with different parameters
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		case1 = new PaybackCalc(12520,5,10,30);
		case2 = new PaybackCalc(15550,10,15,10);
		case3 = new PaybackCalc(13501,3,8,20);
		case4 = new PaybackCalc(18363,8,12,15);
	}
	
	/**
	 * Tests to make sure the monthly payback amount is correct
	 */
	@Test
	public void test() 
	{
		double pay1 = Math.round(case1.repaymentAmnt()*100);
		double pay2 = Math.round(case2.repaymentAmnt()*100);
		double pay3 = Math.round(case3.repaymentAmnt()*100);
		double pay4 = Math.round(case4.repaymentAmnt()*100);
		pay1 /= 100;
		pay2 /= 100;
		pay3 /= 100;
		pay4 /= 100;
		
		assertTrue(pay1 == 473.56);
		assertTrue(pay2 == 1164.31);
		assertTrue(pay3 == 472.45);
		assertTrue(pay4 == 993.09);
	}

}
