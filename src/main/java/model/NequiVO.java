package model;

public class NequiVO {
    //Atributos
    private int idNequi;
    private int idUsuario;
    private int retiro;
    private int saldoActual;
    private int valorRecarga;
    private Boolean estadoNequi;
    
    //Metodo constructor vacio
    public NequiVO() {
    }
    //Metodo constructor con parametros
    public NequiVO(int idNequi, int idUsuario, int retiro, int saldoActual, int valorRecarga, Boolean estadoNequi) {
        this.idNequi = idNequi;
        this.idUsuario = idUsuario;
        this.retiro = retiro;
        this.saldoActual = saldoActual;
        this.valorRecarga = valorRecarga;
        this.estadoNequi = estadoNequi;
    }
    
    //Metodos accesores
    public int getIdNequi() {
        return idNequi;
    }
    public void setIdNequi(int idNequi) {
        this.idNequi = idNequi;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getRetiro() {
        return retiro;
    }
    public void setRetiro(int retiro) {
        this.retiro = retiro;
    }
    public int getSaldoActual() {
        return saldoActual;
    }
    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }
    public int getValorRecarga() {
        return valorRecarga;
    }
    public void setValorRecarga(int valorRecarga) {
        this.valorRecarga = valorRecarga;
    }
    public Boolean getEstadoNequi() {
        return estadoNequi;
    }
    public void setEstadoNequi(Boolean estadoNequi) {
        this.estadoNequi = estadoNequi;
    }

}
