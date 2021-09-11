public class FirstPhase extends Evaluation{
    
  private String comments;
  private int grade1;

    public FirstPhase(String employeeUsername, int evaluationID, String evaluatorUsername,String comments, int grade1){
     super(employeeUsername, evaluationID, evaluatorUsername);   
     this.comments=comments; 
     this.grade1=grade1;
     
    }
}
