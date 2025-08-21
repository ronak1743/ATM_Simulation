
import java.sql.*;

public class Con {
    public    Connection conn;
    public  Statement s;

    public Con(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsimulation","root","root@123");
            s = conn.createStatement();
        }
        catch (Exception e){
            
        }
    }

    public static void main(String[] args) {

    }
}
