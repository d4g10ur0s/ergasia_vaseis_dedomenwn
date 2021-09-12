import java.sql.*;

public class Main{
    public static void main (String[] args) throws SQLException {

      Connection conn = null;
      Statement stmt = null;
      ResultSet rs = null;

      try {
        conn = DriverManager.getConnection(
        "jdbc:mysql://localhost/vaseis_dedomenwn_sept","root","Den8aKsexasw");

        // ta statements mou
        stmt = conn.createStatement();
        //endeiktiko query
        rs = stmt.executeQuery("SELECT * from (select evres.username , evres.evaluationID,evres.jobID, evres.gradeSum from evalresult as evres where evres.username NOT LIKE '%"
                                          +"Annou"+
                                          "%') as t1 INNER JOIN (select * from job as job_1) as t2 ON t1.jobID=t2.id;");

        if (stmt.execute("SELECT t2.id from (select evres.username , evres.evaluationID,evres.jobID, evres.gradeSum from evalresult as evres where evres.username NOT LIKE '%"
                                          +"Annou"+
                                          "%') as t1 INNER JOIN (select * from job as job_1) as t2 ON t1.jobID=t2.id;"))
        {

        rs = stmt.getResultSet();
        ResultSetMetaData metadata = rs.getMetaData();
        int numberOfColumns = metadata.getColumnCount();
        for (int i = 1; i <= numberOfColumns; i++)
        {
        System.out.printf("%-8s\t", metadata.getColumnName(i));
        System.out.println();
        }
        while (rs.next())
        {
          for (int i = 1; i <= numberOfColumns; i++)
          {
          System.out.printf("%-8s\t  ||", rs.getObject(i));
          System.out.printf("%-8s\t  ||", rs.getObject(i));
          }
          System.out.println();
        }

        }
    // Do something with the Connection

      }
      catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
      }
      /*
      catch ( ClassNotFoundException ex){
         System.out.println("SQLException: " + ex.getMessage());
      }
     */
    }

}
