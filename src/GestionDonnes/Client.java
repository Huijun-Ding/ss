
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionDonnes;
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
    protected String noteC;
    protected String password;
    static ArrayList<Client> lstusers = new ArrayList<Client>();
    static Scanner scanner = new Scanner(System.in);
   
    public Client(int numClient, String telClient, String rurClient, String villeClient, String codePostalC, String carteBancaire, String noteC,String password,String email) {
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
       Client user = null;
        while(true){
            System.out.println("Saisez votre nom d'utilisateur");
            String email = scanner.nextLine();
             user = new Client(email,null);
            if(lstusers.contains(user)){
                System.out.println("Le compte existe déjà");
            }else{
                break;
            }
        }
        System.out.println("Entrerez le mot de passe");
        String password = scanner.next();
        user.setPassword(password);
        lstusers.add(user);
        System.out.println("Inscription réussie");
        System.out.println("当前注册的人员" + lstusers);
        
    }

    public static void connexion(){
        
        System.out.println("Saisez votre nom d'utilisateur");
        String email = scanner.nextLine();
        System.out.println("Entrerez le mot de passe");
        String password = scanner.nextLine();
        boolean Login = false;
        Iterator it = lstusers.iterator();
        while(it.hasNext()){
            Client user = (Client) it.next();
            if(user.email.equals(email) && user.password.equals(password)){
                Login = true;
                System.out.println("Connexion réussie！");
            }else{
                System.out.println("Échec de la connexion!");
            }
        }
        
        
    }
    
    public String consulter (Client client){
        int i;
        i=lstusers.indexOf(client);
        return "numero:"+lstusers.get(i).getNumClient()+"telephone"+lstusers.get(i).getTelClient()+"email:"+lstusers.get(i).getEmail()
                +"codepostale:"+lstusers.get(i).getCodePostalC()+"ville:"+lstusers.get(i).getVilleClient()+"cartebancaire:"+lstusers.get(i).getCarteBancaire()
        +"rue client:"+lstusers.get(i).getRurClient();
    }
    
    
   /*public void connecter(){
    System.out.println("Entrez votre nom d'utilisateur：");
    Scanner sc=new Scanner(System.in);
    String userName=sc.nextLine();
    System.out.println("Entrez votre mot de passe d'utilisateur：");
    String pwd=sc.nextLine();
    
    for (int i=0;i<lstusers.size();i++){
    if(userName.equals(lstusers.get(i).getEmail())&&userName.equals(lstusers.get(i).getPassword())){
    System.out.println("connexion réussie");
    break;}
    else{
        System.out.println("Le nom d'utilisateur ou le mot de passe est incorrect, veuillez le saisir à nouveau");	
} 
    }
    } */  
   
   
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
