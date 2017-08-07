/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author miszcz
 */
@ManagedBean
public class RentItDate implements Serializable {

    private Date startDate, endDate;

    public Date getStartDate() {
        return (startDate);
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return (endDate);
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Returns a String representing the starting date, in a form similar to
     * "Tuesday, November 13, 2013". For use in results page.
     * @return 
     */
    public String getStartDay() {
        return (DateUtils.formatDay(startDate));
    }

    /**
     * Returns a String representing the ending date, in a form similar to
     * "Wednesday, November 2, 2013". For use in results page.
     */
    public String getEndDay() {
        return (DateUtils.formatDay(endDate));
    }

    public String register() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (!startDate.before(endDate)) {
            endDate = null;
            FacesMessage errorMessage
                    = new FacesMessage("End date must be after start date");
            errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, errorMessage);
            return (null);
        } else {
            return ("show-dates");
        }
    }
}
