package Servlets;

import DAO.MovimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(name = "SvResgistro", urlPatterns = {"/SvRegistro"})
public class SvRegistro extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       /* String nombre_1 = request.getParameter("nombr");
        String password_1 = request.getParameter("contra");
        
        if (nombre_1 == "" || password_1 == ""){
            response.sendRedirect("RegistroU.jsp");
            
        }else{
            response.sendRedirect("InicioSesion.jsp");
        }*/
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombr");
        String password = request.getParameter("contra");
        int cuenta = 1234;   
        if (nombre == "" || password == ""){
            response.sendRedirect("RegistroU.jsp");
            
        }else{
            MovimientoDAO.crear(nombre, password, cuenta);
            response.sendRedirect("InicioSesion.jsp");
        }
    }
        
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
