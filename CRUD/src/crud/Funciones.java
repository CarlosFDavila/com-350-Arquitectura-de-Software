/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HP
 */
public class Funciones {
    String apellidos,nombres,ci,genero;
    String fecha;
    
    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection conndbc = null;

    Funciones(String apellidos,String nombres,String ci,String fecha,String genero){
        this.apellidos = apellidos;
        this.ci = ci;
        this.fecha = fecha;
        this.genero = genero;
    }
/////////////////////////////////////////////////////////////////////////////////////    
    public void insertar() throws SQLException{
        dbconexion dbc = new dbconexion();
        String sql ="INSERT INTO usuarios (Apellidos,Nombres,CI,Fecha_Nacimiento,Genero)"
                    +"VALUES('"+apellidos+"','"+nombres+"','"+ci+"',"+fecha+",'"+genero+"')";
        Statement statement = conndbc.createStatement ();
        statement.executeUpdate (sql);
    }
    
    public void eliminar() throws SQLException{
        dbconexion dbc = new dbconexion();
        String sql = "DELETE FROM Usuarios WHERE CI = "+ci+"";
        Statement statement = conndbc.createStatement ();
        statement.executeQuery (sql);
    }
    
    public void actualizar() throws SQLException{
        dbconexion dbc = new dbconexion();
        String sql ="UPDATE Usuarios set Apellidos='"+apellidos+"',Nombres,='"+nombres+"',Fecha_Nacimiento='"+fecha+"',Genero='"+genero+"' "
                     + "  WHERE CI = '"+ci+"'";
        Statement statement = conndbc.createStatement ();
        statement.executeUpdate (sql);
    }
    
    public void buscar() throws SQLException{
        dbconexion dbc = new dbconexion();
        String sql ="SELECT Apellidos,Nombres,CI,Fecha_Nacimiento,Genero FROM Usuarios WHERE CI ='"+ci+"'";
        pst = conndbc.prepareStatement(sql);
        rst = pst.executeQuery();
    }
}
