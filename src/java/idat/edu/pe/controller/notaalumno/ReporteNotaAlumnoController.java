/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.controller.notaalumno;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.model.Alumno;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


/**
 *
 * @author luis_
 */
@WebServlet(name = "ReporteNotaAlumnoController", urlPatterns = {"/ReporteNotaAlumnoController"})
public class ReporteNotaAlumnoController extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idalumno = request.getParameter("idalumno");
        File reporte = new File(request.getServletContext().getRealPath("reportenotas.jasper"));
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("par_idalumno", idalumno);
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        try {
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametros, con);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.flush();
            outputStream.close();
            
        } catch (JRException ex) {
            Logger.getLogger(ReporteNotaAlumnoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
