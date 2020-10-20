/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import BD.DB;
import Model.Client;
import java.util.Scanner;
import Dao.ClientConnect;
/**
 *
 * @author 92930
 */
public class Test {
    public static void main(String[] args) {
		Test t = new Test();
		System.out.println("Veuillez choisir votre opération: a. Connexion de l'utilisateur b. Enregistrer l'utilisateur");
		Scanner sc = new Scanner(System.in);
		String function = sc.next().trim();
		switch (function) {
		case "a":
			t.login();
			break;
		case "b":
			t.register();
			break;
		default:
			System.out.println("Le format d'entrée est incorrect, veuillez le saisir à nouveau");
		}
    
    /**
     *
     */
                 public void login() {
		DB dbUtil = new DB();
		Scanner s = new Scanner(System.in);
		System.out.println("Saisez votre nom d'utilisateur");
		String email = s.next().trim();
		System.out.println("Entrerez le mot de passe:");
		String password = s.next().trim();
		Client user = new  Client(email, password );

		if (ClientConnect.isLogin(user)) {
			System.out.println("connexion réussie");
		} else {
			System.out.println("Échec de la connexion");
		}}
    
                public void register() {
		DB dbUtil = new DB();
		Scanner s = new Scanner(System.in);
		System.out.println("Saisez votre nom d'utilisateur");
		String uname = s.next().trim();
		System.out.println("Entrerez le mot de passe:");
		String upwd = s.next().trim();
		ClientConnect.register(uname, upwd);
	}
	}
    
    
