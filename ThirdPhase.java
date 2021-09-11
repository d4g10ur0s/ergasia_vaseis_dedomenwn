public class ThirdPhase extends Evaluation{
    
  private String honors;
  private String degree;
  private String recommendation;
  private int grade3;
  private int projectNum;
  private int evaluationID;

    public ThirdPhase(String employeeUsername, int evaluationID, String evaluatorUsername,String honors, int grade3, String degree, String recommendation, int projectNum){
     super(employeeUsername, evaluationID, evaluatorUsername);  
     this.honors=honors;
     this.degree=degree;
     this.recommendation=recommendation;
     this.evaluationID=evaluationID;
     this.grade3=grade3;
     this.projectNum=projectNum;
     
    }
}
