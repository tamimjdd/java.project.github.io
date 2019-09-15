package accounting.software.final_classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {

private static Connection conn;
private static String url = "jdbc:sqlserver://localhost:1433;databaseName=Accounts;user=tamimdb;password=tamim";

public static Connection connect() throws SQLException{
        try{
            Class.forName("com.sqlserver.jdbc.Driver").newInstance();
        }catch(ClassNotFoundException cnfe){
            System.err.println("Error: "+cnfe.getMessage());
        }catch(InstantiationException ie){
            System.err.println("Error: "+ie.getMessage());
        }catch(IllegalAccessException iae){
            System.err.println("Error: "+iae.getMessage());
        }

        conn = DriverManager.getConnection(url);
        return conn;
    }
 
public static Connection getConnection() throws SQLException, ClassNotFoundException{
        if(conn !=null && !conn.isClosed())
            return conn;
        connect();
        return conn;

    }

}