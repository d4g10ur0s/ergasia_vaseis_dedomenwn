import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;


public class Employee extends User{

  private String bio;
  private String recommendations;
  private String certificates;
  private String am;
  private int expYears;
  private String awards;

    public Employee(String username, String password,String name,String surname,String email, int expYears, String bio, String recommendations, String certificates, String am, String awards ){
     super(username, password, name, surname, email);
     this.expYears=expYears;
     this.bio=bio;
     this.recommendations=recommendations;
     this.certificates=certificates;
     this.am=am;
     this.awards=awards;

    }

    public void get_my_info(Connection conn) throws SQLException {

      System.out.println("1. Username : " + this.getUserName() +
      "\n2. Full Name : " + this.getName() + " " + this.getSurname() +
        "\n3. E-mail : " + this.getEmail() +"\n4. Bio : " + this.bio +
         "\n5. Years of Expirience : " + this.expYears + "\n6. Recommendations : " + this.recommendations
         +"\n7. Certificates : " + this.certificates + "\n8. A.M. : " + this.am + "\n9. Awards : " + this.awards);
      //User input
      Scanner inp = new Scanner(System.in);
      System.out.println("Give Numbers With Spaces");
      String lne = inp.nextLine();

      for(int i = 0; i<lne.length(); i++)
      {
        switch(lne.charAt(i)-'0'){
            case 1 : System.out.println("You cannot change your username . \n");
                     i+=1;
                     break;
            case 2 : System.out.println("You cannot change your Full Name . \n");
                     i+=1;
                     break;
            case 3 : System.out.println("You cannot change your email . \n");
                     i+=1;
                     break;
            case 4 : this.change_bio(conn);
                     i+=1;
                     break;
            case 5 : System.out.println("You cannot change your years of experience . \n");
                     i+=1;
                     break;
            case 6 : System.out.println("You cannot change your recommendations . \n");
                     i+=1;
                     break;
            case 7 : System.out.println("You cannot change your Certificates . \n");
                     i+=1;
                     break;
            case 8 : System.out.println("You cannot change your A.M. . \n");
                     i+=1;
                     break;
            case 9 : System.out.println("You cannot change your Awards . \n");
                     i+=1;
                     break;
            case 10 : change_password(conn);
                      break;
            default : i+=1;
                      break;
        }//end of switch

      }//end for
    }//end of get_my_info
    //allagh password
    public void change_password(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("New Password");
      String lne = inp.nextLine();
      ResultSet rs = stmt.executeQuery("UPDATE user SET user.password="+lne+" WHERE user.username=\'%"+ this.getUserName() +"%\'");
    }
    //allagh biografikou
    public void change_bio(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("New or Extend Bio (1/2)");
      int opt = inp.nextInt();
      if(opt == 1){
        this.bio = "";
        String lne;
        while(true){
          lne = inp.nextLine();
          if(lne.length()==0 || lne.length() == 1){break;}
          this.bio+=lne;
        }
        ResultSet rs = stmt.executeQuery("UPDATE employee SET employee.bio="+lne+" WHERE employee.employeeUsername=\'%"+ this.getUserName() +"%\'");
      }
      else if(opt==2){}

    }
    //vlepw aithseis
    public void des_aithseis(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      ResultSet rs = stmt.executeQuery("SELECT * from (select evres.username , evres.evaluationID,evres.jobID, evres.gradeSum from evalresult as evres where evres.username like '%"
                                        +this.getUserName()+
                                        "%') as t1 INNER JOIN (select * from job as job_1) as t2 ON t1.jobID=t2.id;");
      rs = stmt.getResultSet();

      //pairnw metadata
      ResultSetMetaData metadata = rs.getMetaData();
      int numberOfColumns = metadata.getColumnCount();
      while (rs.next())
      { //emfanizw ta stoixeia
        for (int i = 1; i <= numberOfColumns; i++)
        {
          System.out.printf("%-8s\t ||", rs.getObject(i));
        }
        System.out.println();
      }//endwhile

    }//end des aithseis

    public void apply_for_job(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      Scanner inp = new Scanner(System.in);
      ResultSet rs = stmt.executeQuery("SELECT t2.id from (select evres.username , evres.evaluationID,evres.jobID, evres.gradeSum from evalresult as evres where evres.username NOT LIKE '%"
                                        +this.getUserName()+
                                        "%') as t1 INNER JOIN (select * from job as job_1) as t2 ON t1.jobID=t2.id;");
      rs = stmt.getResultSet();

      //pairnw metadata
      ResultSetMetaData metadata = rs.getMetaData();
      int numberOfColumns = metadata.getColumnCount();
      ArrayList<String>job_ids = new ArrayList<String>();
      while (rs.next())
      { //pairnw id gia jobs pou mporei na kanei apply
        System.out.printf("%-8s\t  ||", rs.getObject(1));
        job_ids.add(rs.getObject(1).toString());
      }//endwhile
      System.out.println("Apply for job?(Y/N)");
      char yn = inp.next().charAt(0);
      if(yn == 'N' || yn == 'n'){

      }else{
        System.out.println("Job Id");
        int id = inp.nextInt();
        //prpei na valw se pinakes evalresult, requestsevaluation, firstPhase,secondPhase, thirdPhase.
      }

    }//end des aithseis
}
