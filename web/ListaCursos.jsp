<%-- 
    Document   : ListaCursos
    Created on : 21-may-2020, 17:57:18
    Author     : luis_
--%>

<%@page import="idat.edu.pe.model.Curso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="scriptstyle.jsp" %>        
        <script src="Scripts/jswebapp/ListaCursos.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="layout.jsp" %>        
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Listado de Cursos</h5>
                <button type="button"  class="btn btn-primary" id="btnagregar" >Registrar</button>
                <%
                    List<Curso> listCursos = (List<Curso>) request.getAttribute("lstcursos");
                %>
                <table id="tblcurso" class="table">
                    <thead>
                        <tr>
                            <th scope="col">Código</th>
                            <th scope="col">Nombre Curso</th>
                            <th scope="col">Crédito</th>
                            <th scope="col">Actualizar</th>
                            <th scope="col">Eliminar</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Curso objCurso : listCursos) {
                        %>
                        <tr>
                            <td><%=objCurso.getIdcurso()%></td>
                            <td><%=objCurso.getNomcurso()%></td>
                            <td><%=objCurso.getCredito()%></td>
                            <td><button 
                                    data-codcurso="<%=objCurso.getIdcurso()%>" 
                                    data-nomcurso="<%=objCurso.getNomcurso()%>" 
                                    data-credcurso="<%=objCurso.getCredito()%>" 
                                    class="btn btn-info btnactualizar">Actualizar</button>
                            </td>
                            <td><button
                                    data-codcurso="<%=objCurso.getIdcurso()%>"
                                    class="btn btn-danger btneliminar">Eliminar</button>
                            </td>
                        </tr>  
                        <%}
                        %>
                    </tbody>
                </table>                   
            </div>
        </div>
        <div class="modal fade" id="modalcurso" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Mantenimiento de Curso</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label for="txtcodigo" class="col-form-label">Código:</label>
                                <input type="text" readonly class="form-control" id="txtcodigo">
                            </div>
                            <div class="form-group">
                                <label for="txtnombre" class="col-form-label">Nombre:</label>
                                <input type="text" class="form-control" id="txtnombre">
                            </div>
                            <div class="form-group">
                                <label for="txtcredito" class="col-form-label">Crédito:</label>
                                <input type="text" class="form-control" id="txtcredito">
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button"  id="btnregistrarcurso" class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
