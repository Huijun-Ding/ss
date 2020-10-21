
import BD.DB;
import Dao.ClientDao;




public class Main {

    public static void main(String[] args) {

        DB db = new DB();

        db.createConn();
        ClientDao clogin = new ClientDao();
        clogin.login("929302356@qq.com","049988");
        // TODO code application logic here
    }
    
        
}
    
    
















    
    

