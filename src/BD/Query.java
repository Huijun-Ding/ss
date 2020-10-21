package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Query {

    private static Connection conn = null;
    public static PreparedStatement ps = null;
    private static ResultSet rs = null;
    public static String SQLsen = null;

    public static ArrayList<Object> parameter = new ArrayList<>();

    public static void Query() {
       conn= DB.createConn();
        System.out.println("hello");
    }

    public static void afferentSQL(String Sqlsentence) {
        try {
            SQLsen = Sqlsentence;
            System.out.println(SQLsen);  
            ps = conn.prepareStatement(Sqlsentence, Statement.RETURN_GENERATED_KEYS);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int Update() {
        int a = 0;
        try {
            for (int i = 0; i < parameter.size(); i++) {

                int o = i + 1;

                Object param = parameter.get(i);
                if (param instanceof Integer) {
                    ps.setInt(o, (int) param);
                } else if (param instanceof Double) {
                    ps.setDouble(o, (double) param);
                } else if (param instanceof String) {
                    ps.setString(o, (String) param);
                }
            }

            a = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        //return le nombre de ligne a été affecté
        return a;
    }

    public static List<Object> Select() {
        //return list
        List<Object> users = new ArrayList<Object>();
        try {
            //prepare parametre
            for (int i = 0; i < parameter.size(); i++) {
                int o = i + 1;
                Object param = parameter.get(i);
                if (param instanceof Integer) {
                    ps.setInt(o, (int) param);
                } else if (param instanceof Double) {
                    ps.setDouble(o, (double) param);
                } else if (param instanceof String) {
                    ps.setString(o, (String) param);
                }
            }
            //excute sql
            rs = ps.executeQuery();
            int ts = 0;
            //get db base tabe all attirutes 
            ResultSetMetaData rsmd = rs.getMetaData();
            //parcouris résulat et les enregistre dans une list
            while (rs.next()) {
                ts++;
                //enregistre chaque ligne dans un Map
                Map<String, Object> rowData = new HashMap<String, Object>();
                //parcouris tous les columns
                for (int l = 1; l <= rsmd.getColumnCount(); l++) {
                    rowData.put(rsmd.getColumnName(l), rs.getObject(l));
                }
                //enregistre dans une liste
                users.add(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return users;
    }

    private static void close() {
        parameter.clear();
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
            ps = null;
            rs = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
