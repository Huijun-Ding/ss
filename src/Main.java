
import BD.DB;




public class Main {

    public static void main(String[] args) {

        DB db = new DB("bd_dolt", "jdbc:mysql://localhost:3306/", "root", "");
        db.connexion();
        // TODO code application logic here

    }
    
        
}
    
    


