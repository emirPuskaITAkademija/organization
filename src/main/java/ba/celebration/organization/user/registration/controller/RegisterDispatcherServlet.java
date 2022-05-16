package ba.celebration.organization.user.registration.controller;

import ba.celebration.organization.user.registration.model.RegistrationModel;
import ba.celebration.organization.ejb.town.entity.Town;
import ba.celebration.organization.ejb.town.service.TownServiceLocal;
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
import java.util.List;

@WebServlet(name = "RegisterDispatcherServlet", urlPatterns = {"/register"})
public class RegisterDispatcherServlet extends HttpServlet {

    @Inject
    private UserServiceLocal userServiceLocal;

    @Inject
    private TownServiceLocal townServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistrationModel registerModel = RegistrationModel.builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .username(request.getParameter("username"))
                .plainPassword(request.getParameter("password"))
                .contact(request.getParameter("contact"))
                .email(request.getParameter("email"))
                .town(request.getParameter("town"))
                .build();
        RegistrationController controller = new RegistrationController(userServiceLocal, registerModel);
        if (controller.isValidRegistrationModel()) {
            if (controller.usernameOccupied()) {
                List<Town> towns = townServiceLocal.findAll();
                request.setAttribute("towns", towns);
                request.setAttribute("message", String.format("Username '%s' is already in use", registerModel.getUsername()));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
                requestDispatcher.include(request, response);
            } else {
                User user = userServiceLocal.register(registerModel);
                if (user != null) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.AUTHENTICATION);
                    requestDispatcher.include(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
                    requestDispatcher.include(request, response);
                }
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.REGISTRATION);
            requestDispatcher.include(request, response);
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
