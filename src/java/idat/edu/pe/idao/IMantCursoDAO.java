/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.idao;

import idat.edu.pe.model.Curso;
import java.util.List;

/**
 *
 * @author luis_
 */
public interface IMantCursoDAO {
    
    public List<Curso> ListarCursos(); 
    public boolean RegistrarCurso(Curso objCurso); 
    public boolean ActualizarCurso(Curso objCurso); 
    public boolean EliminarCurso(String idCurso);
    public Curso ObtenerCurso(String idCurso);
}
