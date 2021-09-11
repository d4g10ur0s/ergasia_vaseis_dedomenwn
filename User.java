import java.util.Date;

public abstract class User{

    private String userName;
    private String password;
    private String name;
    private String surname;
    private String email;
    Date registrationDate = new Date();
     public User(String username, String password,String name,String surname,String email){
     this.userName=username;
     this.password=password;
     this.name=name;
     this.surname=surname;
     this.email=email;

    }
    //Setter
    public void setUsername(String name){this.userName=name;}
    public void setName(String name){this.name=name;}
    public void setSurname(String name){this.surname=name;}
    public void setEmail(String name){this.email=name;}
    //public void setNumber(String number){this.phoneNumber=number;}
    //Getter
    public String getUserName(){return this.userName;}
    public String getName(){return this.name;}
    public String getSurname(){return this.surname;}
    public String getEmail(){return this.email;}

    //public String getPhoneNumber(){return phoneNumber;}


}
