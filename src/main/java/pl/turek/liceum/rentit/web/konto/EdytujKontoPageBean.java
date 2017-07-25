package pl.turek.liceum.rentit.web.konto;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.turek.liceum.rentit.exception.AppBaseException;
import pl.turek.liceum.rentit.facade.AccountFacade;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.web.utils.KontoUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "edytujKontoPageBean")
@RequestScoped
public class EdytujKontoPageBean {

//    @EJB
//    private AccountFacade accountFacade;
    
//    @Resource
//    private SessionContext context;
    
    public EdytujKontoPageBean() {
    }

    @ManagedProperty(value = "#{kontoSession}")
    private KontoSession kontoSession;

    public void setKontoSession(KontoSession kontoSession) {
        this.kontoSession = kontoSession;
    }

    @PostConstruct
    private void init() {
//        konto = kontoSession.getKontoEdytuj();
        konto = kontoSession.pobierzMojeKonto();
    }

    private Account konto = new Account();

    public Account getKonto() {
        return konto;
    }

    public String zapiszKonto() throws AppBaseException {
        kontoSession.pobierzKontoDoEdycji(konto);
//        kontoSession.pobierzMojeKonto();
        return kontoSession.zapiszKontoPoEdycji(konto);
    }
//    public Account pobierzKontoDoEdycji(){
//        return kontoSession.pobierzMojeKonto();
//    }

//    public Account pobierzMojeKonto() {
//        return accountFacade.findByName(context.getCallerPrincipal().getName());
//    }
}
