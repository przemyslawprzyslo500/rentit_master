/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author miszcz
 */
public class HttpSessionVerifier implements HttpSessionListener {

    private static int totalActiveSessions;
    private FacesContext context;

    public void sessionCreated(HttpSessionEvent event) {
        totalActiveSessions++;
        Date sessionCreationTime = new Date(event.getSession().getCreationTime());
        Date sessionLastAccessedTime = new Date(event.getSession().getLastAccessedTime());
        int sessionMaxInactiveInterval = event.getSession().getMaxInactiveInterval();
        Logger.getLogger(HttpSessionVerifier.class.getName()).log(Level.INFO, "HttpSessionVerifier(sessionCreated). Session: " + event.getSession().getId()
                + " createTime: " + sessionCreationTime
                + " lastAccess: " + sessionLastAccessedTime
                + " with maxInactiveInterval: " + sessionMaxInactiveInterval
                + " created.");
        Logger.getLogger(HttpSessionVerifier.class.getName()).log(Level.INFO,
                "HttpSessionVerifier(sessionDestroyed). TotalActiveSessions: " + totalActiveSessions);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        totalActiveSessions--;
        Date sessionCreationTime = new Date(event.getSession().getCreationTime());
        Date sessionLastAccessedTime = new Date(event.getSession().getLastAccessedTime());
        int sessionMaxInactiveInterval = event.getSession().getMaxInactiveInterval();

//        FacesContext.getCurrentInstance().getApplication().getNavigationHandler().
//                handleNavigation(context, null, "LoginForm");

        Logger.getLogger(HttpSessionVerifier.class.getName()).log(Level.INFO, "HttpSessionVerifier(sessionDestroyed). Session: " + event.getSession().getId()
                + " createTime: " + sessionCreationTime
                + " lastAccess: " + sessionLastAccessedTime
                + " with maxInactiveInterval: " + sessionMaxInactiveInterval
                + " destroyed.");
        Logger.getLogger(HttpSessionVerifier.class.getName()).log(Level.INFO,
                "HttpSessionVerifier(sessionDestroyed). TotalActiveSessions: " + totalActiveSessions);

    }

    private void extractUserInformation(HttpServletRequest request, String url) {

        String userAddr = request.getRemoteAddr();
        String sessionID = request.getSession().getId();
        Date sessionCreationTime = new Date(request.getSession().getCreationTime());
        Date sessionLastAccessedTime = new Date(request.getSession().getLastAccessedTime());
        int sessionMaxInactiveInterval = request.getSession().getMaxInactiveInterval();

        Logger.getLogger(HttpSessionVerifier.class.getName()).log(Level.INFO, "HttpSessionVerifier(extractUserInformation). Page"
                + "; url:" + url
                + "; sessionID:" + sessionID
                + "; created:" + sessionCreationTime
                + "; lastAccessed:" + sessionLastAccessedTime
                + "; inactiveInterval:" + sessionMaxInactiveInterval
                + "; userIp:" + userAddr
                + ";");
    }
}
