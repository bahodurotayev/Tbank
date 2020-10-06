import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try  {
            // Code here.
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sonoo","root","root");
//here sonoo is database name, root is username and password
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from emp");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            //return exception details here
        }
    }
}
