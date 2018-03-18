import java.io.FileWriter; //import necessary classes for lab
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.text.DecimalFormat;

public class Records extends BankRecords //this class will utilize BankRecords
{
	private static FileWriter fw = null; //allows it to be visible

	public Records() //constructor in order to write to a file
	{
		try //try catch method 
		{
			File outputFile = new File("bankrecords.txt"); //create output txt file
			fw = new FileWriter(outputFile, false); //false for this lab since we don't want duplicates of data (make true if we add more info to csv file)
		} 
		catch (IOException e) //catch this exception
		{
			e.getMessage();
		}
	}
	private static void AverageIncComparator() //this is for calculating average
	{
		DecimalFormat twoPlace =  new DecimalFormat("0.00"); //formatting decimals to 2 digits since this deals with money
		double sum = 0; //initializing variable
		for(int i = 0; i<robjs.length; i++) //for loop
		{
			sum += robjs[i].getIncome(); //income after each iteration will be added in
		}
		double average= (sum/robjs.length); //formula for calculating average once everything is added up
		String content = "Overall Average Income: $" + twoPlace.format(average); //declaring a string variable for easier access
		System.out.println(content); //output this in eclipse
		try { //try catch exception
			fw.write("Overall Average Income: $" + twoPlace.format(average)); //output this in txt file
		} catch (IOException e) { //catch this exception
			e.getMessage();
		}
		System.out.println(); //white space
	}
		
	private static void MaxMinAgeComparator() //this is for finding the maximum and minimum age depending on location
	{
		Arrays.sort(robjs, new RegionComparator()); //calling array.sort and call up the class
		int maxInnerCity = 0, maxRural = 0, maxSuburban = 0, maxTown = 0; //initialize these variables 
		
		for (int i = 0; i < robjs.length; i++) //for loop
		{
			if (robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getAge() > maxInnerCity) //if the region is INNER CITY and age is greater than the current "max" age
			{
				maxInnerCity = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("RURAL") && robjs[i].getAge() > maxRural) //if the region is RURAL and age is greater than the current "max" age
			{
				maxRural = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("SUBURBAN") && robjs[i].getAge() > maxSuburban) //if the region is SUBURBAN and age is greater than the current "max" age
			{
				maxSuburban = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("TOWN") && robjs[i].getAge() > maxTown) //if the region is TOWN and age is greater than the current "max" age
			{
				maxTown = robjs[i].getAge(); //assign new age
			}
		}
		int minInnerCity = maxInnerCity, minRural = maxRural, minSuburban = maxSuburban, minTown = maxTown; //initialize variables so that it begins from the max
		for (int i = 0; i < robjs.length; i++) //new for loop for minimum
		{
			if (robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getAge() < minInnerCity) //if the region is INNER CITY and age is less than current "min" age
			{
				minInnerCity = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("RURAL") && robjs[i].getAge() < minRural) //if the region is RURAL and age is less than current "min" age
			{
				minRural = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("SUBURBAN") && robjs[i].getAge() < minSuburban) //if the region is SUBURBAN and age is less than current "min" age
			{
				minSuburban = robjs[i].getAge(); //assign new age
			}
			if (robjs[i].getRegion().equals("TOWN") && robjs[i].getAge() < minTown) //if the region is TOWN and age is less than current "min" age
			{
				minTown = robjs[i].getAge(); //assign new age
			}
		}
		System.out.println("Maximum Age Per Location..."); //output this
		System.out.printf("%-10s%10s%10s%10s%n", "Inner City", "Rural", "Suburban", "Town"); //output this in columnar format
		System.out.printf("%10s%10s%10s%10s%n", maxInnerCity, maxRural, maxSuburban, maxTown); //output this in columnar format
		System.out.println(); //white space
		System.out.println("Minimum Age Per Location..."); //output this in columnar format
		System.out.printf("%-10s%10s%10s%10s%n", "Inner City", "Rural", "Suburban", "Town"); //output this in columnar format
		System.out.printf("%10s%10s%10s%10s%n", minInnerCity, minRural, minSuburban, minTown); //output this in columnar format
		System.out.println(); //white space
		
		try { //try catch for filewrite
			fw.write("\n\nMaximum Age Per Location...\n"); //output this in in txt file
			fw.write(String.format("%-10s%10s%10s%10s%n", "Inner City", "Rural", "Suburban", "Town")); //output this in columnar format for txt file
			fw.write(String.format("%10s%10s%10s%10s%n", maxInnerCity, maxRural, maxSuburban, maxTown)); //output this in columnar format for txt file
			
			fw.write("\nMinimum Age Per Location...\n"); //output this in txt file
			fw.write(String.format("%-10s%10s%10s%10s%n", "Inner City", "Rural", "Suburban", "Town")); //output this in columnar format for txt file
			fw.write(String.format("%-10s%10s%10s%10s%n", minInnerCity, minRural, minSuburban, minTown)); //output this in columnar format for txt file
		} catch (IOException e) { //catch exception
			e.getMessage();
		} 
	}
	
