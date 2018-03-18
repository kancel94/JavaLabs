/*
 * Timothy Kang
 * Due Date: 1/28/17
 * AccountHolderTest.java
 * Lab 1
 * AccountHolderTest class simulates a bank account by asking user for starting balance, giving them the option to withdraw or deposit money, and show a 12 month report.
 */
import java.util.Scanner; //import class to allow for user input
import java.text.SimpleDateFormat; //import class to format date and time
import java.util.Calendar; //import class to allow program to display date and time

public class AccountHolderTest { //access specifier that identifies AccountHolderTest as a class
	public static void main(String[] args) //main method
	{
		Scanner sc = new Scanner(System.in); //declaring scanner class 
		AccountHolder account; //creating AccountHolder object
		
		//program displays output statement
		System.out.println("Welcome to Bank of IIT. What is your starting balance?\n(Balance cannot be below $100.)");
		if(sc.hasNextDouble()) //if user inputs a double...
		{
		Double starting = sc.nextDouble(); //allow user to input a double
		account = new AccountHolder(starting); //creating AccountHolder object
		System.out.println(account); //outputs balance or other message depending on how much
		} else //if user inputs something that isnt a double (such as a letter)
		{
			System.out.println("Not a valid number... Please run the program again."); //displays this message
			return; //will end the program
		}
		
		System.out.println("Thank you."); //outputs this message
		
		int answer=1; //declare variable
		do { //do while loop
		System.out.println("\nWhat would you like to do?"); //output message
		//output a mini menu for user to decide what to do
		System.out.println("Enter 1 to deposit money\nEnter 2 to withdraw money\nEnter any number when you are done");
		if(sc.hasNextInt()) //if user inputs an integer (ex: 1 or 2)
		{
		answer= sc.nextInt(); //allow user to input their decision
		
		if (answer==1){ //if user inputs 1 output following message
		System.out.print("Enter a deposit amount: ");
		if(sc.hasNextDouble()) //if user inputs a double
		{
		Double dep = sc.nextDouble(); //allow user to deposit money
		account.deposit(dep); //deposit this amount and add to balance
		System.out.println("Your current balance after depositing is...\n"+ account); //output message
		} else //if user inputs things like letters 
		{
			System.out.println("Not a valid number... Please run the program again."); //displays this message
			return; //end the program
		}
		}
		
		if (answer==2){ //if user inputted 2 for withdrawal
		System.out.print("Enter a withdrawal amount: "); //this message will be displayed
		if(sc.hasNextDouble()) //if user inputs a double...
		{
		Double with = sc.nextDouble(); //allow user to withdraw money
		account.withdrawal(with); //withdraw this amount and subtract from balance
		System.out.println("Your current balance after withdrawing is...\n"+ account); //output message
		} else //if user inputs things like letters
		{
			System.out.println("Not a valid number... Please run the program again."); //displays this message
			return; //end the program
		}
		}
		}
		else //if user inputs things like letters instead of an integer
		{
			System.out.println("Not a valid number... Please run the program again."); //displays this message
			return; //end the program
		}
		}		while (answer== 1 || answer==2); //this do-while loop will continue until user inputs a number that isnt 1 or 2
		
		System.out.println(); //white space
		System.out.println("Initial Interest Rate: 0.04"); //output message
		System.out.printf("%-11s%11s%n", "Months" , "Account Balance with Interest"); //columnar format (2 columns)
		System.out.printf("%-11s%11s%n", "Base" , account); //display base amount
		for (int months = 1; months <= 12; months++) //for loop from first month of year to last
		{
			String label = String.format("Month %d:", months); //formatting string
			account.monthlyInterest(); //call method in order to add monthly interest
			System.out.printf("%-11s%11s%n", label, account.toString()); //formatting new balance amounts so it's in dollar format
		}
		
		System.out.println(); //white space
		System.out.println("After 12 months, your interest rate has increased to: 0.05"); //display message
		System.out.printf("%-11s%11s%n", "Months" , "Account Balance with Interest"); //columnar format (2 columns)
		for (int months = 1; months <= 12; months++) //for loop from first month of year to last
		{
			String label = String.format("Month %d:", months); //formatting string
			double newinterest = 0.05; //hardcoding new interest
			account.modifyMonthlyInterest(newinterest); //changing interest from 4% to 5%
			account.monthlyInterest(); //call method in order to add monthly interest 
			System.out.printf("%-11s%11s%n", label, account.toString()); //formatting new balance amount
		}
		
		System.out.println(); //white space
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()); //format time and date
		System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Timothy Kang\n"); //display name, date, time

	} //end main
} //end class definition
