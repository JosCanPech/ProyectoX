package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author josue
 */
@WebServlet(name = "CerrarSesion", urlPatterns = {"/CerrarSesion"})
public class SvCerrarSesion extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //desconmentar cuando se vaya a usarMovimientoDao.actualizarFinalizar();
        //aquí se debe destruir la sesion
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
