package MainPackage;

import java.util.Scanner;

/**
 * Main class. Accepts user inputs using the Scanner object, creates a PaybackCalc object, 
 * and calculates the monthly loan payment and prints in to 2 decimal places.
 * 
 * @author kreed
 */
public class TuitionPayback 
{
	public static void main(String[] args) 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("What is the tuition this year?");
		double tuition = input.nextDouble();
		System.out.println("What is the annual increase in tuition year to year? (%)");
		double increase = input.nextDouble();
		System.out.println("What is the repayment APR?");
		double APR = input.nextDouble();
		System.out.println("What is the repayment term? (years)");
		double term = input.nextDouble();
		
		input.close();
		
		PaybackCalc calc = new PaybackCalc(tuition,increase,APR,term);
		
		System.out.printf("\nThe total cost of tuition will be: $%.2f",calc.totalCost());
		System.out.printf("\nYou need to pay back: $%.2f",calc.repaymentAmnt());
		System.out.printf(" a month to repay your loans in time");
	}
}
