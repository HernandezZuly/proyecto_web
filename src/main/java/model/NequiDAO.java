package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NequiDAO {
    //Atributos para realizar operaciones sobre la BD
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
    
    public int registrar(NequiVO nequi) throws SQLException{
        sql = "INSERT INTO Nequi (idUsuario, retiro, saldoActual, valorRecarga, estadoNequi) VALUES (?, ?, ?, ?, ?)";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, nequi.getIdUsuario());
            ps.setInt(2, nequi.getRetiro());
            ps.setInt(3, nequi.getSaldoActual());
            ps.setInt(4, nequi.getValorRecarga());
            ps.setBoolean(5, nequi.getEstadoNequi());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró en la tabla nequi correctamente");
        } catch (Exception e) {
            System.out.println("Error en el registro de la tabla nequi " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public List<NequiVO> listar() throws SQLException{
        List<NequiVO> nequi=new ArrayList<>();
        sql = "SELECT * FROM Nequi";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                NequiVO r = new NequiVO();
                //Escribir en el setter cada valor encontrado
                r.setIdNequi(rs.getInt("idNequi"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setRetiro(rs.getInt("retiro"));
                r.setSaldoActual(rs.getInt("saldoActual"));
                r.setValorRecarga(rs.getInt("valorRecarga"));
                r.setEstadoNequi(rs.getBoolean("estadoNequi"));
                nequi.add(r);
            }
            ps.close();
            System.out.println("consulta de la tabla Nequi exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de la tabla Nequi no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return nequi;
    }

    public List<NequiVO> listarId() throws SQLException{
        List<NequiVO> nequi=new ArrayList<>();
        sql = "SELECT * FROM Nequi WHERE idNequi = '?' ";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                NequiVO r = new NequiVO();
                //Escribir en el setter cada valor encontrado
                r.setIdNequi(rs.getInt("idNequi"));
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setRetiro(rs.getInt("retiro"));
                r.setSaldoActual(rs.getInt("saldoActual"));
                r.setValorRecarga(rs.getInt("valorRecarga"));
                r.setEstadoNequi(rs.getBoolean("estadoNequi"));
                nequi.add(r);
            }
            ps.close();
            System.out.println("consulta de la tabla Nequi exitosa");
        } catch (Exception e) {
            System.out.println("La consulta de la tabla Nequi no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return nequi;
    }

    public int actualizar(NequiVO nequi) throws SQLException{
        sql = "UPDATE Nequi SET idUsuario=?, retiro=?, saldoActual=?, valorRecarga=?, estadoNequi=? WHERE idNequi=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, nequi.getIdUsuario());
            ps.setInt(2, nequi.getRetiro());
            ps.setInt(3, nequi.getSaldoActual());
            ps.setInt(4, nequi.getValorRecarga());
            ps.setBoolean(5, nequi.getEstadoNequi());
            ps.setInt(6, nequi.getIdNequi());
            System.out.println(sql);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se actualizo el registro de la tabla Nequi correctamente");
        } catch (Exception e) {
            System.out.println("Error en la actualización del registro de la tabla Nequi " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public int eliminar(NequiVO nequi) throws SQLException{
        sql = "DELETE FROM Nequi WHERE idNequi=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino un registro de la tabla Nequi correctamente");
        } catch (Exception e) {
            System.out.println("Error en la eliminación de un registro de la tabla Nequi " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }
}
