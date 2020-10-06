
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Samples_db extends DB_Connect {

    public static void main(String[] args) {
//
        DB_methods db = new DB_methods();
        db.SelectFrom("customer");
        System.out.println("-----------------------");

        String result1=db.loginCheck("serik","12345");
        System.out.println(result1);

        String result=db.loginCheck("baha","12345");
        String result2=db.loginCheck("baha1","54321");
        System.out.println(result);
        System.out.println(result2);


    }

}

