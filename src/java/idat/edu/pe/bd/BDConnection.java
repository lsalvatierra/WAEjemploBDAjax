/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idat.edu.pe.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luis_
 */
public class BDConnection {
    
   /* private String url ="jdbc:sqlserver://DESKTOP-VIT2DB8:1433;databaseName=bdnotas";
    private String login ="sa";
    private String password ="lsalvat1989";
    private String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";*/
    private final String bd = "bdnotas";
    private final String url ="jdbc:mysql://localhost:3306/"+bd;
    private final String login = "root";
    private final String password = "admin";  
    private final String driver ="com.mysql.jdbc.Driver";   
    Connection coneBD = null;

    public BDConnection() {
    }
    public Connection EstablecerConexion(){
        try{
            Class.forName(driver);
            coneBD = DriverManager.getConnection(url, login, password);
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return coneBD;
    }
    public void Desconectar(){
        try{
            coneBD.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
