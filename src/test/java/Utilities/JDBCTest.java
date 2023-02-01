package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
        // first we got JDBC library from mvn repository to our pom.xml file. and created a  java class in utilities.
        // create connection, create statement
        Connection cnn = DriverManager.getConnection(
           "jdbc:postgresql://localhost/HR_Production",
           "postgres",
           "admin"
        );
        //  creating statement
        Statement stt =cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        stt.execute("select * from jobs");
        // read data
        ResultSet rs =stt.executeQuery("select * from jobs");
        rs.next(); //initially the cursor is positioned before the first row. points to the next row (to move pointer to lower row)
        rs.next();
        System.out.println(rs.getString("job_title"));

        // printing all the result set
        while(rs.next()) System.out.println(rs.getString("job_title"));
        while(rs.next()){
            System.out.println(rs.getString("job_title"));
            System.out.println(rs.getString("min_salary"));
            System.out.println(rs.getString("max_salary"));
        }
        ResultSet rs1 =stt.executeQuery("select concat(e.first_name,' ',e.last_name) as P_fullName, " +
                "concat(d.first_name,' ',d.last_name) as d_fullName\n" +
                "from employees e, dependents d\n" +
                "where e.employee_id = d.employee_id");

        while(rs1.next()) System.out.println(rs1.getString("p_fullName")+ " is a parent of " + rs1.getString("d_fullName"));


     /* 1.query to get all the emails and put them into rs
       2.put those to arraylist
       3. find out if there are any emails not ending with @sqltutorial.org
       4. if there is such email then print "Found different email"
       5. if all emails end with @sqltutorial.org then print "
      */
     findDifferentEmail(cnn,stt);
        System.out.println("------");
        }

    private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {
      ResultSet rs  = stt.executeQuery("select email from employees");  // has 40 emails

        ArrayList<String> emailList = new ArrayList<>();
        while(rs.next()) emailList.add(rs.getString("email"));

        boolean isWrongEmail = false;
       for(String em: emailList) {
           if (!em.endsWith("@sqltutorial.org")) {
               System.out.println("Wrong email:" + em);
               isWrongEmail = true;

           }
       }
        if(isWrongEmail) System.out.println("Found different email");
        else System.out.println("All emails are the same");

    }

}



