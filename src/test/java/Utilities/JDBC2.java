package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC2 {
    public static void main(String[] args) throws SQLException {

        // create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"  // FATAL: password authentication failed for user "postgres" (exception) - if password or something is wrong in connection.
        );
        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String query = "select * from employees";
        ResultSet rs = stt.executeQuery(query);
       // rs.next();
        // System.out.println(rs.getString("first_name"));
        ResultSetMetaData rsMeta = rs.getMetaData();
        System.out.println( "Column count " + rsMeta.getColumnCount());
        System.out.println("column #1: " + rsMeta.getColumnName(10)); // The column index is out of range: 11, number of columns: 10.(exception)
        System.out.println("Table name: " + rsMeta.getTableName(4));
        System.out.println("Is Nullable: " + rsMeta.isNullable(5));// if that column is nullable true = 1, false = 0
        System.out.println("Is Nullable: " + rsMeta.isNullable(1)); // primary key not nullable so it gives 0

        for (int i = 1; i<= rsMeta.getColumnCount();i++){
            System.out.println("Column # " + i + ": " +rsMeta.getColumnName(i)); // i for column number.

        }
       // recap of maps
        Map<Integer,String> map = new HashMap<>(); // map
        System.out.println(map);
        map.put(5, "Chicago");
        map.put(6, "Park Ridge");
        map.put(7,"Lincoln Park");
       // map.put(5, "Des Plaines");  // keys are unique so Des planes overrides Chicago because we used 5 2 times

        Map<Integer,String> map1 = new HashMap<>();  // map
        map1.put(5, "Mount Prospect");
        map1.put(6, "Shamburg");
        map1.put(7,"Mundelein");

        Map<Integer,String> map2 = new HashMap<>(); // map
        map2.put(5, "Libertville");
        map2.put(6, "Evanston");
        map2.put(7,"Skokie");

       List<Map<Integer,String>> list = new ArrayList<>();  // list of maps
       list.add(map);
       list.add(map1);
       list.add(map2);
        System.out.println(list);

      for (int i= 0; i<list.size();i++){
          System.out.println("Map # " +( i +1));
          for(int j= 5; j<8; j++){
              System.out.println(list.get(i).get(j));
          }
          System.out.println("------------------------");
      }


    }
}