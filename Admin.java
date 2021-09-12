import java.sql.*;
import java.util.Scanner;

public class Admin extends User{

    public boolean isAdmin=true;
    private int adminID;

    public Admin(String username, String password,String name,String surname,String email, int adminID){
     super(username, password, name, surname, email);
     this.isAdmin=isAdmin;
     this.adminID=adminID;
    }

    public void create_user(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("Username ");
      String username = inp.nextLine();
      System.out.println("Passsword ");
      String password = inp.nextLine();
      System.out.println("Name ");
      String name = inp.nextLine();
      System.out.println("Surname ");
      String surname = inp.nextLine();
      System.out.println("Email ");
      String email = inp.nextLine();

      ResultSet rs = stmt.executeQuery("INSERT INTO user VALUES (\'"+username+"\',\'"+password+"\',\'"+name+"\',\'"+surname+"\',NOW(),\'"+email+"\')");
    }
    //dhmiourgia manager
    public void create_manager(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("Username ");
      String username = inp.nextLine();
      System.out.println("Years of experience ");
      int exp = inp.nextInt();
      System.out.println("Firm ");
      String firm = inp.nextLine();

      ResultSet rs = stmt.executeQuery("INSERT INTO manager VALUES (\'"+username+"\',"+exp+",\'"+firm+"\')");
    }
    //dhmiourgia employee
    public void create_employee(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("Username ");
      String username = inp.nextLine();
      System.out.println("Bio ");
      String bio = inp.nextLine();
      System.out.println("Sistatikes ");
      String sistatikes = inp.nextLine();
      System.out.println("Certificates ");
      String cert = inp.nextLine();
      System.out.println("A.M. ");
      String am = inp.nextLine();
      System.out.println("Years of experience ");
      int exp = inp.nextInt();
      System.out.println("Awards ");
      String awa = inp.nextLine();
      System.out.println("Firm ");
      String frm = inp.nextLine();

      ResultSet rs = stmt.executeQuery("INSERT INTO employee VALUES (\'"+username+"\',\'"+bio+"\',\'"+sistatikes+"\',\'"+cert+"\',\'"+am+"\',"+exp+",\'"+awa+"\',\'"+frm+"\')");
    }
    //create evaluator
    public void create_evaluator(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("Evaluator id ");
      int id = inp.nextInt();
      System.out.println("Username ");
      String username = inp.nextLine();
      System.out.println("Years of experience ");
      int exp = inp.nextInt();
      System.out.println("Firm ");
      String firm = inp.nextLine();

      ResultSet rs = stmt.executeQuery("INSERT INTO manager VALUES ("+id+",\'"+username+"\',"+exp+",\'"+firm+"\')");
    }
}
