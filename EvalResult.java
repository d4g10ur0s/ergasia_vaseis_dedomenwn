public class EvalResult{
    
  private String evaluatorUsername;
  private String employeeUsername;
  private int evaluationID;
  
  private int jobID;
  private String comments;
  private int grade1;
  private int grade2;
  private int grade3;
  private int gradeSum;
    public EvalResult(String employeeUsername, int evaluationID, String evaluatorUsername, int jobID, int grade1, int grade2, int grade3, int gradeSum, String comments){
     this.employeeUsername=employeeUsername; 
     this.evaluationID=evaluationID;
     this.evaluatorUsername=evaluatorUsername;
     this.jobID=jobID;
     this.grade1=grade1;
     this.grade2=grade2;
     this.grade3=grade3;
     this.gradeSum=gradeSum;
     this.comments=comments;
     
    }

}

