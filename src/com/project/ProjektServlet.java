package com.project;

import com.project.dao.ProjectDAOImpl;
import com.project.model.Projekt;
import com.project.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet
public class ProjektServlet extends HttpServlet {

    RequestDispatcher dispatcher = null;
    ProjectDAOImpl projectDAO = null;
    String action = "";

    public ProjektServlet() {
        this.projectDAO = new ProjectDAOImpl();
        this.action = "LIST";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action = request.getParameter("action");

        if (action == null) {
            action = "LIST";
        }

        switch (action) {

            case "LIST":
                listProjects(request, response);
                break;

            case "EDIT":
                getProject(request, response);
                break;

            case "DELETE":
                deleteProject(request, response);
                break;

            default:
                listProjects(request, response);
                break;

        }
    }

    private void deleteProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        if (projectDAO.delete(Integer.parseInt(id))) {
            request.setAttribute("NOTIFICATION", "Projekt usunięty!");
        }

        listProjects(request, response);
    }

    private void getProject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Projekt projekt = projectDAO.get(Integer.parseInt(id));

        request.setAttribute("projekt", projekt);

        dispatcher = request.getRequestDispatcher("projekt-form.jsp");

        dispatcher.forward(request, response);
    }

    private void listProjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Projekt> projektList = projectDAO.get();

        request.setAttribute("projektList", projektList);

        dispatcher = request.getRequestDispatcher("projekt-list.jsp");

        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        Projekt projekt = new Projekt();
        projekt.setNazwa(request.getParameter("nazwa"));
        projekt.setOpis(request.getParameter("opis"));
        projekt.setData_oddania(LocalDate.parse(request.getParameter("data_oddania")));
        projekt.setDataCzasModyfikacji(LocalDateTime.now());
        projekt.setDataCzasUtworzenia(LocalDateTime.now());

        if (id.isEmpty()) {
            if (projectDAO.save(projekt)) {
                request.setAttribute("NOTIFICATION", "Projekt dodany!");
            }

        } else {

            projekt.setProjektId(Integer.parseInt(id));
            if (projectDAO.update(projekt)) {
                request.setAttribute("NOTIFICATION", "Projekt zakutalizowany!");
            }

        }

        listProjects(request, response);
    }
}

