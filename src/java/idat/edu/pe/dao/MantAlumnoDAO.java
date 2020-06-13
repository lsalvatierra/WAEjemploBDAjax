/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.dao;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.idao.IMantAlumnoDAO;
import idat.edu.pe.model.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class MantAlumnoDAO implements IMantAlumnoDAO {

    @Override
    public List<Alumno> ListarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        BDConnection coneBD = new BDConnection();
       Connection con = coneBD.EstablecerConexion();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("{call sp_MantListarAlumno}");
            while(rs.next()){
                lista.add(
                   new Alumno(rs.getString(1), 
                           rs.getString(2), 
                           rs.getString(3), 
                           rs.getString(4), 
                           rs.getString(6), 
                           rs.getString(5))
                );            
            }
            rs.close();
            st.close();
            coneBD.Desconectar();            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
}
