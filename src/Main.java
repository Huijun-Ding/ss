
import BD.DB;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DB db = new DB("bd_dolt", "jdbc:mysql://localhost:3306/", "root", "");
               db.connexion();

    }
    
}

