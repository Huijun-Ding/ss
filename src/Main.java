
import static GestionDonnes.Client.connexion;
import static GestionDonnes.Client.inscription;
import java.util.Scanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        // TODO code application logic here
        
       Scanner scanner = new Scanner(System.in);
         while(true){
             
            System.out.println("Veuillez sélectionner la fonction A (inscription) B (connexion)");
            String option = scanner.next();
            if("a".equalsIgnoreCase(option)){
                inscription();
            }else if("b".equalsIgnoreCase(option)){
                connexion();
            }else{
                System.out.println("L'entrée est incorrecte, veuillez saisir à nouveau");
            }
        }
    }
    
}