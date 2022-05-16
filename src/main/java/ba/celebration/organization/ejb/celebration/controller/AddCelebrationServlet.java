package ba.celebration.organization.ejb.celebration.controller;

import ba.celebration.organization.ejb.celebration.entity.Celebration;
import ba.celebration.organization.ejb.celebration.service.CelebrationServiceLocal;
import ba.celebration.organization.ejb.user.entity.User;
import ba.celebration.organization.routes.Routes;
import ba.celebration.organization.user.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(name = "AddCelebrationServlet", urlPatterns = {"/addCelebration"})
public class AddCelebrationServlet extends HttpServlet {

    @Inject
    private CelebrationServiceLocal celebrationServiceLocal;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String celebrationName = request.getParameter("celebrationName");
        String celebrationDate = request.getParameter("celebrationDate");
        try {
            SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");
            Date date = format.parse(celebrationDate);
            User user = UserSession.USER.getFromSession(request);
            Celebration celebration = new Celebration();
            celebration.setCelebrationDate(date);
            celebration.setName(celebrationName);
            celebration.setUserCreator(user);
            celebrationServiceLocal.create(celebration);

        } catch (ParseException e) {
            Logger.getLogger(getClass().getName()).info(e.getMessage());
        }
        List<Celebration> celebrations = celebrationServiceLocal.findAll();
        request.setAttribute("celebrations", celebrations);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Routes.CELEBRATION);
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