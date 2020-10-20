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

/**
 *
 * @author 92930
 */
public class ClientConnect extends Base {
    public Client login(Client client){
        
    
		String sql = "select * from client where email=? and password=?";
		Client clientsql = null; //传值
    try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, client.getEmail()); //correspond premier ? 
			prst.setString(2, client.getPassword());//correpond deuxieme ?
			ResultSet executeQuery = prst.executeQuery();//read result
                        
			if(executeQuery.next()){ //如果有值 登陆了
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
    
}
