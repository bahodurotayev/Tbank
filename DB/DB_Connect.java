import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connect {

    private static Connection conn=null;

    //connection string
    private static String url = "jdbc:mysql://doadmin:g434o0ww7bbkxusd@db-mysql-nyc1-do-user-7876940-0.a.db.ondigitalocean.com:25060/db_bank?ssl-mode=REQUIRED";

    // Defines username and password to connect to database server.
    private static String dbusername = "doadmin";
    private static String dbpassword = "g434o0ww7bbkxusd";

    public static Connection getConnect() {

        try {
            if(conn==null) {
                conn = DriverManager.getConnection(url, dbusername, dbpassword);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

   public static void CloseConnect(){
        try{
            if (conn!=null){
                conn.close();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }


   }




}
