package controller;

import java.io.IOException;

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
            case "recargarForm":
                recargarForm(req, resp);
            break;
            case "retiroForm":
                retiroForm(req, resp);
            break;
            case "consultarForm":
                consultar(req,resp);
            break;
            case "volver":
                volver(req, resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch (a) {
            case "recargar":
                recargar(req,resp);
            break;
            case "retirar":
                retirar(req,resp);
            break;
        }
    }

    private void volver (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            System.out.println("La vista nequi ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista nequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void recargarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/recargasNequi.jsp").forward(req, resp);
            System.out.println("La vista nequi ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista nequi NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void retiroForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/sacarDineroNequi.jsp").forward(req, resp);
            System.out.println("La vista nequi ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista nequi NO ha sido abierto "+e.getMessage().toString());
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

/////////////////////////////////////////////////

    private void recargar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("valorRecarga")!=null){
                            //Se utiliza para convertilo en tipo int
            n.setValorRecarga(Integer.parseInt(req.getParameter("valorRecarga")));
        }
        if(req.getParameter("idNequi")!=null){
            n.setIdNequi(Integer.parseInt(req.getParameter("idNequi")));
        }
        dashboard(req, resp);
        try {
            nd.recargarSaldo(n);
            System.out.println("La recarga se realizo correctamente a la tabla Nequi");
        } catch (Exception e) {
            System.out.println("Error en la recarga a la tabla Nequi "+e.getMessage().toString());
        }
    }

    private void retirar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("retiro")!=null){
                            //Se utiliza para convertilo en tipo int
            n.setRetiro(Integer.parseInt(req.getParameter("retiro")));
        }
        if(req.getParameter("idNequi")!=null){
            n.setIdNequi(Integer.parseInt(req.getParameter("idNequi")));
        }
        dashboard(req, resp);
        try {
            nd.sacarPlata(n);
            System.out.println("El retiro se realizo correctamente en la tabla de Nequi");
        } catch (Exception e) {
            System.out.println("Error en el retiro de la tabla de Nequi "+e.getMessage().toString());
        }
    }

    private void consultar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.setAttribute("consulta", nd.consultarSaldo());
            req.getRequestDispatcher("views/consultarSaldoNequi.jsp").forward(req, resp);
            System.out.println("La consulta se realizo correctamente en la tabla de Nequi");
        } catch (Exception e) {
            System.out.println("Error en la consulta de la tabla de Nequi "+e.getMessage().toString());
        }
    }

}
