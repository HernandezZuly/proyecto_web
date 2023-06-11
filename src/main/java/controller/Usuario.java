package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.UsuarioVO;

public class Usuario extends HttpServlet{
    UsuarioVO u=new UsuarioVO();
    UsuarioDAO ud=new UsuarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch (a) {
            case "volver":
                volver(req, resp);
            break;
            case "usuarios":
                usuarios(req, resp);
            break;
            case "abrirForm":
                abrirForm(req,resp);
            break;
            case "editarForm":
                editarForm(req,resp);
            break;
            case "listar":
                listar(req,resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch (a) {
            case "add":
                add(req,resp);
            break;
            case "editar":
                editar(req,resp);
            break;
        }
    }

    private void usuarios (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/usuario.jsp").forward(req, resp);
            System.out.println("La vista usuario ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista NO ha sido abierto"+e.getMessage().toString());
        }
    }
    
    private void volver (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            System.out.println("La vista daviplata ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista daviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void abrirForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/registrarUsuario.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

    private void editarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            List usuario=ud.listar();
            req.setAttribute("usuarios", usuario);
            req.getRequestDispatcher("views/editarUsuario.jsp").forward(req, resp);
            System.out.println("El formulario ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
        }
    }

/////////////////////////////////////////////////
    
    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List usuario=ud.listar();
            req.setAttribute("usuarios", usuario);
            usuarios(req, resp);
            System.out.println("Datos listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombre")!=null){
            u.setNombre(req.getParameter("nombre"));
        }
        if(req.getParameter("apellido")!=null){
            u.setApellido(req.getParameter("apellido"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            u.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("numeroDocumento")!=null){
            u.setNumeroDocumento(Integer.parseInt(req.getParameter("numeroDocumento")));
        }
        if(req.getParameter("numeroCelular")!=null){
                            //Se utiliza para convertilo en tipo int
            u.setNumeroCelular(Integer.parseInt(req.getParameter("numeroCelular")));
        }
        if(req.getParameter("correo")!=null){
            u.setCorreo(req.getParameter("correo"));
        }
        if(req.getParameter("clave")!=null){
            u.setClave(req.getParameter("clave"));
        }
        if(req.getParameter("numeroCuenta")!=null){
            u.setNumeroCuenta(Integer.parseInt(req.getParameter("numeroCuenta")));
        }
        if(req.getParameter("estadoUsuario")!=null){
            u.setEstadoUsuario(true);
        }
        else{
            u.setEstadoUsuario(false);
        }
        listar(req, resp);
        try {
            ud.registrar(u);
            System.out.println("Registro insertado correctamente");
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro "+e.getMessage().toString());
        }
    }

    private void editar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idUsuario")!=null){
            u.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
        }
        if(req.getParameter("nombre")!=null){
            u.setNombre(req.getParameter("nombre"));
        }
        if(req.getParameter("apellido")!=null){
            u.setApellido(req.getParameter("apellido"));
        }
        if(req.getParameter("tipoDocumento")!=null){
            u.setTipoDocumento(req.getParameter("tipoDocumento"));
        }
        if(req.getParameter("numeroDocumento")!=null){
            u.setNumeroDocumento(Integer.parseInt(req.getParameter("numeroDocumento")));
        }
        if(req.getParameter("numeroCelular")!=null){
                            //Se utiliza para convertilo en tipo int
            u.setNumeroCelular(Integer.parseInt(req.getParameter("numeroCelular")));
        }
        if(req.getParameter("correo")!=null){
            u.setCorreo(req.getParameter("correo"));
        }
        if(req.getParameter("clave")!=null){
            u.setClave(req.getParameter("clave"));
        }
        if(req.getParameter("numeroCuenta")!=null){
            u.setNumeroCuenta(Integer.parseInt(req.getParameter("numeroCuenta")));
        }
        if(req.getParameter("estadoUsuario")!=null){
            u.setEstadoUsuario(true);
        }
        else{
            u.setEstadoUsuario(false);
        }
        listar(req, resp);
        try {
            ud.actualizar(u);
            System.out.println("Registro actualizado correctamente");
        } catch (Exception e) {
            System.out.println("Error en la actualización del registro "+e.getMessage().toString());
        }
    }

    
}
