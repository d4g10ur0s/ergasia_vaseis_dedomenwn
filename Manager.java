import com.sun.jdi.connect.spi.Connection;
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
  Company comp = new Company();
  public void menu(){
    Scanner scanner = new Scanner(System.in);

         System.out.println("\n==================================="
                       +    "\n            OPTIONS                "
                       +    "\n==================================="
                       +    "\n1)Change Company Details "
                       +    "\n2)Change Password/Email"
                       +    "\n3)Change Job Salary "
                       +    "\n4)View Evaluation Grades"
                       +    "\n5)Update Employee"
                       +    "\n6)View Employee Info"
                       +    "\n7)Exit the application\n");
         int choice = scanner.nextInt();
    switch(choice){
    case 1:
    this.changeCompanyDetails();

    case 2:
        this.change_password(conn)
    case 3:

    case 4:

    case 5:

    case 6:

    case 7:
    System.exit(0);

    }
    }

      public void changeCompanyDetails(Connection conn) throws SQLException {
       Scanner scanner1 = new Scanner(System.in);

         System.out.println("\n==================================="
                       +    "\n            OPTIONS                "
                       +    "\n==================================="
                       +    "\n1)Change Country "
                       +    "\n2)Change City"
                       +    "\n3)Change Street "
                       +    "\n4)Change Phone Number"
                       +    "\n5)Change Company Number"
                       +    "\n6)Back\n");
         int choice1 = scanner1.nextInt();
       switch(choice1){
      case 1:
      System.out.println("Insert new Country: ");
      Scanner inp1 = new Scanner(System.in);
      String lne1 = inp1.nextLine();
      comp.setCountry(lne1);

      case 2:
      System.out.println("Insert new City: ");
      Scanner inp2 = new Scanner(System.in);
      String lne2 = inp2.nextLine();
      comp.setCity(lne2);

      case 3:
      System.out.println("Insert new Street: ");
      Scanner inp3 = new Scanner(System.in);
      String lne3 = inp3.nextLine();
      comp.setStreet(lne3);

      case 4:
      System.out.println("Insert new City: ");
      Scanner inp4 = new Scanner(System.in);
      int lne4 = inp4.nextInt();
      comp.setPhoneNum(lne4);

      case 5:
      System.out.println("Insert new City: ");
      Scanner inp5 = new Scanner(System.in);
      int lne5 = inp5.nextInt();
      comp.setNum(lne5);

      case 6:
      this.menu();

      }}
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

      public void viewGrades(Connection conn) throws SQLException {
        Statement stmt = conn.createStatement();

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
