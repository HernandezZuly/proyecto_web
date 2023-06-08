package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaviplataDAO {
    //Atributos para realizar operaciones sobre la BD
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
    
    public int registrar(DaviplataVO daviplata) throws SQLException{
        sql = "INSERT INTO Daviplata (idUsuario, retiro, saldoActual, valorRecarga, estadoDaviplata) VALUES (?, ?, ?, ?, ?)";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, daviplata.getIdUsuario());
            ps.setInt(2, daviplata.getRetiro());
            ps.setInt(3, daviplata.getSaldoActual());
            ps.setInt(4, daviplata.getValorRecarga());
            ps.setBoolean(5, daviplata.getEstadoDaviplata());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró en la tabla Daviplata correctamente");
        } catch (Exception e) {
            System.out.println("Error en el registro de la tabla Daviplata " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public List<DaviplataVO> listar() throws SQLException{
        List<DaviplataVO> daviplata=new ArrayList<>();
        sql = "SELECT * FROM Daviplata";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                DaviplataVO r = new DaviplataVO();
                //Escribir en el setter cada valor encontrado
                r.setIdDaviplata(rs.getInt("idDaviplata"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setRetiro(rs.getInt("retiro"));
                r.setSaldoActual(rs.getInt("saldoActual"));
                r.setValorRecarga(rs.getInt("valorRecarga"));
                r.setEstadoDaviplata(rs.getBoolean("estadoDaviplata"));
                daviplata.add(r);
            }
            ps.close();
            System.out.println("consulta de la tabla Daviplata exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de la tabla Daviplata no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return daviplata;
    }

    public List<DaviplataVO> listarId() throws SQLException{
        List<DaviplataVO> daviplata=new ArrayList<>();
        sql = "SELECT * FROM Daviplata WHERE idDaviplata = '?' ";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                DaviplataVO r = new DaviplataVO();
                //Escribir en el setter cada valor encontrado
                r.setIdDaviplata(rs.getInt("idDaviplata"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setRetiro(rs.getInt("retiro"));
                r.setSaldoActual(rs.getInt("saldoActual"));
                r.setValorRecarga(rs.getInt("valorRecarga"));
                r.setEstadoDaviplata(rs.getBoolean("estadoDaviplata"));
                daviplata.add(r);
            }
            ps.close();
            System.out.println("consulta de la tabla Daviplata exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de la tabla Daviplata no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return daviplata;
    }

    public int actualizar(DaviplataVO daviplata) throws SQLException{
        sql = "UPDATE Daviplata SET idUsuario=?, retiro=?, saldoActual=?, valorRecarga=?, estadoDaviplata=? WHERE idDaviplata=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, daviplata.getIdUsuario());
            ps.setInt(2, daviplata.getRetiro());
            ps.setInt(3, daviplata.getSaldoActual());
            ps.setInt(4, daviplata.getValorRecarga());
            ps.setBoolean(5, daviplata.getEstadoDaviplata());
            ps.setInt(6, daviplata.getIdDaviplata());
            System.out.println(sql);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se actualizo el registro de la tabla Daviplata correctamente");
        } catch (Exception e) {
            System.out.println("Error en la actualización del registro de la tabla Daviplata " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public int eliminar(DaviplataVO daviplata) throws SQLException{
        sql = "DELETE FROM Daviplata WHERE idDaviplata=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino un registro de la tabla DaviplataVO correctamente");
        } catch (Exception e) {
            System.out.println("Error en la eliminación de un registro de la tabla DaviplataVO " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }
}
