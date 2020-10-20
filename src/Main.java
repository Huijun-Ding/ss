
import GestionDonnes.Client;
import static GestionDonnes.Client.connexion;
import static GestionDonnes.Client.inscription;
import java.util.Scanner;
import BD.DB;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB db = new DB("bd_dolt", "jdbc:mysql://localhost:3306/", "root", "");
        db.connexion();
        
        // TODO code application logic here
        Client c1=new Client("liuyue","2222");
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
            break;
        }
         
               while(true){  
               System.out.println("Choissez ce que vous voulez changer A(Password) B(Adresse) C（telephone）D(ville and Codepostale) E(rien change)");
               String option2 = scanner.next();
               if("a".equalsIgnoreCase(option2)){
               System.out.println("Entrerez le nouvel mot de passe");  
               String newcode = scanner.nextLine();
               c1.setPassword(newcode);}
               else if("b".equalsIgnoreCase(option2)){
               System.out.println("Entrerez votre nouvelle adresse ");  
               String newadresse = scanner.nextLine();
               c1.setRurClient(newadresse);}
               else if("c".equalsIgnoreCase(option2)){
               System.out.println("Entrerez votre nouvelle telephone ");  
               String newtele = scanner.nextLine();
               c1.setTelClient(newtele);}
               else if("d".equalsIgnoreCase(option2)){
               System.out.println("Entrerez votre nouvelle ville et codepostale ");  
               String newville = scanner.nextLine();
               c1.setVilleClient(newville);
               String newcp = scanner.nextLine();
               c1.setCodePostalC(newcp);
               }    
               }
               
         
    }
    
}