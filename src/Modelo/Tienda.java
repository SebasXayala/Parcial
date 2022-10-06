/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author juans
 */
public class Tienda {
    
    private ArrayList<Usuario> usuarios;
    
    public Tienda(){
        usuarios = new ArrayList<>();
    }
    
    public boolean agregar (Usuario usuario){
        Usuario auxilar = buscar(usuario.getCedula());
        if(auxilar != null ){
            usuarios.add(usuario);
        }
        
        return false;
    }
    
    public Usuario buscar (String cedula){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) != null && usuarios.get(i).getCedula().equals(cedula)){
                return usuarios.get(i);
            } 
        }
        return null;
    }
    
    public boolean eliminar(String cedula){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i) != null && usuarios.get(i).getCedula().equals(cedula)){
                usuarios.remove(i);
                return true;
            } 
        }
        return false;
    }
    
    public boolean modificar(Usuario usuario, String cedula){
        Usuario aux = buscar(cedula);
        
        if(aux != null){
            aux.setNombre(usuario.getNombre());
            aux.setApellido(usuario.getApellido());
            aux.setCorreoElectronico(usuario.getCorreoElectronico());
            aux.setContraseña(usuario.getContraseña());
            return true;
        }
        return false;
    } 
}