	private static void FemaleMortComparator() //this is for finding # of females with mortgages
	{
		Arrays.sort(robjs,new FemaleMortComparator()); //calling array.sort and call up the class
		int femaleCount = 0; //initialize the counter
		for (int i = 0; i<robjs.length; i++) //for loop
		{
			if(robjs[i].getSex().equals("FEMALE") && robjs[i].getMortgage().equals("YES")) //if the person is a female AND they have mortgage
			{
				femaleCount += 1; //counter goes up by one
			}
		}
		System.out.println("Number of females with mortgages: " + femaleCount); //output this on eclipse
		try { //try catch exception for txt file 
			fw.write("\nNumber of females with mortgages: " + femaleCount); //output this in txt file
		} catch (IOException e) { //catch ex
			e.getMessage();
		}
	}
	
	private static void MalesCarChildComparator() //this is for finding # of males with a car and a child per location
	{
		Arrays.sort(robjs, new RegionComparator()); //calling array.sort and call up the class
		int maleCountInnerCity = 0, maleCountRural = 0, maleCountSuburban = 0, maleCountTown = 0;
		
		for (int i = 0; i < robjs.length; i++) //for loop
		{
			if (robjs[i].getRegion().equals("INNER_CITY") && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1)
			{ //if they live in inner city, are male, have a car, and have 1 child...
				maleCountInnerCity += 1; //increase counter by 1
			}
			if (robjs[i].getRegion().equals("RURAL") && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1)
			{ //if they live in rural, are male, have a car, and have 1 child...
				maleCountRural += 1; //increase counter by 1
			}
			if (robjs[i].getRegion().equals("SUBURBAN") && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1)
			{ //if they live in suburbs, are male, have a car, and have 1 child...
				maleCountSuburban += 1; //increase counter by 1
			}
			if (robjs[i].getRegion().equals("TOWN") && robjs[i].getSex().equals("MALE") && robjs[i].getCar().equals("YES") && robjs[i].getChildren() == 1)
			{ //if they live in town, are male, have a car, and have 1 child...
				maleCountTown += 1; //increase counter by 1
			} 
		}
		System.out.println(); //white space
		System.out.println("Number of males with both a car AND 1 child per location... "); //output this in eclipse
		System.out.printf("%-10s%10s%n", "Inner City", maleCountInnerCity); //output in columnar format
		System.out.printf("%-10s%10s%n", "Rural", maleCountRural); //output in columnar format
		System.out.printf("%-10s%10s%n", "Suburban", maleCountSuburban); //output in columnar format
		System.out.printf("%-10s%10s%n", "Town", maleCountTown); //output in columnar format

		try { //try catch for txt file
			fw.write("\n\nNumber of males with both a car AND 1 child per location... \n"); //output this in txt file
			fw.write(String.format("%-10s%10s%n", "Inner City", maleCountInnerCity)); //output this in columnar format in txt file
			fw.write(String.format("%-10s%10s%n", "Rural", maleCountRural)); //output this in columnar format in txt file
			fw.write(String.format("%-10s%10s%n", "Suburban", maleCountSuburban)); //output this in columnar format in txt file
			fw.write(String.format("%-10s%10s%n", "Town", maleCountTown)); //output this in columnar format in txt file
		} catch (IOException e) { //catch exception
			e.getMessage();
		}
	}
	
	public static void main(String[] args) //main method
	{
		BankRecords br = new BankRecords(); //linkage to BankRecords class
		br.readData(); //fill the arrays
		new Records(); //constructor
		//analysis functions
		AverageIncComparator(); //
		MaxMinAgeComparator();
		FemaleMortComparator();
		MalesCarChildComparator();
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()); //format time and date
		System.out.println("\nCur dt=" + timeStamp + "\nProgrammed by Timothy Kang"); //output
		
		try { //try catch for txt file 
			fw.write("\nCur dt=" + timeStamp + "\nProgrammed by Timothy Kang"); //output time, date, and name in txt file
		} catch (IOException e) { //catch exception
			e.getMessage();
		}
		try 
		{
			fw.close(); //since we opened the file, we have to close it
		}
		catch (IOException e) //catch exception
		{
			e.getMessage();
		}
	}//end main
} //end class

