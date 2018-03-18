import java.sql.PreparedStatement;
import java.sql.ResultSet; //import necessary packages
import java.sql.SQLException;
import java.sql.Statement;

public class Dao extends BankRecords { //class extending from BankRecords
	
	Connector connect = new Connector(); //object
	private Statement statement= null; //declare as null
	
	public void createTable() //method to create table
	{
		try //try catch method
		{
			//create table
			statement= connect.getConnection().createStatement();
			
			/*extra code for dropping a table (not needed since we dont have the power to drop tables in this database)
			 *this is not part of the lab, uncomment code below if you want this function
			 *basically drops a table if it already exists
			 */
			//System.out.println("Deleting table in given database...");
			//String sql = "DROP TABLE t_kang_tab3";
			//statement.executeUpdate(sql);
			//System.out.println("Table deleted in given database...");
			
			//create connection
			String sql = "CREATE TABLE t_kang_tab3" +
						"(pid INTEGER not NULL AUTO_INCREMENT, " +
						" id VARCHAR(7), " +
						" income NUMERIC(9,2), " +
						" pep VARCHAR(3), " +
						" PRIMARY KEY ( pid ))";
			//for income, 8 is precision and 2 is scale (decimal places)--> defense mechanism
			//created string variable to make it cleaner when i call it 
			
			statement.executeUpdate(sql); //executing update 
			System.out.println("Created table in given database..."); //message to assure user that it has been created
			statement.close(); //close the statement to end it
			//end create table	
		} catch (SQLException e){ //most detailed catch statement
			System.out.println(e.getMessage()); //print out message if exception is caught
		} 
	}
	
	public void insertRecords(BankRecords [] objs) //method to insert records from csv to database
	{
		   try{ //try catch to catch exceptions
			   //originally used statement but changed to preparedstatment so it is commented out
			  //statement = connect.getConnection().createStatement(); //calls on connector.java 
			  //String sql= null; //declare sql as null
			   
			   String insertTableSQL= "INSERT INTO t_kang_tab3" 
		    			  + "(id, income, pep) VALUES"
		    			  		+ " (?, ?, ?)"; //declaring by using metacharacters the variables for prepared statement 
		    	  PreparedStatement preparedstatement = connect.getConnection().prepareStatement(insertTableSQL); //declaring prepared statement so that it will insert once for loop begins
		      System.out.println("Connected database successfully..."); //message stating that database was connected
		      
		      //Execute a query
		      System.out.println("Inserting records into the table...");
		      
		      //read in bankrecords object
		      for(int i = 0; i<objs.length; ++i) //for loop
		      {
		    	  preparedstatement.setString(1, objs[i].getId()); //prepared statement for each category
		    	  preparedstatement.setDouble(2, objs[i].getIncome());
		    	  preparedstatement.setString(3, objs[i].getPep());
		    	  
		    	  //this is what I originally had but no need for this since I added preparedstatements
		    	  //sql = "INSERT INTO t_kang_tab3 (id, income, pep) " +
		    			  		//"VALUES ('"+objs[i].getId()+"','"+objs[i].getIncome()+"','"+objs[i].getPep()+"')"; //inputs these values in appropriate locations
		    	  //statement.executeUpdate(sql); //update database 
		    	  
		    	  preparedstatement.executeUpdate(); //update database
		      }
		      
		      System.out.println("Inserted records into the table..."); //message stating that records were inserted
		      statement.close(); //close to end 
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      System.out.println(se.getMessage());
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.getMessage();
		   }
		}//end JDBCExample
	
	public ResultSet retrieveRecords() //method for retrieving data from database
	{
		ResultSet rs = null; //declare object

		try{ //try catch to catch exception
			System.out.println("Creating select statement..."); //output message
			statement= connect.getConnection().createStatement(); //calling from connector.java
			String sql = "select id, income, pep from t_kang_tab3 order by pep desc"; //resultset query string to put in descending order
			
			rs = statement.executeQuery(sql); //execute query
			
		} catch(SQLException e) //catch this exception
		{
			System.out.println(e.getMessage());
		} 
		System.out.println("Success!"); //print message after query is executed
		return rs; //return object
	}
	
	public void deleteRecords() //method for deleting records
	{
		try //try catch to catch exception
		{
			System.out.println("Deleting the table records (if there are any)..."); //output statement
			statement= connect.getConnection().createStatement(); //calling from connector.java
			String sql = "DELETE FROM t_kang_tab3"; //deleting from table
			statement.executeUpdate(sql); //execute update
			System.out.println("Table Records Deleted!"); //output statement
			statement.close(); //close
		} catch (SQLException e) //catch exception
		{
			System.out.println(e.getMessage());
		}
	}
} //end class
