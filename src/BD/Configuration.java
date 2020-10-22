package BD;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author leonl
 */
public class Configuration {
    private static String driver;
    /**
     * jdbc url
     */
    private String url;

    /**
     * user
     */
    private String user;

    /**
     * mdp
     */
    private String pwd;

    /**
     * db name
     */
    private String usingDB;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsingDB() {
        return usingDB;
    }

    public void setUsingDB(String usingDB) {
        this.usingDB = usingDB;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        Configuration.driver = driver;
    }

    public Configuration(String url, String user, String pwd, String usingDB) {
        this.url = url;
        this.user = user;
        this.pwd = pwd;
        this.usingDB = usingDB;
    }

    

    public Configuration() {
        super();
    }

}
