/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.model;

/**
 *
 * @author luis_
 */
public class Alumno {
    private String IdAlumno;
    private String ApeAlumno;
    private String NomAlumno;
    private String IdEspecialidad;
    private String Procedencia;
    private String NomEspecialidad;

    public Alumno() {
    }

    public Alumno(String IdAlumno, String ApeAlumno, String NomAlumno) {
        this.IdAlumno = IdAlumno;
        this.ApeAlumno = ApeAlumno;
        this.NomAlumno = NomAlumno;
    }
    
    

    public Alumno(String IdAlumno, String ApeAlumno, String NomAlumno, String IdEspecialidad, String Procedencia, String NomEspecialidad) {
        this.IdAlumno = IdAlumno;
        this.ApeAlumno = ApeAlumno;
        this.NomAlumno = NomAlumno;
        this.IdEspecialidad = IdEspecialidad;
        this.Procedencia = Procedencia;
        this.NomEspecialidad = NomEspecialidad;
    }

    
    
    public String getIdAlumno() {
        return IdAlumno;
    }

    public void setIdAlumno(String IdAlumno) {
        this.IdAlumno = IdAlumno;
    }

    public String getApeAlumno() {
        return ApeAlumno;
    }

    public void setApeAlumno(String ApeAlumno) {
        this.ApeAlumno = ApeAlumno;
    }

    public String getNomAlumno() {
        return NomAlumno;
    }

    public void setNomAlumno(String NomAlumno) {
        this.NomAlumno = NomAlumno;
    }

    public String getIdEspecialidad() {
        return IdEspecialidad;
    }

    public void setIdEspecialidad(String IdEspecialidad) {
        this.IdEspecialidad = IdEspecialidad;
    }

    public String getProcedencia() {
        return Procedencia;
    }

    public void setProcedencia(String Procedencia) {
        this.Procedencia = Procedencia;
    }

    public String getNomEspecialidad() {
        return NomEspecialidad;
    }

    public void setNomEspecialidad(String NomEspecialidad) {
        this.NomEspecialidad = NomEspecialidad;
    }
}
