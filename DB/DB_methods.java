import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DB_methods {
    Connection conn;

    public DB_methods(){
        conn = DB_Connect.getConnect();
    }

    public void SelectFrom(String table){

        try{
            String sql="select * from "+table;
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery(sql);

        if(table.equalsIgnoreCase("customer")){
            while(rs.next()){

                int id  = rs.getInt("id");
                String fname=rs.getString("fname");
                String lname=rs.getString("lname");
                String username=rs.getString("username");
                String password=rs.getString("password");
                String address=rs.getString("address");
                String phone=rs.getString("phone");
                String balance=rs.getString("balance");
                Boolean isactive=rs.getBoolean("isactive");

//                dict.clear();
//                dict.put("id",id);
//                dict.put("fname",fname);
//                dict.put("lname",lname);
//                dict.put("username",username);
//                dict.put("password",password);
//                dict.put("address",address);
//                dict.put("phone",phone);
//                dict.put("balance",balance);
//                dict.put("isactive",isactive);
//
//                result.add(dict);


                System.out.println("id: "+id+
                        ", firstname: "+ fname+
                        ", lastname: "+lname+
                        ", username: "+ username+
                        ", password: "+ password+
                        ", address: "+ address+
                        ", phone: "+ phone+
                        ", balance: "+ balance+
                        ", isactive: "+ isactive);

            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
        //DB_Connect.CloseConnect();
    }

    public String loginCheck(String usernm, String passwrd) {
        String result=null;
        try {
            String sql = "select id,username,balance from customer where username='" + usernm + "' and password='" + passwrd+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                result=rs.getString("username");
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
        //DB_Connect.CloseConnect();

    }

}
