package pl.turek.liceum.rentit.web.konto;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.transaction.Transactional;
import pl.turek.liceum.rentit.exception.AppBaseException;
import pl.turek.liceum.rentit.model.Account;

/**
 *
 * @author java
 */
@ManagedBean(name = "edytujKontoPageBean")
//@RequestScoped
@TransactionAttribute(TransactionAttributeType.MANDATORY)
//@Transactional
@SessionScoped
public class EdytujKontoPageBean implements Serializable{

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
