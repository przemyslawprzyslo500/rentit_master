package pl.turek.liceum.rentit.web.konto;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.turek.liceum.rentit.ejb.endpoints.KontoEndpoint;
import pl.turek.liceum.rentit.exception.AppBaseException;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.web.utils.ContextUtils;

/**
 *
 * @author java
 */
@ManagedBean(name = "kontoSession")
@SessionScoped
public class KontoSession implements Serializable {

    @EJB
    private KontoEndpoint kontoEndpoint;

    public String resetujSesje() {
        ContextUtils.invalidateSession();
        /* Poprawne zakończenie sesji wymaga wymuszenia nowego żądania na przeglądarce, stąd metoda ta
         * prowadzi do przypadku nawigacji z elementem <redirect />.
         * UWAGA: integracja logowania typu BASIC z przeglądarką powoduje, że czasem mimo to "wylogowanie" jest nieskuteczne - 
         * powstaje nowa sesja już zalogowanego użytkownika. Dlatego bezpieczniej jest stosować uwierzytelnianie przez formularz (FORM).
         */
        return "cancelAction";
    }

    public String getMojLogin() {
        return ContextUtils.getUserName();
    }
    private Account kontoEdytuj;
    private Account kontoZmienHaslo;

    public Account getKontoZmienHaslo() {
        return kontoZmienHaslo;
    }

    public Account getKontoEdytuj() {
        return kontoEdytuj;
    }

    public KontoSession() {
    }

    public String rozpocznijZmianeHasla(Account konto) {
        this.kontoZmienHaslo = konto;
        return "changePassword";
    }

    public String pobierzKontoDoEdycji(Account Konto) {
        kontoEdytuj = kontoEndpoint.pobierzKontoDoEdycji(Konto);
        return "editAccount";
    }

    public String zapiszKontoPoEdycji(Account Konto) throws AppBaseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        kontoEndpoint.zapiszKontoPoEdycji(Konto);
        return "success";
    }

    public String zmienMojeHaslo(String nowe) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        kontoEndpoint.zmienMojeHaslo(nowe);
        return "success";
    }

    public List<Account> pobierzWszystkieKonta() {
        return kontoEndpoint.pobierzWszystkieKonta();
    }

    public Account pobierzMojeKonto() {
        return kontoEndpoint.pobierzMojeKonto();
    }
}
