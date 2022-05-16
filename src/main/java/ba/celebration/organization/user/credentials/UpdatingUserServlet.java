package ba.celebration.organization.user.credentials;

import ba.celebration.organization.ejb.town.entity.Town;
import ba.celebration.organization.ejb.town.service.TownServiceLocal;
import ba.celebration.organization.routes.Routes;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdatingUserServlet", value = "/updatingUserAccount")
public class UpdatingUserServlet extends HttpServlet {
    @Inject
    private TownServiceLocal townServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Town> towns = townServiceLocal.findAll();
        request.setAttribute("townList", towns);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.UPDATE_CREDENTIAL);
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
