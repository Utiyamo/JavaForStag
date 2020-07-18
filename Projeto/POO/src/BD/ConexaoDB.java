package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	protected Connection con;
	public void openConnection(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            this.con = DriverManager.
                getConnection("jdbc:sqlserver://127.0.0.1:1433;database=Odin;"+"IntegratedSecurity=true;"
            					,"admin","admin");  
            con.setAutoCommit(false);
        } catch (ClassNotFoundException e) {          
            e.printStackTrace();
        } catch (SQLException e) {            
            e.printStackTrace();
        }
    }
	public void closeConnection() {
		try {
			this.con.close();
		} catch (SQLException e) {         
            e.printStackTrace();
        }
	}
}
