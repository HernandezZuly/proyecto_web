package controller;

import java.io.IOException;

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
            case "recargarForm":
                recargarForm(req, resp);
            break;
            case "retiroForm":
                retiroForm(req, resp);
            break;
            case "consultarForm":
                consultarForm(req, resp);
            break;
            case "daviplata":
                daviplata(req, resp);
            break;
            case "abrirForm":
                abrirForm(req,resp);
            break;
            case "editarForm":
                editarForm(req,resp);
            break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch (a) {
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

    private void recargarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/recargasDaviplata.jsp").forward(req, resp);
            System.out.println("La vista daviplata ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista daviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void retiroForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/sacarDineroDaviplata.jsp").forward(req, resp);
            System.out.println("La vista daviplata ha sido abierta");
        }catch(Exception e){
            System.out.println("La vista daviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

    private void consultarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/consultarSaldoDaviplata.jsp").forward(req, resp);
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

    private void editarForm (HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/editarDaviplata.jsp").forward(req, resp);
            System.out.println("El formulario editarDaviplata ha sido abierto");
        }catch(Exception e){
            System.out.println("El formulario editarDaviplata NO ha sido abierto "+e.getMessage().toString());
        }
    }

/////////////////////////////////////////////////


}

