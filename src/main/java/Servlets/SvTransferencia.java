package Servlets;

import DAO.MovimientoDAO;
import Movimientos.DatosSesion;
import Movimientos.Transferencia;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "SvTransferencia", urlPatterns = {"/SvTransferencia"})
public class SvTransferencia extends HttpServlet {

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
        String cuenta = request.getParameter("nocuenta");
        int CuentaDestino = Integer.parseInt(cuenta);
        
        HttpSession session = request.getSession(false);
        DatosSesion u = (DatosSesion) session.getAttribute("datosUsuario");
        Transferencia transferencia = new Transferencia(CantidadRetirar,u.getNoCuenta(),CuentaDestino);
        
        MovimientoDAO DAO = new MovimientoDAO();

        double SaldoNuevo = DAO.Transferencia(transferencia, u.getSaldo());
        
        u.setSaldo(SaldoNuevo);
        session.setAttribute("datosUsuario", u);
        
        response.sendRedirect("TransferenciaConfirmacion.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
