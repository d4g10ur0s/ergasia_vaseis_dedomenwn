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
    
}
