package pl.turek.liceum.rentit.web.konto;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.web.utils.ContextUtils;
import pl.turek.liceum.rentit.web.utils.KontoUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "zmienMojeHasloPageBean")
@RequestScoped
public class ZmienMojeHasloPageBean {
    
    public ZmienMojeHasloPageBean() {
    }
    
    @ManagedProperty(value="#{kontoSession}")
    private KontoSession kontoSession;

    public void setKontoSession(KontoSession kontoSession) {
        this.kontoSession = kontoSession;
    }
    
    private Account konto = new Account();

    public Account getKonto() {
        return konto;
    }
        
//    public String stareHaslo = "";

//    public String getStareHaslo() {
//        return stareHaslo;
//    }

//    public void setStareHaslo(String stareHaslo) {
//        this.stareHaslo = stareHaslo;
//    }
    
    public String zmienHaslo() {
//        if (!(hasloPowtorz.equals(konto.getPassword()))){
//            ContextUtils.emitInternationalizedMessage("zmienMojeHasloForm:passwordRepeat", "passwords.not.matching");
//            return null;
//        }
            
        try {
            return kontoSession.zmienMojeHaslo(konto.getPassword());
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ZmienMojeHasloPageBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ZmienMojeHasloPageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
