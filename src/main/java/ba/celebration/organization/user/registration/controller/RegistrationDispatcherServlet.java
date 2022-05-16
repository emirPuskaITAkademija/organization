package ba.celebration.organization.user.registration.controller;

import ba.celebration.organization.ejb.town.entity.Town;
import ba.celebration.organization.ejb.town.service.TownServiceLocal;
import ba.celebration.organization.routes.Routes;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RegistrationDispatcherServlet", urlPatterns = {"/registration"})
public class RegistrationDispatcherServlet extends HttpServlet {

    @Inject
    private TownServiceLocal townServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Town> towns = townServiceLocal.findAll();
        request.setAttribute("towns", towns);
        request.setAttribute("message", "");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
        requestDispatcher.include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
