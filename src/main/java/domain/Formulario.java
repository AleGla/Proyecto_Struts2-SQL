package domain;

public class Formulario{
    
    private String usuario;
    private int idPersona;
    private String pass;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int edad;

    public Formulario(){
        
    }
    
    public Formulario(String usuario, String pass, String nombre, String apellido, String email, String telefono, int edad) {
        this.usuario = usuario;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }
       
   

    public Formulario(int idPersona, String usuario, String pass, String nombre, String apellido, String email, String telefono, int edad) {
        this.usuario = usuario;
        this.idPersona = idPersona;
        this.pass = pass;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
      
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String password) {
        this.pass = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdPersona() {
        return idPersona;
    }

    
    @Override
    public String toString() {
        return "Formulario{" + "idPersona=" + idPersona + ", Usuario=" + usuario + ", pass=" + pass + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + ", edad=" + edad + '}';
    }
    
    
}
