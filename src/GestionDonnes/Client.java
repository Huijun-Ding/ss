
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDonnes;
import BD.DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Mathi
 */
public class Client {
    protected int numClient; 
    protected String telClient; 
    protected  static String email;
    protected String rurClient;
    protected String villeClient;
    protected String codePostalC;
    protected String carteBancaire; 
    protected int noteC;
    protected String password;
    Client clientconnect;
    static ArrayList<Client> lstusers = new ArrayList<Client>();
    static Scanner scanner = new Scanner(System.in);
    
    
    public Client(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, int noteC,String password,String email) {
        this.numClient = numClient;
        this.telClient = telClient;
        this.rurClient = rurClient;
        this.villeClient = villeClient;
        this.codePostalC = codePostalC;
        this.carteBancaire = carteBancaire;
        this.noteC = noteC;
        this.password=password;
        this.email=email;
        ArrayList<Client> lstusers = new ArrayList<Client>();
    }
    public Client(){
        try { 
        DB db = new DB("bd_dolt", "jdbc:mysql://localhost:3306/", "root", "");
        db.connexion();
        Statement st = null;
        ResultSet srs = st.executeQuery("SELECT * FROM client");
        
        while (srs.next()) {
                Client newclient = new Client();
                
                newclient.(srs.getString("name"));
                newclient.setJobtitle(srs.getString("jobtitle"));
                newclient.setFrequentflyer(srs.getInt("frequentflyer"));
                lstusers.add(newclient);
            }
        }catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
    
    public Client(String email,String password){
     this.password=password;
     this.email=email;
     ArrayList<Client> lstusers = new ArrayList<Client>();
    }

    @Override
    public boolean equals(Object obj) {
     Client client =(Client) obj;
     return this.email==client.email;
    }

    @Override
    public String toString() {
        return "account:" + email + "password=" + password + '}';
    }
    
     public static void inscription(){
       
         Client clientconnect = null;
          while(true){
          System.out.println("Saisez votre nom d'utilisateur");
          String email = scanner.nextLine();
          clientconnect = new Client(email,null);
          if(lstusers.contains(clientconnect)){
           System.out.println("Le compte existe déjà");
          }else{
                break;
            }
        }
        System.out.println("Entrerez le mot de passe");
        String password = scanner.next();
        clientconnect.setPassword(password);
        lstusers.add(clientconnect);
        
        System.out.println("Inscription réussie");
        System.out.println("Veuillez saisir les informations suivantes");
        
        System.out.println("Numéro de téléphone");
        String tel = scanner.nextLine();
       clientconnect.setTelClient(tel);
        
        System.out.println("Carte bancaire");
        String cb  = scanner.nextLine();
       clientconnect.setCarteBancaire(cb);
        
        System.out.println("Adresse");
        String rue  = scanner.nextLine();
        clientconnect.setRurClient(rue);
        
        System.out.println("Ville");
        String ville  = scanner.nextLine();
        clientconnect.setVilleClient(ville);
        
        System.out.println("Code postale");
        String cp  = scanner.nextLine();
        clientconnect.setVilleClient(cp);
        
        clientconnect.setNumClient(lstusers.indexOf(clientconnect)); 
        
        System.out.println("Liste des personnes inscrites" + lstusers);  
    }
    

        public static void connexion(){
        System.out.println("Saisez votre nom d'utilisateur"); 
        String email = scanner.nextLine();
        System.out.println("Entrerez le mot de passe");
        String password = scanner.next();
        boolean Login = false;
        Iterator it = lstusers.iterator();
        while(it.hasNext()){
            Client user = (Client) it.next();
            if(user.email == email && user.password.equals(password)){
                Login = true;
                System.out.println("Connexion réussie！");
                System.out.println( "numero:"+user.telClient+"ville"+user.villeClient+"adresse"+user.rurClient+"password"+user.password+"notation"+user.noteC);
            }else{
                System.out.println("Échec de la connexion!");
            }
        }   
        }
            
       public String consulter(Client client){
           int i; 
           i=lstusers.indexOf(client);
          return "numero:"+lstusers.get(i).getNumClient()+"telephone"+lstusers.get(i).getTelClient()+"email:"+lstusers.get(i).getEmail()
         +"codepostale:"+lstusers.get(i).getCodePostalC()+"ville:"+lstusers.get(i).getVilleClient()+"cartebancaire:"+lstusers.get(i).getCarteBancaire()
         +"rueclient:"+lstusers.get(i).getRurClient();}        

    public misajour(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, int noteC, String password, Client clientconnect) {
        this.numClient = numClient;
        this.telClient = telClient;
        this.rurClient = rurClient;
        this.villeClient = villeClient;
        this.codePostalC = codePostalC;
        this.carteBancaire = carteBancaire;
        this.noteC = noteC;
        this.password = password;
        this.clientconnect = clientconnect;
    }
         

    public int getNumClient() {
        return numClient;
    }

    public String getTelClient() {
        return telClient;
    }

    public String getRurClient() {
        return rurClient;
    }

    public String getVilleClient() {
        return villeClient;
    }

    public String getCodePostalC() {
        return codePostalC;
    }

    public String getCarteBancaire() {
        return carteBancaire;
    }

    public String getNoteC() {
        return noteC;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Client> getLstusers() {
        return lstusers;
    }

    public void setNumClient(int numClient) {
        this.numClient = numClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public void setRurClient(String rurClient) {
        this.rurClient = rurClient;
    }

    public void setVilleClient(String villeClient) {
        this.villeClient = villeClient;
    }

    public void setCodePostalC(String codePostalC) {
        this.codePostalC = codePostalC;
    }

    public void setCarteBancaire(String carteBancaire) {
        this.carteBancaire = carteBancaire;
    }

    public void setNoteC(String noteC) {
        this.noteC = noteC;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLstusers(ArrayList<Client> lstusers) {
        this.lstusers = lstusers;
    }
    
}
