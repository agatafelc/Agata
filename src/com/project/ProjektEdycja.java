package com.project;

import com.project.model.Projekt;
import com.project.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "ProjektEdycja")
public class ProjektEdycja extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("btn-zapisz") != null) {
            EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
            Projekt projekt = new Projekt();
            projekt.setNazwa("Projekt testowy");
            projekt.setData_oddania(LocalDate.now());
            projekt.setOpis("Opis testowy");

            entityManager.getTransaction().begin();
            entityManager.persist(projekt);
            entityManager.getTransaction().commit();
            entityManager.close();
            request.setAttribute("projekt", projekt);
        }
        ServletContext context = getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_edycja.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
