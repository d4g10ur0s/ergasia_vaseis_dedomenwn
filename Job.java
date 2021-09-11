import java.util.Date;

public class Job{
    
  private String position;
  private String edra;
  private int id;
  private int salary;
  //Evaluator ev1 = new Evaluator();
  Date announceDate = new Date();
  Date submissionDate = new Date();
  Date startDate= new Date();
    
    public Job(String position, int id, int salary, String edra, Date announceDate, Date submissionDate, Date startDate){
     this.position=position; 
     this.id=id;
     this.salary=salary;
     this.edra=edra;
     this.announceDate=announceDate;
     this.submissionDate=submissionDate;
     this.startDate=startDate;
    }
 public int getJobID(){return id;}
 public void setJobID(int id) {this.id=id;}
} 
    