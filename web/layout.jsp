<%-- 
    Document   : layout
    Created on : 13-may-2020, 19:33:16
    Author     : luis_
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Listados
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <!--<a class="dropdown-item" href="ListarAlumnosController">Alumnos</a>-->
                    <a class="dropdown-item" href="ContadorVisitasController">Visitas</a>
                    <a class="dropdown-item" href="NotaAlumnoController">Cursos Matrículados</a>
                </div>
            </li> 
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Mantenimientos
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="ListarCursosController">Registrar Curso</a>
                    <a class="dropdown-item" href="NotaCursoAlumnoController">Reporte de notas x Alumno</a>
                </div>
            </li>                    
        </ul>
        <form class="form-inline my-2 my-lg-0">                    
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Cerrar Sesión</button>
        </form>                
    </div>
</nav>       

