package model;

public class UsuarioVO {
    //Atributos
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private int numeroDocumento;
    private int numeroCelular;
    private String correo;
    private String clave;
    private int numeroCuenta;
    private Boolean estadoUsuario;
    
    //Metodo constructor vacio
    public UsuarioVO() {
    }
    //Metodo constructor con parametros
    public UsuarioVO(int idUsuario, String nombre, String apellido, String tipoDocumento, int numeroDocumento, int numeroCelular, String correo, String clave, int numeroCuenta, Boolean estadoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.clave = clave;
        this.numeroCuenta = numeroCuenta;
        this.estadoUsuario = estadoUsuario;
    }

    //Metodos accesores
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;

    }
    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }
}
