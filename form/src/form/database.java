package form;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class database {
    ResultSet set;
    Statement st;
    Connection con;
    PreparedStatement smt;
    database() {
        try {

             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
            if (con.isClosed()) {
                System.out.println("connection failed");
            } else {
                System.out.println("connected");
            }
        } catch (Exception e) {
        }
    }
    public void details(){

        try{
             smt=con.prepareStatement("insert into userdata (name,age,mail,password) values (?,?,?,?)") ;
                    }catch (Exception e){
        }
    }

    public void fetchdata(){

        try{
            String q="select *from userdata";
           st=con.createStatement();
             set= st.executeQuery(q);
        }catch (Exception e){
        }
    }
}
