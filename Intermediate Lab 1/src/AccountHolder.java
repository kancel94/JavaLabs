/*
 * Timothy Kang
 * Due Date: 1/28/17
 * AccountHolder.java
 * Lab 1
 * AccountHolder class has all the formulas, methods, and constructors for the AccountHolderTest to use
 */
public class AccountHolder {
	private static double annualInterestRate = 0.04; //declare private class level variable
	private double balance; //declare private class level variable

	public AccountHolder() //this constructor declares the starting balance at 0
	{
		balance = 0.0;
	}
	/**
	 * this constructor the number that user inputs to be the starting balance
	 * @param startBalance
	 */
	public AccountHolder(double startBalance)
	{
		if(startBalance>=100) //if starting balance that user inputs is greater than or equal to 100
		{
		balance = startBalance; //make it starting balance
		}
		else if(startBalance>=0 && startBalance<100) //but if starting balance that user inputs is between 0 and 100
		{
			System.out.println("BALANCE CANNOT GO BELOW 100!!! PLEASE RUN THE PROGRAM AGAIN!"); //display message
			System.exit(0); //exit out of program
		}
		else if(startBalance<0) //if user inputs a value under 0
		{
			System.out.println("BALANCE CANNOT BE NEGATIVE!!! PLEASE RUN THE PROGRAM AGAIN!"); //display message
			System.exit(0); //exit out of program
		}
	}
	/**
	 * Deposit method allows user to add money to balance
	 * @param amount
	 */
	public void deposit(double amount)
	{
		balance += amount;
	}
	/**
	 * Withdrawal method allows user to take out money from balance
	 * @param amount
	 */
	public void withdrawal(double amount)
	{
		if((balance-amount)>=500) //if resulting balance is greater than or equal to 500, it's ok
		{
			balance -= amount;
		}
		else if((balance-amount)>=100 && (balance-amount)<500) //if its between 100 and 500, extra 50 will be taken out
		{
			System.out.println("A transaction fee of $50 will be deducted from the balance since the balance has dropped below 500");
			balance = balance-amount-50;
		}
		else if((balance-amount)<100) //if its below 100, program will not allow you to do so
		{
			System.out.println("Error!!! You balance cannot go below $100!!!");
		}
		
	}
	/**
	 * monthly interest method to add monthly interest based on what the annual interest rate is
	 */
	public void monthlyInterest()
	{
		balance += balance * (annualInterestRate / 12.0);
	}
	/**
	 * updating monthly interest rate
	 * @param rateUpdate
	 */
	public static void modifyMonthlyInterest(double rateUpdate)
	{
		if (rateUpdate>=0 && rateUpdate<=1.0)
		annualInterestRate = rateUpdate;
	}
	/**
	 * formatting string so that it is in proper format since it deals with money
	 */
	public String toString()
	{
		return String.format("$%.2f", balance);
	}
}
