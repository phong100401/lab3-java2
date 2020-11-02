package Java.sql;

import java.sql.*;

public class CheckCustomer {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwin","root","");
                Statement stmt = conn.createStatement();
        ){
            String strSelect = "select CompanyName from customers";
            System.out.println("companyName: " + strSelect);

            ResultSet rset = stmt.executeQuery(strSelect);
            int rowCount = 0;
            while (rset.next()){
                String CompanyName = rset.getString("CompanyName");
                System.out.println(CompanyName);
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
