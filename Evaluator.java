import java.util.ArrayList;
import java.util.Scanner;
import java.sql.*;

public class Evaluator extends User{
  ArrayList<Evaluation>evaluationsList = new ArrayList<Evaluation>();
  ArrayList<Job>jobsList = new ArrayList<Job>();

  private String firm;
  private int expYears;
  private int evaluatorID;

    public Evaluator(String username, String password,String name,String surname,String email, String firm, int expYears, int evaluatorID){
     super(username, password, name, surname, email);
     this.expYears=expYears;
     this.firm=firm;
     this.evaluatorID=evaluatorID;

    }

    public void get_my_info(){

      System.out.println("1. Username : " + this.getUserName() +
       "\n2. Full Name : " + this.getName() + " " + this.getSurname() +
        "\n3. E-mail : " + this.getEmail() +"\n4. Evaluator ID : " + this.evaluatorID +
         "\n5. Years of Expirience : " + this.expYears + "\n6. Firm : " + this.firm);
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
            case 2 : this.change_fullname();
                     i+=1;
                     break;
            case 3 : this.change_email();
                     i+=1;
                     break;
            case 4 : this.change_id();
                     i+=1;
                     break;
            case 5 : this.change_years();
                     i+=1;
                     break;
            case 6 : change_firm();
                     i+=1;
                     break;
            default : i+=1;
                      break;
        }

      }//end for
    }//end of get_my_info

    void change_fullname(){
      Scanner inp = new Scanner(System.in);
      System.out.println("New Name");
      String lne = inp.nextLine();
      this.setName(lne);
      System.out.println("New Surname");
      lne = inp.nextLine();
      this.setSurname(lne);
    }

    void change_email(){
      Scanner inp = new Scanner(System.in);
      System.out.println("New email");
      String lne = inp.nextLine();
      this.setEmail(lne);
    }

    void change_id(){
      Scanner inp = new Scanner(System.in);
      System.out.println("New ID");
      int nid = inp.nextInt();
      this.evaluatorID = nid;
    }

    void change_years(){
      Scanner inp = new Scanner(System.in);
      System.out.println("New Years of Experience");
      int nid = inp.nextInt();
      this.expYears = nid;
    }

    void change_firm(){
      Scanner inp = new Scanner(System.in);
      System.out.println("New Firm");
      String lne = inp.nextLine();
      this.firm = firm;
    }

    void Get_job_in_company(){

    }
    //vlepei tis douleies ths etairias kai allazei mono tis dikes tou
    void jobs_in_company(Connection conn) throws SQLException {
      Statement stmt = conn.createStatement();
      //pairnw oles tis douleies ths etairias
      ResultSet rs = stmt.executeQuery("select * from (select evalu.evaluatorUsername , evalu.firm, jo.id from evaluator as evalu INNER JOIN (select * from job) as jo ON jo.evaluator=evalu.evaluatorUsername) as t1 where t1.firm like"
                                        +"%"+this.firm+"%");
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
    }
    //peirazei mono tis dikes tou
    void edit_job(Connection conn) throws SQLException
    {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from job where job.evaluator like" +"'%"+this.getUserName()+"%'");
      rs = stmt.getResultSet();
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
      //Ti 8elei na edit
      Scanner inp = new Scanner(System.in);
      System.out.println("Would you like to edit a job?\n(Y/N)");
      char yn = inp.next().charAt(0);
      if(yn == 'N' || yn == 'n')
      {

      }
      else
      {
        //to update kalutera na ginetai mesw id
        System.out.println("Give ID");
        rs = stmt.executeQuery("select * from job where job.evaluator like" +"'%"+this.getUserName()+"%' AND job.id="+inp.nextInt() );
        rs = stmt.getResultSet();
        metadata = rs.getMetaData();
        if(rs.next()){
          //edw 8a prepei na ginei diasundesh me GUI
          //ta katallhla koumpia
          //vazeis to info kai meta to kaneis push
          //id(1) kai announce_date(6) menoun idia
          //salary
          System.out.println("Give salary");
          int sal = inp.nextInt();
          //position
          System.out.println("Give position");
          String pos = inp.nextLine();
          //edra
          System.out.println("Give edra");
          String edr = inp.nextLine();
          //submission_date
          System.out.println("Give submission date");
          String subdate = inp.nextLine();
          //start date
          System.out.println("Give start date");
          String strt_dat = inp.nextLine();
          //antikeimeno
          System.out.println("Give Subject");
          String sub = inp.nextLine();
          System.out.println("Give ID");
          rs = stmt.executeQuery("UPDATE job job.salary="+sal+", job.position=\'"+pos+"\', job.edra=\'"+edr+"\', job.submission_date=\'"+subdate+"\', job.start_date=\'"+strt_dat+"\', job.antikeimeno=\'"+sub+"\' "+
                                  "where job.evaluator like" +"\'%"+this.getUserName()+"%\' AND job.id="+inp.nextInt() );
        }
        else{System.out.println("There is no job you can edit with this job id.");}
      }
    }
    //o evaluator vazei nea jobs
    void new_Job(Connection conn) throws SQLException {
      int id,salary;
      String position,edra ,announce_date, submission_date,start_date;
      // ta statements mou
      Statement stmt = conn.createStatement();
      //pairnw input
      Scanner inp = new Scanner(System.in);
      System.out.println("Give id for job.");
      id = inp.nextInt();
      System.out.println("Give salary for job.");
      salary = inp.nextInt();
      System.out.println("Give position for job.");
      position = inp.nextLine();
      System.out.println("Give edra for job.");
      edra = inp.nextLine();
      //prepei na to ftiakseis kalutera
      System.out.println("Give announce date for job.");
      announce_date = inp.nextLine();
      System.out.println("Give submission date for job.");
      submission_date = inp.nextLine();
      System.out.println("Give start date for job.");
      start_date = inp.nextLine();

      //dhmiourgeia antikeimenou an auto den yparxei
      System.out.println("Name Subject of job.");
      String ant_title = inp.nextLine();
      ResultSet rs = stmt.executeQuery("SELECT antikeim.title from antikeim where antikeim.title like \'%" + ant_title + "%\'");

      if(rs.next())
      {
        //den vazw kapoio antikeimeno
        //to antikeimeno yparxei
      }else
      {
        System.out.println("Description of Subject of job.");
        String ant_descr = inp.nextLine();
        System.out.println("Is Subject of job related to a Subject?");
        String belongs_to = inp.nextLine();
        if(belongs_to.length() == 0){/*den exei sxesh me alla antikeimena*/}
        else{
          rs = stmt.executeQuery("INSERT INTO antikeim values (\'" + ant_title + "\',\'"+ant_descr+"\',\'"+belongs_to+"\')");
        }
      }
      //vazw neo job
      rs = stmt.executeQuery("INSERT INTO job values("+id+" ,"+ salary +", \'"+ position
                            +"\' , \'"+ edra+"\' , NOW() , \'"+
                            submission_date+"\' , \'" + start_date + "\', \'"+ ant_title +"\')" );
    }
    //vlepei ti exei oloklhrw8ei
    void endiamesa_telika_apotelesmata(Connection con) throws SQLException {
      Statement stmt = con.createStatement();
      Scanner inp = new Scanner(System.in);
      System.out.println("Job Position");
      String lne = inp.nextLine();
      ResultSet rs = stmt.executeQuery("CALL va8mos_aksiologhshs(\'"+ lne +"\')");
      rs = stmt.getResultSet();

      ResultSetMetaData metadata = rs.getMetaData();
      int numberOfColumns = metadata.getColumnCount();
      //poses ekkremoun
      int ek = Integer.parseInt( rs.getObject(2).toString() );
      if(ek == 0)
      {
        System.out.println("Den yparxoun ekkremeis aksiologhseis.");
        rs = stmt.executeQuery("select telikoi_va8moi.gradeSum , telikoi_va8moi.username, telikoi_va8moi.jobID, t1.position from evalresult as telikoi_va8moi INNER JOIN( SELECT job_1.id , job_1.position from job AS job_1 where job_1.position LIKE \'%"
                                          +lne+"%\') t1 ON t1.id=telikoi_va8moi.jobID ORDER BY (telikoi_va8moi.gradeSum) DESC");
      }else{
        //pairnw oti exei oloklhrw8ei
        rs = stmt.executeQuery("select telikoi_va8moi.gradeSum , telikoi_va8moi.username, telikoi_va8moi.jobID, t1.position from evalresult as telikoi_va8moi INNER JOIN( SELECT job_1.id , job_1.position from job AS job_1 where job_1.position LIKE"
                                +" \'%"+lne+"%\') t1 ON t1.id=telikoi_va8moi.jobID WHERE telikoi_va8moi.gradeSum IS NOT NULL;");
        metadata = rs.getMetaData();
        numberOfColumns = metadata.getColumnCount();
        while (rs.next())
        { //emfanizw ta stoixeia
          for (int i = 1; i <= numberOfColumns; i++)
          {
          System.out.printf("%-8s\t ||", rs.getObject(i));
          }
          System.out.println();
        }//endwhile

        //pairnw oti den exei oloklhrw8ei
        System.out.println("Ekkremoun "+ek+" aksiologhseis");
        rs = stmt.executeQuery("select telikoi_va8moi.gradeSum , telikoi_va8moi.username, telikoi_va8moi.jobID, t1.position from evalresult as telikoi_va8moi INNER JOIN( SELECT job_1.id , job_1.position from job AS job_1 where job_1.position LIKE"
                                +"\'%"+lne+"%\') t1 ON t1.id=telikoi_va8moi.jobID WHERE telikoi_va8moi.gradeSum IS NULL;");
        metadata = rs.getMetaData();
        numberOfColumns = metadata.getColumnCount();
        while (rs.next())
        { //emfanizw ta stoixeia
          for (int i = 1; i <= numberOfColumns; i++)
          {
            System.out.printf("%-8s\t ||", rs.getObject(i));
          }
          System.out.println();
        }//endwhile
      }//endelse

      //end of function
    }
}
