package model;

public class DaviplataVO {
    //Atributos
    private int idDaviplata;
    private int retiro;
    private int saldoActual;
    private int valorRecarga;
    private Boolean estadoDaviplata;
    
    //Metodo constructor vacio
    public DaviplataVO() {
    }
    //Metodo constructor con parametros
    public DaviplataVO(int idDaviplata, int retiro, int saldoActual, int valorRecarga, Boolean estadoDaviplata) {
        this.idDaviplata = idDaviplata;
        this.retiro = retiro;
        this.saldoActual = saldoActual;
        this.valorRecarga = valorRecarga;
        this.estadoDaviplata = estadoDaviplata;
    }
    
    //Metodos accesores
    public int getIdDaviplata() {
        return idDaviplata;
    }
    public void setIdDaviplata(int idDaviplata) {
        this.idDaviplata = idDaviplata;
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
    public Boolean getEstadoDaviplata() {
        return estadoDaviplata;
    }
    public void setEstadoDaviplata(Boolean estadoDaviplata) {
        this.estadoDaviplata = estadoDaviplata;
    }
}
