/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Conexion;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author juans
 */
public class Gestion {
     Conexion conexion = new Conexion();

    public Gestion() {

    }

    public boolean guardar(String nombre, String apellido, String cedula, String correoElectronico, String contraseña) {
        Usuario usuario = new Usuario(nombre, apellido, cedula, correoElectronico, contraseña);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("insert into usuario(nombre, apellido, cedula, correoElectronico, contraseña) "
                + "values('" + usuario.getNombre() + "','" +
                usuario.getApellido() + "','" +
                usuario.getCedula() + "'," +
                usuario.getCorreoElectronico() + "'," +
                usuario.getContraseña()+")");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    public List<String> buscar(String cedula) {
        
        List<String> temp = new ArrayList<String>();
        
        conexion.conectar();

        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select cedula,nombre,apellido,"
                            + "correoElectronico,contraseña from usuario where "
                            + "cedula='" + cedula + "'"));//consulta        

            if (conexion.getResultadoDB().next()) {
                temp.add(conexion.getResultadoDB().getString("cedula"));
                temp.add(conexion.getResultadoDB().getString("nombre"));
                temp.add(conexion.getResultadoDB().getString("apellido"));
                temp.add(conexion.getResultadoDB().getInt("correoElectronico")+"");
                temp.add(conexion.getResultadoDB().getString("Contraseña"));
            }
            conexion.desconectar();//se desconecta de la base de datos                
        } catch (SQLException ex) {            
            Logger.getLogger(Gestion.class.getName())
                    .log(Level.SEVERE, null, ex);
            conexion.desconectar();//se desconecta de la base de datos
        }
        return temp;
    }

    public boolean modificar(String nombre, String apellido, String cedula, String correoElectronico, String contraseña) {
        Usuario usuario = new Usuario(nombre, apellido, cedula, correoElectronico, contraseña);
        conexion.conectar();
        try {
            conexion.getSentenciaSQL().execute
        ("update usuario set nombre='" + usuario.getNombre() + "',apellido='" + 
                usuario.getApellido() + "'," + "contraseña=" + 
                usuario.getContraseña()+ " where cedula='" + 
                usuario.getCedula()+"'");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    public boolean eliminar(String cedula) {

        conexion.conectar();

        try {
            conexion.getSentenciaSQL().execute
        ("delete from usuario where cedula='" + cedula+"'");//consulta
            conexion.desconectar();//se desconecta de la base de datos          
            return true;
        } catch (SQLException ex) {
            conexion.desconectar();//se desconecta de la base de datos          
            return false;
        }
    }

    public DefaultTableModel listar() {
        DefaultTableModel temporal;
        String nombreColumnas[] = {"Cedula", "Nombre", "Apellido", "CorreoElectronico"};
        temporal = new DefaultTableModel(
                new Object[][]{}, nombreColumnas);
        conexion.conectar();
        try {
            conexion.setResultadoDB(conexion.getSentenciaSQL().
                    executeQuery("select cedula,nombre,apellido,"
                            + "edad from usuario order by cedula"));//consulta        
            while (conexion.getResultadoDB().next()) {
                temporal.addRow(new Object[]{
                    conexion.getResultadoDB().getString("cedula"),
                    conexion.getResultadoDB().getString("nombre"),
                    conexion.getResultadoDB().getString("apellido"),
                    conexion.getResultadoDB().getInt("correoElectronico")});
            }
            conexion.desconectar();//se desconecta de la base de datos                
        } catch (SQLException ex) {            
            Logger.getLogger(Gestion.class.getName()).
                    log(Level.SEVERE, null, ex);
            conexion.desconectar();//se desconecta de la base de datos
        }

        return temporal;

    }

    
    
}
