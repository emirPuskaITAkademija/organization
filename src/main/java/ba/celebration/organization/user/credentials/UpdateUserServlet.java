package ba.celebration.organization.user.credentials;

import ba.celebration.organization.ejb.user.entity.User;
import ba.celebration.organization.ejb.user.service.UserServiceLocal;
import ba.celebration.organization.routes.Routes;
import ba.celebration.organization.user.registration.controller.RegistrationController;
import ba.celebration.organization.user.registration.model.RegistrationModel;
import ba.celebration.organization.user.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUserAccount")
public class UpdateUserServlet extends HttpServlet {
    @Inject
    private UserServiceLocal userServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RegistrationModel registerModel = RegistrationModel
                .builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .username(request.getParameter("username"))
                .plainPassword(request.getParameter("password"))
                .contact(request.getParameter("contact"))
                .email(request.getParameter("email"))
                .town(request.getParameter("town"))
                .build();
        registerModel.setUsername( UserSession.USER.getFromSession(request).getUsername());
        RegistrationController controller = new RegistrationController(userServiceLocal, registerModel);

        if (controller.isValidRegistrationModel()) {
            User user = userServiceLocal.update(registerModel);
            RequestDispatcher req = request.getRequestDispatcher(Routes.DASHBOARD_ACCESS);
            req.include(request, response);
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
