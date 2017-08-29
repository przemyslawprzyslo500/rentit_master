package pl.turek.liceum.rentit.controller;

import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.facade.AccountFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "accountController")
@ViewScoped
public class AccountController extends AbstractController<Account> {

    @Inject
    private AccountFacade accountFacade;
    
    private boolean isReservCollectionEmpty;

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

}
