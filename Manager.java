public class Manager extends User{
    
  private String firm;
  private int expYears;
    
    public Manager(String username, String password,String name,String surname,String email, int expYears, String firm){
     super(username, password, name, surname, email);   
     this.expYears=expYears;
     this.firm=firm;
     
    }
     
}

