package controller;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Usuario;

import static model.data.DBGenerator.iniciarBD;

@WebServlet(name = "registroUsuarioServlet", value = "/registroUsuario")
public class RegistroUsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher respuesta = req.getRequestDispatcher("/registroUsuario.jsp");
        respuesta.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("edad").length() == 0 || req.getParameter("nombre").length() == 0 || req.getParameter("rut").length() == 0) {
            RequestDispatcher respuesta = req.getRequestDispatcher("/registroErroneo.jsp");
            respuesta.forward(req, resp);
        } else {
            try {
                iniciarBD("Red");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            String nombre = req.getParameter("nombre");
            int edad = Integer.parseInt(req.getParameter("edad"));
            String rut = req.getParameter("rut");
            Usuario usuario = new Usuario(nombre,edad,rut);
            RequestDispatcher respuesta = req.getRequestDispatcher("/RegistroValido.jsp");
            respuesta.forward(req, resp);
        }
    }

}