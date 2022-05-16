package ba.celebration.organization.user.session;

import ba.celebration.organization.ejb.user.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Logger;

public enum UserSession {
    USER("SESSION_KEY");

    private String sessionKey;

    private UserSession(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void addToSession(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute(sessionKey) == null) {
            session.setAttribute(sessionKey, user);
        }
    }

    public User getFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute(sessionKey);
    }

    public void invalidateSession(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect("register.jsp");
        } catch (IOException ex) {
            Logger.getLogger(UserSession.class.getName()).info(ex.getMessage());
        }
    }
}
