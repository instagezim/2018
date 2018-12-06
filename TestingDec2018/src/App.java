import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.Statement;


public class App {
	  public static void main(String[] args){
	//Registering the JDBC database driver.
	Class.forName ("org.h2.Driver"); 
	// Opening the connection.
	Connection conn = DriverManager.getConnection ("jdbc:h2:~/test", "sa",""); 
	//Creating a statement.
	Statement st = conn.createStatement(); 
	//Executing a statement and receiving Resultset.
	Stmt.executeUpdate("sql statement"); 
	//Closing a connection.
	conn.close(); 

	  }
	
}
