package beans.action;

import com.opensymphony.xwork2.ActionSupport;
import datos.ConexionSQL;
import datos.FormularioJDBC;
import domain.Formulario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Results({
    @Result(name="input", location="/WEB-INF/content/formulario.jsp"),
    @Result(name="success", location="/WEB-INF/content/tabla.jsp")        
})

public class FormularioAction extends ActionSupport{
            
    Formulario forma;    
    
    private List<Formulario>personas;

    Logger log= LogManager.getLogger(this);
    
    @Action("validarFormulario")
    public String execute() throws SQLException, ClassNotFoundException{        
        if("".equals(this.forma.getUsuario().trim()) || "".equals(this.forma.getPassword().trim()) || "".equals(this.forma.getNombre().trim()) || "".equals(this.forma.getApellido().trim())
            || "".equals(this.forma.getEmail().trim()) || "".equals(this.forma.getTelefono().trim()) || 0==this.forma.getEdad()){
            return INPUT;
        }else{           
          FormularioJDBC.agregarPersona(forma);
          personas=FormularioJDBC.listaPersonas();
          
          for(Formulario list: personas){
              log.info("persona: " + list);
          }
          
          return SUCCESS;
        }        
    }
    
    @Override
    public void validate(){
        //USUARIO
        if("".equals(this.forma.getUsuario().trim())) super.addFieldError("forma.usuario", getErrorBlanco());
        else if(this.forma.getUsuario().length()<5) super.addFieldError("forma.usuario", getErrorCaracteres());
        
        //PASSWORD
        if("".equals(this.forma.getPassword().trim())) super.addFieldError("forma.password", getErrorBlanco());
        else if(this.forma.getPassword().length()<5) super.addFieldError("forma.password", getErrorCaracteres());
        
        //NOMBRE
        if("".equals(this.forma.getNombre().trim())) super.addFieldError("forma.nombre", getErrorBlanco());     
        
        //APELLIDO
        if("".equals(this.forma.getApellido().trim())) super.addFieldError("forma.apellido", getErrorBlanco());        
        
        //EMAIL     
        if("".equals(this.forma.getEmail().trim())) super.addFieldError("forma.email", getErrorBlanco());    
        else if(!contieneArroba()) super.addFieldError("forma.email", getErrorArroba());
        
        //EDAD  
        if(0==this.forma.getEdad()) super.addFieldError("forma.edad", getErrorEdad());
        
        //TELEFONO        
        if("".equals(this.forma.getTelefono().trim())) super.addFieldError("forma.telefono", getErrorBlanco());
        else if(this.forma.getTelefono().length()<8) super.addFieldError("forma.telefono", getErrorCaracteresTelefono());
        
        
    }
    
    public String getErrorBlanco(){
        return getText("form.blanco_error");
    }
    
    public String getErrorCaracteres(){
        return getText("form.caracteres_error");
    }
    
    public String getErrorCaracteresTelefono(){
        return getText("form.caracteres_error_telefono");
    }
    
    public String getErrorEdad(){
        return getText("form.edad_error");
    }
    
    public String getErrorArroba(){
        return getText("form.Arroba_error");
    }
    
    public boolean contieneArroba(){        
        int arroba=0;
        if(this.forma.getEmail()!=null || this.forma.getEmail()!=""){                
            for(int i=0;i<this.forma.getEmail().length();i++){                
                if(this.forma.getEmail().charAt(i)=='@') arroba++;        
            }
        }
        return arroba==1;
    }

    public Formulario getForma() {
        return forma;
    }

    public void setForma(Formulario forma) {
        this.forma = forma;
    }

    public List<Formulario> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Formulario> personas) {
        this.personas = personas;
    }
    
    
    
}

