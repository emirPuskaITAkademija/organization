package ba.celebration.organization.user.authentication.controller;

import ba.celebration.organization.user.authentication.model.AuthenticationModel;
import ba.celebration.organization.user.session.UserSession;
import ba.celebration.organization.ejb.user.entity.User;
import ba.celebration.organization.ejb.user.service.UserServiceLocal;
import ba.celebration.organization.routes.Routes;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AuthenticateDispatcherServlet", urlPatterns = {"/authenticate"})
public class AuthenticateDispatcherServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AuthenticationModel authenticationModel = new AuthenticationModel();
        authenticationModel.setUsername(request.getParameter("username"));
        authenticationModel.setPlainPassword(request.getParameter("password"));
        User user = userServiceLocal.login(authenticationModel);
        if (user != null) {
            UserSession.USER.addToSession(user, request);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.DASHBOARD_ACCESS);
            requestDispatcher.forward(request, response);
        } else {
            RequestDispatcher req = request.getRequestDispatcher(Routes.AUTHENTICATION);
            req.forward(request, response);
        }
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

