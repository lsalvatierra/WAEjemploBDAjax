/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.dao;

import idat.edu.pe.bd.BDConnection;
import idat.edu.pe.idao.IMantCursoDAO;
import idat.edu.pe.model.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis_
 */
public class MantCursoDAO implements IMantCursoDAO {

    @Override
    public List<Curso> ListarCursos() {
        List<Curso> lista = new ArrayList<>();
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("{call sp_MantListarCursos}");
            while (rs.next()) {
                lista.add(
                        new Curso(rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3))
                );
            }
            rs.close();
            st.close();
            coneBD.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public boolean RegistrarCurso(Curso objCurso) {
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        Boolean rpta = false;
        try{
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_MantRegistrarCurso(?,?)}");
            pst.setString(1, objCurso.getNomcurso());
            pst.setInt(2, objCurso.getCredito());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            coneBD.Desconectar();            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rpta;        
    }

    @Override
    public boolean ActualizarCurso(Curso objCurso) {
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        Boolean rpta = false;
        try{
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_MantActualizarCurso(?,?,?)}");
            pst.setString(1, objCurso.getIdcurso());
            pst.setString(2, objCurso.getNomcurso());
            pst.setInt(3, objCurso.getCredito());
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            coneBD.Desconectar();            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rpta;        
    }

    @Override
    public boolean EliminarCurso(String idCurso) {
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        Boolean rpta = false;
        try{
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_MantEliminarCurso(?)}");
            pst.setString(1, idCurso);
            pst.execute();
            rpta = pst.getUpdateCount() > 0;
            pst.close();
            coneBD.Desconectar();            
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return rpta;        
    }

    @Override
    public Curso ObtenerCurso(String idCurso) {
        Curso objCurso = null;
        BDConnection coneBD = new BDConnection();
        Connection con = coneBD.EstablecerConexion();
        try {
            PreparedStatement pst 
                    = con.prepareStatement(
                            "{call sp_MantObtenerCursos(?)}");
            pst.setString(1, idCurso);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                objCurso = new Curso(rs.getString(1),
                                rs.getString(2),
                                rs.getInt(3));
            }
            rs.close();
            pst.close();
            coneBD.Desconectar();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return objCurso;        
    }

}
