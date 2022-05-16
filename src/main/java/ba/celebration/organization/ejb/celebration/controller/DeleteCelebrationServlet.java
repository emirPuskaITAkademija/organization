package ba.celebration.organization.ejb.celebration.controller;

import ba.celebration.organization.ejb.celebration.entity.Celebration;
import ba.celebration.organization.ejb.celebration.service.CelebrationServiceLocal;
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
import java.util.logging.Logger;

@WebServlet(name = "DeleteCelebrationServlet", urlPatterns = {"/deleteCelebration"})
public class DeleteCelebrationServlet extends HttpServlet {

    @Inject
    private CelebrationServiceLocal celebrationServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer celebrationId = Integer.parseInt(request.getParameter("celebrationId"));
        try {
            Celebration celebration = celebrationServiceLocal.find(celebrationId);
            if (celebration != null) {
                celebrationServiceLocal.remove(celebration);

                List<Celebration> celebrations = celebrationServiceLocal.findAll();
                request.setAttribute("celebrations", celebrations);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.CELEBRATION);
                requestDispatcher.include(request, response);
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).info(e.getMessage());
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