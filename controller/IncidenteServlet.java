package controller;

import dao.IncidenteDAO;
import model.Incidente;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class IncidenteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String titulo = request.getParameter("titulo");
            String descripcion = request.getParameter("descripcion");
            String severidad = request.getParameter("severidad");
            int usuarioId = Integer.parseInt(request.getParameter("usuario_id"));

            Incidente incidente = new Incidente(titulo, descripcion, severidad, usuarioId);

            IncidenteDAO dao = new IncidenteDAO();
            dao.crearIncidente(incidente);

            response.setContentType("text/plain");
            response.getWriter().write("Incidente creado correctamente");

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error: " + e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            IncidenteDAO dao = new IncidenteDAO();

            response.setContentType("text/plain");
            response.getWriter().write(dao.listarIncidentes().toString());

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error: " + e.getMessage());
        }
    }
}
