/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import pl.turek.liceum.rentit.model.Account;

/**
 *
 * @author miszcz
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private String userName;
    private String password;
    private Account currentUser;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        ExternalContext externalContext
                = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            request.login(userName, password);
            return "index";
        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.INFO,
                    "Failed to log in {0}", userName);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(
                    "Failed to log in");
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            facesContext.addMessage(null, facesMessage);
            return null;
        }
    }

    public String logout() {
        ExternalContext externalContext
                = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        try {
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            request.logout();
//            return "login";
            return "/login?faces-redirect=true";
        } catch (ServletException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE,
                    "Failed to logout", ex);
        }
        return null;
    }

//    public Account getCurrentUser() {
//        FacesContext fc = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = fc.getExternalContext();
//        if (externalContext.getUserPrincipal() == null) {
//            Logger.getLogger("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!current principal is null");
//        } else {
//            Integer id = Integer.parseInt(externalContext.getUserPrincipal().getName());
//            Logger.getLogger("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!LOGGED USER " + id);
//            try {
//                currentUser = getLoginService().getLoginById(id);
//            } catch (Exception ex) {
//            }
//        }
//        return currentUser;
//    }

}
