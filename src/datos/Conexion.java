
package datos;

import java.sql.*;

public class Conexion {
    private static final String url = "jdbc:mysql://localhost:3300/iefi";
    private static final String user = "root";
    private static final String password= "H%97kja297rty";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }
    
    public static void close(Statement st) throws SQLException {
        st.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException {
    smtm.close();
    }
    
    public static void close(Connection cn) throws SQLException {
    cn.close();
    }
}


