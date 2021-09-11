public class SecondPhase extends Evaluation{
    
  private String comments;
  private String managerUsername;
  private String report;
  private int grade2;
 

    public SecondPhase(String employeeUsername, int evaluationID, String evaluatorUsername,String comments, int grade2, String managerUsername, String report){
     super(employeeUsername, evaluationID, evaluatorUsername);   
     this.comments=comments; 
     this.grade2=grade2;
     this.managerUsername=managerUsername;
     this.report=report;
     
    }
}