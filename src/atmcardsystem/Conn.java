package atmcardsystem;
import java.sql.*;
public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try{
        String url = "jdbc:mysql://localhost:3306/atm";
        c = DriverManager.getConnection(url, "root", "123");
        s = c.createStatement();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}
