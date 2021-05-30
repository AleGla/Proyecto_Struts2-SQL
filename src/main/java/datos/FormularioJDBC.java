package datos;

import domain.Formulario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormularioJDBC {
    

    public static List<Formulario> listaPersonas() throws ClassNotFoundException, SQLException{
   
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<Formulario> lista=new ArrayList();
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=ConexionSQL.getConexion();
            ps=con.prepareStatement("SELECT * FROM RegistracionPersonas");
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                int id=rs.getInt("idPersona");
                String usuario=rs.getString("usuario");
                String pass=rs.getString("pass");
                String nombre=rs.getString("nombre");
                String apellido=rs.getString("apellido");
                String email=rs.getString("email");
                String telefono=rs.getString("telefono");
                int edad=rs.getInt("edad");
                
                
                lista.add(new Formulario(id,usuario,pass,nombre,apellido,email,telefono,edad));
            
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        
        }finally{
            ConexionSQL.closeResult(rs);
            ConexionSQL.closePreparedStatement(ps);
            ConexionSQL.closeConexion(con);
        }
          return lista;        
    }
     

     public static int agregarPersona(Formulario p) throws ClassNotFoundException, SQLException{
        
        Connection con=null;
        PreparedStatement ps=null;
        int registro=0;
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=ConexionSQL.getConexion();
            ps=con.prepareStatement("INSERT INTO RegistracionPersonas(usuario,pass,nombre,apellido,email,telefono,edad)VALUES(?,?,?,?,?,?,?)");
            
            ps.setString(1, p.getUsuario());
            ps.setString(2, p.getPassword());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setString(5, p.getEmail());
            ps.setString(6, p.getTelefono());
            ps.setInt(7, p.getEdad());
                        
            registro=ps.executeUpdate();
            
        }catch(SQLException e){
            e.printStackTrace();
        
        }finally{
            ConexionSQL.closePreparedStatement(ps);
            ConexionSQL.closeConexion(con);
        }
        
        return registro;
    }

    
}
