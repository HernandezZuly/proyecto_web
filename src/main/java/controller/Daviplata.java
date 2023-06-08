package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DaviplataDAO;
import model.DaviplataVO;

public class Daviplata extends HttpServlet {
    DaviplataVO d=new DaviplataVO();
    DaviplataDAO davd= new DaviplataDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch (a) {
            case "dashboard":
                dashboard(req, resp);
            break;
            case "loginDaviplata":
                loginDaviplata(req, resp);
            break;
            case "volver":
                volver(req, resp);
            break;
            case "daviplata":
                daviplata(req, resp);
            break;
            case "eliminarForm":
                eliminarForm(req,resp);
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
            case "eliminar":
                eliminar(req,resp);
            break;
        }
    }

    private void daviplata (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/daviplata.jsp").forward(req, resp);
            System.out.println("La vista daviplata ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista daviplata NO ha sido abierto "+e.getMessage().toString());
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

    private void loginDaviplata (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/login_daviplata.jsp").forward(req, resp);
            System.out.println("La vista login daviplata ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista login daviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void dashboard (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/dashboardDaviplata.jsp").forward(req, resp);
            System.out.println("La vista dashboard ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista dashboard NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void abrirForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/registrarDaviplata.jsp").forward(req, resp);
            System.out.println("El formulario daviplata ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario daviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void eliminarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/eliminarDaviplata.jsp").forward(req, resp);
            System.out.println("La vista eliminarDaviplata ha sido abierto");
        }catch(Exception e){
            System.out.println("La vista eliminarDaviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void editarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            List daviplata=davd.listar();
            req.setAttribute("daviplata", daviplata);
            req.getRequestDispatcher("views/editarDaviplata.jsp").forward(req, resp);
            System.out.println("El formulario editarDaviplata ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario editarDaviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

/////////////////////////////////////////////////

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List daviplata=davd.listar();
        req.setAttribute("daviplata", daviplata);
        daviplata(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

private void add(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idUsuario")!=null){
        d.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    if(req.getParameter("retiro")!=null){
        d.setRetiro(Integer.parseInt(req.getParameter("retiro")));
    }
    if(req.getParameter("saldoActual")!=null){
                        //Se utiliza para convertilo en tipo int
        d.setSaldoActual(Integer.parseInt(req.getParameter("saldoActual")));
    }
    if(req.getParameter("valorRecarga")!=null){
        d.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga")));
    }
    if(req.getParameter("estadoDaviplata")!=null){
        d.setEstadoDaviplata(true);
    }
    else{
        d.setEstadoDaviplata(false);
    }
    listar(req, resp);
    try {
        davd.registrar(d);
        System.out.println("Registro insertado correctamente a la tabla Daviplata");
    } catch (Exception e) {
        System.out.println("Error en la inserción de un registro a la tabla Daviplata "+e.getMessage().toString());
    }
}

private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idDaviplata")!=null){
        d.setIdUsuario(Integer.parseInt(req.getParameter("idDaviplata")));
    }
    if(req.getParameter("idUsuario")!=null){
        d.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    if(req.getParameter("retiro")!=null){
        d.setRetiro(Integer.parseInt(req.getParameter("retiro")));
    }
    if(req.getParameter("saldoActual")!=null){
                        //Se utiliza para convertilo en tipo int
        d.setSaldoActual(Integer.parseInt(req.getParameter("saldoActual")));
    }
    if(req.getParameter("valorRecarga")!=null){
        d.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga")));
    }
    if(req.getParameter("estadoDaviplata")!=null){
        d.setEstadoDaviplata(true);
    }
    else{
        d.setEstadoDaviplata(false);
    }
    listar(req, resp);
    try {
        davd.actualizar(d);
        System.out.println("Registro actualizado correctamente en la tabla de Daviplata");
    } catch (Exception e) {
        System.out.println("Error en la actualización del registro en la tabla de Daviplata "+e.getMessage().toString());
    }
}

private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        davd.eliminar(d);
        System.out.println("Se elimino correctamente un registro de la tabla Daviplata");
    } catch (Exception e) {
        System.out.println("Error al eliminar un registro de la tabla Daviplata "+e.getMessage().toString());
    }
}

}

