/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 92930
 */
public class DatabaseUtil {
	private Connection conn = null;
	private Statement stat = null;
	private ResultSet rs = null;
        
         String url = "jdbc:mysql://localhost:8081/bd_dolt";
	String username = "root";
	String password = "";
        
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
        
        public void register(String name, String pwd) {
		String sql = "insert into client values('','','','','','name','','','','','','','','pwd')";
		try {
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("连接成功...");
			stat = conn.createStatement();
			stat.execute(sql);
			System.out.println("注册成功");
		} catch (SQLException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		} finally {
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
        public boolean isLogin(Client user) {
		boolean login_win = false;
		String sql = "select * from users where EmailC='" + user.getEmail()+ "' and Password='"
				+ user.getPassword() + "'";
		try {
			conn = DriverManager.getConnection(url, username, password);
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			if (rs.next()) {
				login_win = true;
			}

		} catch (SQLException e) {
			System.out.println("连接失败....");
			e.printStackTrace();
		} finally {
			if (null != rs) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != stat) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (null != conn) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return login_win;
	}
}
        
       

