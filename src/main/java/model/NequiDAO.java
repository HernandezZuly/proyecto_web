package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NequiDAO {
    //Atributos para realizar operaciones sobre la BD
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
    
    public int recargarSaldo(NequiVO nequi) throws SQLException{
        sql = "UPDATE Nequi SET valorRecarga = ?, saldoActual = saldoActual + valorRecarga WHERE idNequi = 1";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, nequi.getValorRecarga());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se recargo correctamente");
        } catch (Exception e) {
            System.out.println("Error en la recarga " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return nequi.getSaldoActual();
    }

    public int sacarPlata(NequiVO nequi) throws SQLException{
        sql = "UPDATE Nequi SET  retiro = ?, saldoActual = saldoActual - retiro WHERE idNequi = 1";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setInt(1, nequi.getRetiro());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("El retiro correctamente");
        } catch (Exception e) {
            System.out.println("Error en el retiro " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return nequi.getSaldoActual();
    }

    public int  consultarSaldo() throws SQLException{
        sql="select  saldoActual from Nequi" ;
        NequiVO nequivo=new NequiVO();
        try {
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            rs=ps.executeQuery(sql); //almacenar consultas
            while(rs.next()){ //Se ejecuta cuando el rs este en funcionamiento
            //El objeto de la clase VO - El valor que se va a retorar - rs
                nequivo.setSaldoActual(rs.getInt("saldoActual"));
            }
            ps.close(); //cerrar sentencia
            System.out.println("consulta ejecutada correctamente");
        } catch (Exception e) {
            System.out.println(" la consulta del saldo  no pudo ser ejecutado "+e.getMessage().toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return nequivo.getSaldoActual();
    }
}
