import java.sql.Connection; //import necessary packages
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector { //created connector class so that I do not have to put the same information multiple times
	Connection connect = null; //decalre object as null
	public Connection getConnection() 
	{
		try //try catch to catch exception
		{
			//This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			//Setup the connection with the DB
			connect = DriverManager
					.getConnection("jdbc:mysql://www.papademas.net/411labs?"
							+ "user=db411&password=411");
		} catch (SQLException e) //catch this exception
		{
			System.out.println(e.getMessage()); //display message
		} catch (ClassNotFoundException e) //catch this exception
		{
			e.getMessage(); //get message if exception is caught
		}
		return connect; //return since there is no static
	}
}
