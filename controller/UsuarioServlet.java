package controller;

import dao.UsuarioDAO;
import model.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = request.getParameter("nombre");
            String email = request.getParameter("email");
            String rol = request.getParameter("rol");

            Usuario usuario = new Usuario(nombre, email, rol);

            UsuarioDAO dao = new UsuarioDAO();
            dao.crearUsuario(usuario);

            response.getWriter().write("Usuario creado correctamente");

        } catch (Exception e) {
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
