/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author 92930
 */
public class ClientConnect extends Base {
    static Scanner scanner = new Scanner(System.in);
    public Client login(Client client){
		String sql = "select * from client where email=? and password=?";
		Client clientsql = null; //传值
    try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, client.getEmail()); //correspond premier ? 
			prst.setString(2, client.getPassword());//correpond deuxieme ?
			ResultSet executeQuery = prst.executeQuery();//read result
                        
			if(executeQuery.next()){ //如果有这一对值 登陆了 实体化一个对象
				clientsql = new Client();
				clientsql .setCarteBancaire(executeQuery.getString("NumCarteBancaire"));
				clientsql .setCodePostalC(executeQuery.getString("CodePostal"));
				clientsql .setEmail(executeQuery.getString("EmailC"));
				clientsql .setPassword(executeQuery.getString("Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clientsql;
    }
    
    public void register(String email, String pwd) {
		String sql = "insert into client values('" +email + "','" + pwd + "')";
		try {
			PreparedStatement prst = con.prepareStatement(sql);    
                            ResultSet executeQuery = prst.executeQuery();
			// 执行sql语句
			// 执行给定 SQL语句，语句可能为 INSERT、UPDATE 或 DELETE 语句，或不返回内容
			
			System.out.println("注册成功");
		} catch (SQLException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		} 
		}
    
    
         public boolean isLogin(Client user) {
		boolean login_win = false;
		String sql = "select * from client where EmailC ='" + user.getEmail()+ "' and Password='"
				+ user.getPassword()+ "'";
               try {
			PreparedStatement prst = con.prepareStatement(sql);    
                            ResultSet executeQuery = prst.executeQuery();
                            if (rs.next()) {
				login_win = true;
			}

         }

}