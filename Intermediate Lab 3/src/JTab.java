import java.awt.BorderLayout; //import necessary packages
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class JTab extends JFrame { 
    public JTab()
    {
        try {
  
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection dbConn = DriverManager.getConnection("jdbc:mysql://www.papademas.net/411labs?"
                                                               + "user=db411&password=411");
            Statement st = dbConn.createStatement();
    	    //create vectors for JTable
    	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            Vector<String> column = new Vector<String>();
    	try {
    	    st = dbConn.createStatement();
    	    Dao dao = new Dao();	
    	    ResultSet res = dao.retrieveRecords();
    	    ResultSetMetaData metaData = res.getMetaData();
    	    int columns = metaData.getColumnCount();
    	   
    	    //get column names from table!
    	    String cols = ""; 
    	 
    	    for (int i = 1; i <= columns ; i++) {
    	       cols = metaData.getColumnName(i);
    	       column.add(cols);
    	    }
    	    //get row data from table!
    	    while (res.next()) {
    	       Vector<Object> row = new Vector<Object>(columns);
    	          
    	       for (int i = 1; i <= columns; i++) {
    	        row.addElement(res.getObject(i));
    	       } 
    	       data.addElement(row);
 	        }
      
    	} catch (SQLException e) {
    	    e.getMessage();
    	}
   	
    	JTable table = new JTable(data,column);
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );

        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
        
        JFrame frame = new JFrame("Loan Details");
		frame.setSize(700, 200);
		frame.add(new JScrollPane(table));
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible(true);
    }
        catch (InstantiationException e) {
            System.err.println("Error in Instantiation!");
        }
        
        catch (ClassNotFoundException e) {
            System.err.println("Class not found!");
        }
        
        catch (IllegalAccessException e) {
            System.err.println("Access denied!");
        }
     
        catch (SQLException e) {
            System.err.println("SQL Error! " + e.getMessage() );
        } 
    }
    //commented out since main method in loan processing is calling for this method
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JTab();  //fire constructor to display Table in JFrame!

	}*/

}
