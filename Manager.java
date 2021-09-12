import java.util.Scanner;
import java.util.ArrayList;
import java.sql.*;

public class Manager extends User{

  private String firm;
  private int expYears;

    public Manager(String username, String password,String name,String surname,String email, int expYears, String firm){
     super(username, password, name, surname, email);
     this.expYears=expYears;
     this.firm=firm;

    }
    //allagh company
    public void change_company_info (Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      //pairnw etairia
      ResultSet rs = stmt.executeQuery("SELECT manager.firm from manager where manager.managerUsername LIKE \'%"+ this.getUserName() +"%\'");
      rs = stmt.getResultSet();
      String f_name = rs.getObject(1).toString();
      rs = stmt.executeQuery("SELECT * from company where company.name LIKE \'%"+ f_name +"%\'");

    }


      //allagh password
      public void change_password(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        Scanner inp = new Scanner(System.in);
        System.out.println("New Password");
        String lne = inp.nextLine();
        ResultSet rs = stmt.executeQuery("UPDATE user SET user.password="+lne+" WHERE user.username=\'%"+ this.getUserName() +"%\'");
      }
      //allagh email
      public void change_email(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();
        Scanner inp = new Scanner(System.in);
        System.out.println("New Email");
        String lne = inp.nextLine();
        ResultSet rs = stmt.executeQuery("UPDATE user SET user.email="+lne+" WHERE user.username=\'%"+ this.getUserName() +"%\'");
      }

      public void viewGrades(Connection con) throws SQLException {

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select gradeSum from manager right join company on manager.firm=company.afm right join employee on company.afm=employee.firm right join evalResult on employee.employeeUsername=evalResult.empl_username" );
        rs = stmt.getResultSet();
        //metadata
        ResultSetMetaData metadata = rs.getMetaData();
        int numberOfColumns = metadata.getColumnCount();
        while (rs.next())
        {
          for (int i = 1; i <= numberOfColumns; i++)
          {
            System.out.printf("%-8s\t ||", rs.getObject(i));
          }
          System.out.println();
        }//endwhile
      }

    }
