package Servlets;

import DAO.MovimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import Movimientos.Retiro;
import Movimientos.DatosSesion;


@WebServlet(name = "SvRetiro", urlPatterns = {"/SvRetiro"})
public class SvRetiro extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String monto = request.getParameter("cantidad");
        double CantidadRetirar = Double.parseDouble(monto);
        HttpSession session = request.getSession(false);
        DatosSesion u = (DatosSesion) session.getAttribute("datosUsuario");
        Retiro retiro = new Retiro(u.getNoCuenta(),CantidadRetirar);
        
        MovimientoDAO DAO = new MovimientoDAO();

        double SaldoNuevo = DAO.Retiro(retiro, u.getSaldo());
        
        u.setSaldo(SaldoNuevo);
        session.setAttribute("datosUsuario", u);
      
      
        
        
     
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
