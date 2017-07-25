package pl.turek.liceum.rentit.controller;

import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.model.Reserv;
import java.util.Collection;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import pl.turek.liceum.rentit.facade.AccountFacade;
import pl.turek.liceum.rentit.controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named(value = "accountController")
@ViewScoped
public class AccountController extends AbstractController<Account> {

    @EJB
    private AccountFacade accountFacade;
    
    @Resource
    SessionContext context;

//    @Inject
//    private MobilePageController mobilePageController;

//    @Resource
//    private AccountFacade accountFacade;
    // Flags to indicate if child collections are empty
    private boolean isReservCollectionEmpty;

    private Account myAccount;

    public Account getMyAccount() {
        String name = context.getCallerPrincipal().getName();
        if (myAccount != null) {
            AccountFacade ejbFacade = (AccountFacade) this.getFacade();
            myAccount = ejbFacade.znajdzLogin(name);
        }
        return myAccount;
    }

    public Account pobierzMojeKonto() {
        return accountFacade.findByName(context.getCallerPrincipal().getName());
    }

    public AccountController() {
        // Inform the Abstract parent controller of the concrete Account Entity
        super(Account.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsReservCollectionEmpty();
    }

    public boolean getIsReservCollectionEmpty() {
        return this.isReservCollectionEmpty;
    }

    private void setIsReservCollectionEmpty() {
        Account selected = this.getSelected();
        if (selected != null) {
            AccountFacade ejbFacade = (AccountFacade) this.getFacade();
            this.isReservCollectionEmpty = ejbFacade.isReservCollectionEmpty(selected);
        } else {
            this.isReservCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Reserv entities that are
     * retrieved from Account and returns the navigation outcome.
     *
     * @return navigation outcome for Reserv page
     */
//    public String navigateReservCollection() {
//        Account selected = this.getSelected();
//        if (selected != null) {
//            AccountFacade ejbFacade = (AccountFacade) this.getFacade();
//            Collection<Reserv> selectedReservCollection = ejbFacade.findReservCollection(selected);
//            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Reserv_items", selectedReservCollection);
//        }
//        return this.mobilePageController.getMobilePagesPrefix() + "/app/reserv/index";
//    }

}
