public class Certificate{
    
   private String titlos;
   private String idryma;
   private enum vathmida {LYKEIO, BACHELOR, MASTER, PHD};
   
   public Certificate(String titlos, String idryma, vathmida v){
       
       this.titlos=titlos;
       this.idryma=idryma;
       //this.vathmida=v;
       
   }
    
}