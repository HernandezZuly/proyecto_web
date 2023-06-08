package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NequiDAO;
import model.NequiVO;

public class Nequi extends HttpServlet {
    NequiVO n=new NequiVO();
    NequiDAO nd= new NequiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String a=req.getParameter("accion");

        switch (a) {
            case "dashboard":
                dashboard(req, resp);
            break;
            case "loginNequi":
                loginNequi(req, resp);
            break;
            case "volver":
                volver(req, resp);
            break;
            case "nequi":
                nequi(req, resp);
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

    private void nequi (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/nequi.jsp").forward(req, resp);
            System.out.println("La vista nequi ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista nequi NO ha sido abierto "+e.getMessage().toString());
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

    private void loginNequi (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/login_nequi.jsp").forward(req, resp);
            System.out.println("La vista loginNequi ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista loginNequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void dashboard (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/dashboard.jsp").forward(req, resp);
            System.out.println("La vista dashboard ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista dashboard NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void abrirForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/registrarNequi.jsp").forward(req, resp);
            System.out.println("El formulario Nequi ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario Nequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void eliminarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/eliminarNequi.jsp").forward(req, resp);
            System.out.println("La vista eliminarNequi ha sido abierto");
        }catch(Exception e){
            System.out.println("La vista eliminarNequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void editarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            List nequi=nd.listar();
            req.setAttribute("nequi", nequi);
            req.getRequestDispatcher("views/editarNequi.jsp").forward(req, resp);
            System.out.println("El formulario editarNequi ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario editarNequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

/////////////////////////////////////////////////

private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        List nequi=nd.listar();
        req.setAttribute("nequi", nequi);
        nequi(req, resp);
        System.out.println("Datos listados correctamente");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

private void add(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idUsuario")!=null){
        n.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    if(req.getParameter("retiro")!=null){
        n.setRetiro(Integer.parseInt(req.getParameter("retiro")));
    }
    if(req.getParameter("saldoActual")!=null){
                        //Se utiliza para convertilo en tipo int
        n.setSaldoActual(Integer.parseInt(req.getParameter("saldoActual")));
    }
    if(req.getParameter("valorRecarga")!=null){
        n.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga")));
    }
    if(req.getParameter("estadoNequi")!=null){
        n.setEstadoNequi(true);
    }
    else{
        n.setEstadoNequi(false);
    }
    listar(req, resp);
    try {
        nd.registrar(n);
        System.out.println("Registro insertado correctamente a la tabla Nequi");
    } catch (Exception e) {
        System.out.println("Error en la inserción de un registro a la tabla Nequi "+e.getMessage().toString());
    }
}

private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idNequi")!=null){
        n.setIdUsuario(Integer.parseInt(req.getParameter("idNequi")));
    }
    if(req.getParameter("idUsuario")!=null){
        n.setIdUsuario(Integer.parseInt(req.getParameter("idUsuario")));
    }
    if(req.getParameter("retiro")!=null){
        n.setRetiro(Integer.parseInt(req.getParameter("retiro")));
    }
    if(req.getParameter("saldoActual")!=null){
                        //Se utiliza para convertilo en tipo int
        n.setSaldoActual(Integer.parseInt(req.getParameter("saldoActual")));
    }
    if(req.getParameter("valorRecarga")!=null){
        n.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga")));
    }
    if(req.getParameter("estadoNequi")!=null){
        n.setEstadoNequi(true);
    }
    else{
        n.setEstadoNequi(false);
    }
    listar(req, resp);
    try {
        nd.actualizar(n);
        System.out.println("Registro actualizado correctamente en la tabla de Nequi");
    } catch (Exception e) {
        System.out.println("Error en la actualización del registro en la tabla de Nequi "+e.getMessage().toString());
    }
}

private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    try {
        nd.eliminar(n);
        System.out.println("Se elimino correctamente");
    } catch (Exception e) {
        System.out.println("Error laeliminación del registro "+e.getMessage().toString());
    }
}

}
