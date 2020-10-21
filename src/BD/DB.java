/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Configuration conf;

    /**
     *
     */
    static {
        String path = "BD//db.properties";
        Properties pros = new Properties();
        try {
            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        conf = new Configuration();
        conf.setPwd(pros.getProperty("pwd"));
        conf.setUrl(pros.getProperty("url"));
        conf.setUser(pros.getProperty("user"));
        conf.setUsingDB(pros.getProperty("usingDB"));
        
    }

    /**
     * connexion¨
     *
     * @return
     */
    public static Connection createConn() {
        try {
            return DriverManager.getConnection(conf.getUrl()+conf.getUsingDB(), conf.getUser(), conf.getPwd());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return	Configuration
     */
    public static Configuration getConf() {
        return conf;
    }

    public static void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("failed", e);
            }
        }
    }

    /**
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs, Statement ps, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
