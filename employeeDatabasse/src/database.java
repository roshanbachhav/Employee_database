import java.sql.*;
public class database {

	Connection con = null;
	public static Connection dbconnector()
	{

        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("jdbc:sqlite:C://sqlite//rv.db");
            return con;
            }catch (Exception e) {
            	System.out.println("Opps something went wrong...");
        }
		return null;
    }
}