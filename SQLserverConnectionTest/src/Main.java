import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

		
public class Main {
		
	public static void main(String[] args) throws SQLException {
		
		
		System.out.println("Loading driver...");

		try {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerXADataSource");
		    System.out.println("Driver loaded!");
		} catch (ClassNotFoundException e) {
		    throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		}
		
		

		Connection conn = null;
		try {
		    conn = DriverManager.getConnection("jdbc:sqlserver://cestest01.database.windows.net:1433;database=test;user={insert your username here}@cestest01;password={insert your password here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
		    String schema = conn.getSchema();
            System.out.println("Successful connection - Schema: " + schema);
            System.out.println("Connection opened");
		    // Do something with the Connection
		    
		    if (conn != null) {
		        try {
		            conn.close();
		            System.out.println("Connection closed");
		        } catch (SQLException e) { /* ignored */}
		    }
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
}