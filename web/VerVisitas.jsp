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

        <div class="alert alert-primary" role="alert">
            Visitas de reporte: <%=request.getAttribute("contrepalumno").toString() %>
        </div>
        <div class="alert alert-secondary" role="alert">
            Visitas al mantenimiento de curso: <%=request.getAttribute("contmantcurso").toString() %>
        </div>

    </body>
</html>
