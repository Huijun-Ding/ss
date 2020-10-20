package Dao;

import Model.Intervenant;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 92930
 */
public class IntervenanConnect extends Base {
      public Intervenant login(Intervenant intervenant){   
		String sql = "select * from Intervenant where email=? and password=?";
		Intervenant intersql = null; //传值
    try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setString(1, intervenant.getEmail()); //correspond premier ? 
			prst.setString(2, intervenant.getPassword());//correpond deuxieme ?
			ResultSet executeQuery = prst.executeQuery();//read result
                        
			if(executeQuery.next()){ //如果有值 登陆了
				intersql= new Intervenant();
				intersql.setCarteBancaireIn(executeQuery.getString("NumCarteBancaire"));
				intersql.setCodePostalIn(executeQuery.getString("CodePostal"));
				intersql .setEmail(executeQuery.getString("EmailC"));
				intersql .setPassword(executeQuery.getString("Password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return intersql;
    }
}
