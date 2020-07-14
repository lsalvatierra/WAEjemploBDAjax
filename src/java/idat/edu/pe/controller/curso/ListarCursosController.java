/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.controller.curso;

import com.google.gson.Gson;
import idat.edu.pe.dao.MantCursoDAO;
import idat.edu.pe.model.Curso;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis_
 */
@WebServlet(name = "ListarCursosController", urlPatterns = {"/ListarCursosController"})
public class ListarCursosController extends HttpServlet {



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
        List<Curso> lstcursos = new MantCursoDAO().ListarCursos();
        //Contando visita.
        response.addCookie(ContadorVisita(request.getCookies()));
        request.setAttribute("lstcursos", lstcursos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaCursos.jsp");
        dispatcher.forward(request, response);        
    }

    public Cookie ContadorVisita(Cookie[] pcokies){
        String scuenta = null; 
        //obtener el valor del cookie
        Cookie[] cookies = pcokies;        
        if(cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cont.mantcurso")) {
                    scuenta = cookie.getValue();
                }
            }
        }        
        Integer contador = 1;
        if(scuenta != null){
            contador = Integer.parseInt(scuenta)+1;
        }
        Cookie coockieclient = new Cookie("cont.mantcurso", contador.toString());
        return coockieclient;
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
        Gson gson = new Gson();
        String resjson = gson.toJson(new MantCursoDAO().ListarCursos());
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(resjson);
        out.flush();
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
