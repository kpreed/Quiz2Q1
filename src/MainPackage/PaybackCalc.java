package MainPackage;

import org.apache.poi.ss.formula.functions.FinanceLib;

/*
 * Why wouldn't you just create a class with static methods instead of having to create an object to run the methods?
 */

/**
 * The PaybackCalc object allows for the calculation for monthly school loan repayments with the FinanceLib pmt() method
 * 
 * @author kreed
 * 
 */
public class PaybackCalc 
{
	/**
	 * Attributes
	 */
	private double tuition;
	private double increase;
	private double APR;
	private double term;

	/**
	 * @param tuition the tuition the first year the student is in school
	 * @param increase the increase in tuition year to year (%)
	 * @param APR the interest rate while repaying the loan (%)
	 * @param term the repayment term in years
	 */
	public PaybackCalc(double tuition, double increase, double APR, double term)
	{
		this.setTuition(tuition);
		this.setIncrease(increase);
		this.setAPR(APR);
		this.setTerm(term);
	}
	
	/**
	 * @return tuition attribute
	 */
	public double getTuition() 
	{
		return tuition;
	}
	
	/**
	 * @param tuition sets the tuition attribute
	 */
	public void setTuition(double tuition) 
	{
		this.tuition = tuition;
	}

	/**
	 * @return the increase attribute
	 */
	public double getIncrease() 
	{
		return increase;
	}

	/**
	 * @param increase sets the increase attribute
	 */
	public void setIncrease(double increase) 
	{
		this.increase = increase;
	}

	/**
	 * @return the APR attribute
	 */
	public double getAPR() 
	{
		return APR;
	}
	
	/**
	 * @param APR sets the APR attribute
	 */
	public void setAPR(double APR) 
	{
		this.APR = APR;
	}
	
	/**
	 * @return the term attribute
	 */
	public double getTerm() {
		return term;
	}

	/**
	 * @param term sets the term attribute
	 */
	public void setTerm(double term) {
		this.term = term;
	}

	/**
	 * @return the total debt owed after 4 years of college
	 */
	public double totalCost()
	{
		double cost = 0;
		double currTuition = this.getTuition();
		
		for(int i = 1;i <= 4;i++)
		{
			cost += currTuition;
			currTuition *= (1+this.getIncrease()/100);
		}
		
		return cost;
	}
	
	/**
	 * @return the monthly repayment amount required to repay the loan in time
	 */
	public double repaymentAmnt()
	{
		return -1*FinanceLib.pmt(this.getAPR()/100/12,this.getTerm()*12,this.totalCost(),0,false);
	}
}
