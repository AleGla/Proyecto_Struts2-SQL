package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexionSQL {

private final static String CONEXION_SQL="jdbc:sqlserver://localhost:1433;databaseName=db1;user=sa;password=bichocapo;";

public static Connection getConexion() throws SQLException{
    
    Connection conexion=DriverManager.getConnection(CONEXION_SQL);
    return conexion;
}

public static void closeConexion(Connection con) throws SQLException{
    con.close();
}

public static void closePreparedStatement(PreparedStatement ps) throws SQLException{
    ps.close();
}

public static void closeResult(ResultSet rs) throws SQLException{
    rs.close();
}
    
}
