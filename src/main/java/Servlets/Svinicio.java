package Servlets;

import DAO.MovimientoDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Movimientos.DatosSesion;


@WebServlet(name = "Svinicio", urlPatterns = {"/Svinicio"})
public class Svinicio extends HttpServlet {
    
    //private static final String URL = "jdbc:mysql://localhost:3306/banco_db?useSSL=false&serverTimezone=UTC";
    //private static final String USER = "root";
    //private static final String PASS = "";
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
            int Nocuenta = Integer.parseInt(request.getParameter("nocuenta"));
            String contraseña = request.getParameter("password");

            MovimientoDAO DAO = new MovimientoDAO();

            DatosSesion datos = DAO.Consulta(Nocuenta, contraseña);

            HttpSession session = request.getSession(true);
            session.setAttribute("datosUsuario", datos);
            RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");
            rd.forward(request, response);
        }catch(Exception e){
            response.sendRedirect("InicioSesion.jsp");
            }  
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //String Usuario = request.getParameter("Usua");
        //String Contrasena = request.getParameter("Contra");
        
        //System.out.println("Usario: "+Usuario);
        //System.out.println("Contrasena: "+Contrasena);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
