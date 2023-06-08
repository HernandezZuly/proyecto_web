package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    //Atributos para realizar operaciones sobre la BD
    Connection con; //objeto de conexión
    PreparedStatement ps; //preparar sentencias
    ResultSet rs; // almacenar consultas
    String sql=null;
    int r; //cantidad de filas que devuelve una sentencia
    
    public int registrar(UsuarioVO usuario) throws SQLException{
        sql = "INSERT INTO Usuario ( nombre, apellido, tipoDocumento, numeroDocumento, numeroCelular, correo, clave, numeroCuenta, estadoUsuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getTipoDocumento ());
            ps.setInt(4, usuario.getNumeroDocumento());
            ps.setInt(5, usuario.getNumeroCelular());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getClave());
            ps.setInt(8, usuario.getNumeroCuenta());
            ps.setBoolean(9, usuario.getEstadoUsuario());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el usuario correctamente");
        } catch (Exception e) {
            System.out.println("Error en el registro " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public List<UsuarioVO> listar() throws SQLException{
        List<UsuarioVO> usuario=new ArrayList<>();
        sql = "SELECT * FROM Usuario";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                UsuarioVO r = new UsuarioVO();
                //Escribir en el setter cada valor encontrado
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellido"));
                r.setTipoDocumento(rs.getString("tipoDocumento"));
                r.setNumeroDocumento(rs.getInt("numeroDocumento"));
                r.setNumeroCelular(rs.getInt("numeroCelular"));
                r.setCorreo(rs.getString("correo"));
                r.setClave(rs.getString("clave"));
                r.setNumeroCuenta(rs.getInt("numeroCuenta"));
                r.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
                usuario.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return usuario;
    }

    public List<UsuarioVO> listarId() throws SQLException{
        List<UsuarioVO> usuario=new ArrayList<>();
        sql = "SELECT * FROM Usuario WHERE idUsuario = '?' ";
        try {
            con=Conexion.conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                UsuarioVO r = new UsuarioVO();
                //Escribir en el setter cada valor encontrado
                r.setIdUsuario(rs.getInt("idUsuario"));
                r.setNombre(rs.getString("nombre"));
                r.setApellido(rs.getString("apellido"));
                r.setTipoDocumento(rs.getString("tipoDocumento"));
                r.setNumeroDocumento(rs.getInt("numeroDocumento"));
                r.setNumeroCelular(rs.getInt("numeroCelular"));
                r.setCorreo(rs.getString("correo"));
                r.setClave(rs.getString("clave"));
                r.setNumeroCuenta(rs.getInt("numeroCuenta"));
                r.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
                usuario.add(r);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutada " + e.getMessage() .toString());
        }
        finally{
            con.close();
        }
        return usuario;
    }

    public int actualizar(UsuarioVO usuario) throws SQLException{
        sql = "UPDATE Usuario SET nombre=?, apellido=?, tipoDocumento=?, numeroDocumento=?, numeroCelular=?, correo=?, clave=?, numeroCuenta=?, estadoUsuario=? WHERE idUsuario=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getTipoDocumento ());
            ps.setInt(4, usuario.getNumeroDocumento());
            ps.setInt(5, usuario.getNumeroCelular());
            ps.setString(6, usuario.getCorreo());
            ps.setString(7, usuario.getClave());
            ps.setInt(8, usuario.getNumeroCuenta());
            ps.setBoolean(9, usuario.getEstadoUsuario());
            ps.setInt(10, usuario.getIdUsuario());
            System.out.println(sql);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se actualizo el usuario correctamente");
        } catch (Exception e) {
            System.out.println("Error en la actualización " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }

    public int eliminar(UsuarioVO usuario) throws SQLException{
        sql = "DELETE FROM Usuario WHERE idUsuario=?";
        try {
            con = Conexion.conectar(); //abrir conexión
            ps = con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se elimino un registro correctamente");
        } catch (Exception e) {
            System.out.println("Error en la eliminación " + e.getMessage() .toString());
        }
        finally{
            con.close(); //cerrando conexión
        }
        return r;
    }
}
