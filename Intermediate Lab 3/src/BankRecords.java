import java.io.BufferedReader; //import necessary classes for program
import java.io.FileReader;
import java.io.IOException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Calendar;
import java.util.List;

public class BankRecords extends Client //will utilize Client abstract methods
{
	//create objects for processing & handling data
		static BankRecords robjs[]= new BankRecords[600]; //600 fields in csv file
		static List<List<String >> array = new ArrayList<>(); //array list
		
		//declaring each instance field (these will be the columns on the csv file
		private String id;
		private int age;
		private String sex;
		private String region;
		private double income;
		private String married;
		private int children;
		private String car;
		private String save_act;
		private String current_act;
		private String mortgage;
		private String pep;
		
		//constructors
		public BankRecords()
		{
		}
		public BankRecords(String id, int age, String sex, String region, double income, String married, int children, String car, String save_act, String current_act, String mortgage, String pep) 
		{
			super();
			this.id = id;
			this.age = age;
			this.sex = sex;
			this.region = region;
			this.income = income;
			this.married = married;
			this.children = children;
			this.car = car;
			this.save_act = save_act;
			this.current_act = current_act;
			this.mortgage = mortgage;
			this.pep = pep;
		}
		
		//generated getters and setters through Eclipse
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getRegion() {
			return region;
		}
		public void setRegion(String region) {
			this.region = region;
		}
		public double getIncome() {
			return income;
		}
		public void setIncome(double income) {
			this.income = income;
		}
		public String getMarried() {
			return married;
		}
		public void setMarried(String married) {
			this.married = married;
		}
		public int getChildren() {
			return children;
		}
		public void setChildren(int children) {
			this.children = children;
		}
		public String getCar() {
			return car;
		}
		public void setCar(String car) {
			this.car = car;
		}
		public String getSave_act() {
			return save_act;
		}
		public void setSave_act(String save_act) {
			this.save_act = save_act;
		}
		public String getCurrent_act() {
			return current_act;
		}
		public void setCurrent_act(String current_act) {
			this.current_act = current_act;
		}
		public String getMortgage() {
			return mortgage;
		}
		public void setMortgage(String mortgage_act) {
			this.mortgage = mortgage_act;
		}
		public String getPep() {
			return pep;
		}
		public void setPep(String pep) {
			this.pep = pep;
		}
		
		void readData() //method for reading data in csv file
		{
			 String line = "";
		     //open file in order to read and process	 
			  try (BufferedReader br = new BufferedReader(new FileReader("bank-Detail.csv"))) { //try catch 
			    
			    while ((line=br.readLine())!=null)  //read from file
			    	array.add(Arrays.asList(line.split(","))); //parse each record into array
			    
			    }   catch (IOException e) { //catch exception
			    	e.getMessage();
			    }
			 processData(); //next step is to process data
		}
		void processData() { //method for processing data
			
		    int idx=0;
		    for (List<String> rowData: array){
		    //initialize array
		    	//use setters to populate your array of objects
		    	robjs[idx] = new BankRecords();
		    
		    	robjs[idx].setId(rowData.get(0));
		    	robjs[idx].setAge(Integer.parseInt(rowData.get(1))); //parse int to string
		    	robjs[idx].setSex(rowData.get(2));
		    	robjs[idx].setRegion(rowData.get(3));
		    	robjs[idx].setIncome(Double.parseDouble(rowData.get(4))); //parse double to string
		    	robjs[idx].setMarried(rowData.get(5));
		    	robjs[idx].setChildren(Integer.parseInt(rowData.get(6))); //parse int to string
		    	robjs[idx].setCar(rowData.get(7));
		    	robjs[idx].setSave_act(rowData.get(8));
		    	robjs[idx].setCurrent_act(rowData.get(9));
		    	robjs[idx].setMortgage(rowData.get(10));
		    	robjs[idx].setPep(rowData.get(11));
		    	
		    idx++;
		    }	
		    	
		//printData(); //next step is to print data (turned this into comment since not needed for lab 3)
		}
		void printData() //method for printing the data
		{
			System.out.printf("%-13s%13s%13s%13s%13s%13s%n", "ID" , "AGE", "SEX", "REGION", "INCOME", "MORTGAGE"); 
			//display the headings for columns
			//create for loop to display each robjs object value	
		    	for(int i=0;i<25;i++) //for loop for first 25 records
		    		//display
		    		System.out.printf("%-13s%13s%13s%13s%13s%13s%n", robjs[i].getId(), robjs[i].getAge(), robjs[i].getSex(), robjs[i].getRegion(), robjs[i].getIncome(), robjs[i].getMortgage());
		    		//columnar format with 6 columns for id, age, sex, region, income, and mortgage
		}
		
		public static void main(String[] args) //main method
		{
			BankRecords thisObj = new BankRecords(); //create instance
			thisObj.readData(); //start with readData method
			System.out.println(); //white space
			//String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime()); //format time and date
			//System.out.println("Cur dt=" + timeStamp + "\nProgrammed by Timothy Kang\n"); //display name, date, time
		} //end main
} //end class
