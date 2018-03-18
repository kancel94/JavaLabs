import java.sql.ResultSet; //import necessary packages
import java.sql.SQLException;

public class LoanProcessing extends BankRecords { //extends from BankRecords to be able to read data
	public static void main(String[] args) //main method
	{
		try
		{
		BankRecords br = new BankRecords(); //bankrecords object
		br.readData(); //read data so it can be used for dao
		
		Dao dao = new Dao(); //declaring dao object
		dao.createTable(); //calling to create table from Dao.java
		//comment out dao.deleteRecords(); if you need to delete records from previous run
		dao.deleteRecords(); //calling to delete any rows from previous runs
		dao.insertRecords(robjs); //calling to insert records from Dao.java
		
		
		//create resultset object
		ResultSet rs = dao.retrieveRecords(); 
		System.out.println();
		System.out.println("Loan Analysis Report");
		System.out.printf("%-13s%13s%13s%n", "ID" , "INCOME", "PEP"); //print this out in columnar format
		for (int i=0; i < 600; i++) //for loop so 
			while(rs.next()) //moves from one row to another
				System.out.printf("%-13s%13s%13s%n", rs.getObject(1), rs.getObject(2), rs.getObject(3)); //getting object so it is places id, income, and pep in right column
		} catch (SQLException e) //catch exception
		{
			System.out.println(e.getMessage()); //get message if exception is caught
		}
		new JTab(); //extra credit to create JTable of results after displaying retrieved records on console
	} //end main
} //end class
