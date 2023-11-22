package controller;

import model.*;
import model.data.*;
import model.data.dao.*;
import org.jooq.DSLContext;

public class UsuarioController {

    public static boolean registrarUsuario(String nombre,String rut,int edad) throws ClassNotFoundException {
        DSLContext query = DBGenerator.conectarBD("Red");
        if(!UsuarioDAO.validarExistenciaUsuario(query,"rut",rut)){
            Usuario usuario= new Usuario(nombre,edad,rut);
            UsuarioDAO.agregarUsuario(query,usuario);
            DBConnector.closeConnection();
            return true;
        }
        else{
            DBConnector.closeConnection();
            return false;
        }
    }
}
