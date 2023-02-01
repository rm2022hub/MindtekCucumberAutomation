package Utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class DBTest {

    public static void main(String[] args) throws SQLException {
        DB db = new DB();

      //  String query ="insert into countries values ('NK', 'North Korea', 3)";
      //  db.runInsertQuery(query);

       // String query = "delete from countries where country_id = 'BR'";
       // db.runDeleteQuery(query);


       // String query = "Update employees Set email='test@gmail.com' where employee_id = 100";
      //  db.runUpdateQuery(query);


       // String query = "select * from dependents";
       ResultSet rs = db.runSelectQuery("*","jobs");
       while(rs.next()) System.out.println(rs.getString("job_id") + " " + rs.getString("job_title"));


       // List<Map<String,Object>> list = db.getTableForQuery(q);
       // System.out.println(list);
      db.close();

    }

}
