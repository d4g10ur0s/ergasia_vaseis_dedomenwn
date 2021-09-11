public class Admin extends User{
    
    public boolean isAdmin=true;
    private int adminID;
    
    public Admin(String username, String password,String name,String surname,String email, int adminID){
     super(username, password, name, surname, email);   
     this.isAdmin=isAdmin;
     this.adminID=adminID;
    }
     
}
