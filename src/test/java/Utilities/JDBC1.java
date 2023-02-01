package Utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBC1 {

    public static void main(String[] args) throws SQLException {

        // create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );
        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        // read data
        ResultSet rs = stt.executeQuery("Select * from jobs");
        rs.next();
        System.out.println(rs.getString("job_title"));

        printCountries(stt);
       printDepartmentsByCountries(stt);
          updateAllEmails(stt);

    }
   /*
   --"bruce.ernst@sqltutorial.org" -> bruce.ernst@mindtek.edu
-- write a query  get all the emails in a result set
-- iterate through rs and add all emails to ArryList
-- iterate through array list and change emails from @tutorial.org to @mindtek.edu
-- print our list
    */
    private static void updateAllEmails(Statement stt) throws SQLException {
      //write a query  get all the emails in a result set
      String emailQuery = "select email from employees";
     ResultSet rs = stt.executeQuery(emailQuery);

     //iterate through rs and add all emails to ArrayList
     ArrayList<String> emailList = new ArrayList<>();
     while (rs.next()) {
         emailList.add(rs.getString("email"));

     }
     //iterate through array list and change emails from @tutorial.org to @mindtek.edu
        System.out.println(emailList);
     ArrayList<String> newEmailsList = new ArrayList<>();
     for(String email : emailList){
       email = email.substring(0, email.indexOf('@')) + "mindtek.edu";
       newEmailsList.add(email);
     }
     // putting into DB
      String updateQuery = "update employees set email = emailListNew where employees.email = emailList";
      int i =0;
      for (String em : emailList){
          updateQuery = "update employees set email = '" + newEmailsList.get(i) + " 'where employees. email = '" + emailList.get(i) + "'";
          System.out.println(updateQuery);
          i++;
      }
      // print your list
        System.out.println(newEmailsList);
    }

    private static void printDepartmentsByCountries(Statement stt) throws SQLException {
    ResultSet rs= stt.executeQuery("select locations.country_id, count(departments.department_id )\n" +
            "from locations, departments\n" +
            "where  departments.location_id = locations.location_id\n" +
            "group by locations.country_id;");
    while (rs.next()){
        System.out.println(rs.getString("country_id") + "-> " + rs.getString("count"));

    }

    }

    private static void printCountries(Statement stt) throws SQLException {
       ResultSet rs  = stt.executeQuery("select * from countries");  // has 40 countries
      int count = 1;
      while(rs.next()){
           System.out.println(count + " -> "  + rs.getString("country_name"));
           count++;
        }

    }

}
