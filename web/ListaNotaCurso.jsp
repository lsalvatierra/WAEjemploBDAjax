<%-- 
    Document   : ListaNotaCurso
    Created on : 01-jul-2020, 17:11:32
    Author     : luis_
--%>

<%@page import="idat.edu.pe.model.NotaAlumno"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="scriptstyle.jsp" %>           
    </head>
    <body>
        <%@include file="layout.jsp" %>     
 <div class="card">
            <div class="card-body">
                <h5 class="card-title">Listado de Cursos</h5>
                <%
                    List<NotaAlumno> listnota = (List<NotaAlumno>) request.getAttribute("lstnotacurso");
                %>
                <table id="tblcurso" class="table">
                    <thead>
                        <tr>
                            <th scope="col">Nombre Curso</th>
                            <th scope="col">Crédito</th>
                            <th scope="col">Exa.Parcial</th>
                            <th scope="col">Exa.Final</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (NotaAlumno objCurso : listnota) {
                        %>
                        <tr>
                            <td><%=objCurso.getNomcurso()%></td>
                            <td><%=objCurso.getCredito()%></td>
                            <td><%=objCurso.getExaparcial()%></td>
                            <td><%=objCurso.getExafinal()%></td>                            
         
                        </tr>  
                        <%}
                        %>
                    </tbody>
                </table>                   
            </div>
        </div>        
    </body>
</html>
