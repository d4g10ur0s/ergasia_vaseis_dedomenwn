import java.util.ArrayList;
public class Company {
    
    ArrayList<User>usersList = new ArrayList<User>();
    private String name;
    private String AFM;
    private String DOY;
    private String country;
    private String city;
    private String street;
    private int phoneNumber;
    private int num;
    
    
     
    public Company(String name, String AFM, String DOY, String country, String city, String street, int phoneNumber, int num){
    this.name=name;
    this.AFM=AFM;
    this.DOY=DOY;
    this.country=country;
    this.city=city;
    this.street=street;
    this.phoneNumber=phoneNumber;
    this.num=num;

}
    public String getComp(){return name;}
 
}