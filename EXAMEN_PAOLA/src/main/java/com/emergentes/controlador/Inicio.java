package com.emergentes.controlador;

import com.emergentes.dao.EstudianteDAO;
import com.emergentes.dao.EstudianteDAOoperation;
import com.emergentes.modelo.Estudiante;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EstudianteDAO dao = new EstudianteDAOoperation();
            int id;
            Estudiante estudiante = new Estudiante();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";

            switch (action) {
                case "add":
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    estudiante = dao.getById(id);
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("frmestudiante.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/Inicio");
                    break;
                case "view":
                default:
                    List<Estudiante> lista = dao.getAll();
                    request.setAttribute("estudiantes", lista);
                    request.getRequestDispatcher("Index.jsp").forward(request, response);
                    break;
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombres = request.getParameter("nombre");
        String apellidos = request.getParameter("apellido");
        String seminario = request.getParameter("seminario");
        int confirmado = Integer.parseInt(request.getParameter("confirmado"));
        String fecha = request.getParameter("fecha");

        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        estudiante.setNombres(nombres);
        estudiante.setApellidos(apellidos);
        estudiante.setSeminario(seminario);
        estudiante.setConfirmado(confirmado);
        estudiante.setFecha(fecha);

        try {
            EstudianteDAO dao = new EstudianteDAOoperation();
            if (id == 0) {
                dao.insert(estudiante);
            } else {
                dao.update(estudiante);
            }
            response.sendRedirect(request.getContextPath() + "/Inicio");
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
