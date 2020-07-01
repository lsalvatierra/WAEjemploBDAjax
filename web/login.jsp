<%-- 
    Document   : login
    Created on : 21-may-2020, 16:37:54
    Author     : luis_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="Content/bootstrap/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/jquery/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="Scripts/bootstrap/bootstrap.js" type="text/javascript"></script>
        <script src="Scripts/jswebapp/login.js" type="text/javascript"></script>        
    </head>
    <body>
        <div class="card">
            <div class="card-header badge-danger">
                LOGIN
            </div>
            <div class="card-body">
                <form id="formlogin" method="post" action="AutenticacionController">
                    <div class="form-group">
                        <label for="txtusuario">Email address</label>
                        <input type="text" class="form-control" name="txtusuario" id="txtusuario">
                        <span id="erroremail" class="text-danger"></span>
                    </div>
                    <div class="form-group">
                        <label for="txtpassword">Password</label>
                        <input type="password" class="form-control" name="txtpassword" id="txtpassword">
                        <span id="errorpassword" class="text-danger"></span>
                    </div>
                    <button type="button" id="btnlogin" class="btn btn-danger">Ingresar</button>
                </form>
                <%
                    if (request.getAttribute("msglogin") != null) {
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <strong>Error!</strong> <%=request.getAttribute("msglogin").toString() %>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>             

                <%  }
                %>

            </div>
        </div>         
    </body>
</html>
