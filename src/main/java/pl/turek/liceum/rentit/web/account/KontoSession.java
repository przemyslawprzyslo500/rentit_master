package pl.turek.liceum.rentit.web.account;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import pl.turek.liceum.rentit.ejb.endpoints.AccountEndpoint;
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
    private AccountEndpoint kontoEndpoint;

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
//    private Klient klientRejestracja;
//    private Klient klientUtworz;
//    private Pracownik pracownikUtworz;
//    private Administrator administratorUtworz;
    private Account kontoEdytuj;
    private Account kontoZmienHaslo;

    public Account getKontoZmienHaslo() {
        return kontoZmienHaslo;
    }

    public Account getKontoEdytuj() {
        return kontoEdytuj;
    }

//    public Klient getKlientRejestracja() {
//        return klientRejestracja;
//    }

    public KontoSession() {
    }

//    public String utworzKlienta(Klient klient) {
//        try {
//            klientUtworz = klient;
//            kontoEndpoint.utworzKonto(klientUtworz);
//            klientUtworz = null;
//            return "success";
//        } catch (KontoException ke) {
//            if (KontoException.KEY_DB_CONSTRAINT.equals(ke.getMessage())) {
//                ContextUtils.emitInternationalizedMessage("login", KontoException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            } else {
//                Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzKlienta wyjatku: ", ke);               
//            }
//            return null;
//        } catch (AppBaseException abe) {
//            Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzKlienta wyjatku typu: ", abe.getClass());
//            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
//                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            }
//            return null;
//        }
//    }

//    public String utworzPracownika(Pracownik pracownik) {
//        try {
//            pracownikUtworz = pracownik;
//            kontoEndpoint.utworzKonto(pracownikUtworz);
//            pracownikUtworz = null;
//            return "success";
//        } catch (KontoException ke) {
//            if (KontoException.KEY_DB_CONSTRAINT.equals(ke.getMessage())) {
//                ContextUtils.emitInternationalizedMessage("login", KontoException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            } else {
//                Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku: ", ke);               
//            }
//            return null;
//        } catch (AppBaseException abe) {
//            Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzPracownika wyjatku typu: ", abe.getClass());
//            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
//                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            }
//            return null;
//        }
//    }

//    public String utworzAdministratora(Administrator admin) {
//        try {
//            administratorUtworz = admin;
//            kontoEndpoint.utworzKonto(administratorUtworz);
//            administratorUtworz = null;
//            return "success";
//        } catch (KontoException ke) {
//            if (KontoException.KEY_DB_CONSTRAINT.equals(ke.getMessage())) {
//                ContextUtils.emitInternationalizedMessage("login", KontoException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            } else {
//                Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzAdministratora wyjatku: ", ke);               
//            }
//            return null;
//        } catch (AppBaseException abe) {
//            Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji utworzAdministratora wyjatku typu: ", abe.getClass());
//            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
//                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            }
//            return null;
//        }
//    }

//    public String potwierdzRejestracjeKlienta(Klient klient) {
//        this.klientRejestracja = klient;
//        return "confirmRegister";
//    }

    public String rozpocznijZmianeHasla(Account konto) {
        this.kontoZmienHaslo = konto;
        return "changePassword";
    }

//    public String rejestrujKlienta() {
//        try {
//            kontoEndpoint.rejestrujKlienta(klientRejestracja);
//            klientRejestracja = null;
//            return "success";
//        } catch (KontoException ke) {
//            if (KontoException.KEY_DB_CONSTRAINT.equals(ke.getMessage())) {
//                ContextUtils.emitInternationalizedMessage("login", KontoException.KEY_DB_CONSTRAINT); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            } else {
//                Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji rejestrujKlienta wyjatku: ", ke);               
//            }
//            return null;
//        } catch (AppBaseException abe) {
//            Logger.getLogger(KontoSession.class.getName()).log(Level.SEVERE, "Zgłoszenie w metodzie akcji rejestrujKlienta wyjatku typu: ", abe.getClass());
//            if (ContextUtils.isInternationalizationKeyExist(abe.getMessage())) {
//                ContextUtils.emitInternationalizedMessage(null , abe.getMessage()); //wyjątki aplikacyjne powinny przenosić jedynie klucz do internacjonalizacji
//            }
//            return null;
//        }
//    }

    public void aktywujKonto(Account Konto) {
        kontoEndpoint.aktywujKonto(Konto);
        ContextUtils.emitSuccessMessage(ListaKontPageBean.GENERAL_MSG_ID);
    }

    public void deaktywujKonto(Account Konto) {
        kontoEndpoint.deaktywujKonto(Konto);
        ContextUtils.emitSuccessMessage(ListaKontPageBean.GENERAL_MSG_ID);
    }

//    public void potwierdzKonto(Account Konto) {
//        kontoEndpoint.potwierdzKonto(Konto);
//        ContextUtils.emitSuccessMessage(ListaKontPageBean.GENERAL_MSG_ID);
//    }

    public String pobierzKontoDoEdycji(Account Konto) {
        kontoEdytuj = kontoEndpoint.pobierzKontoDoEdycji(Konto);
        return "editAccount";
    }

    public String zapiszKontoPoEdycji(Account Konto) throws AppBaseException, pl.turek.liceum.rentit.exception.AppBaseException {
        kontoEndpoint.zapiszKontoPoEdycji(Konto);
        return "success";
    }

    public String zmienHasloKonta(String haslo) {
        kontoEndpoint.zmienHaslo(kontoZmienHaslo, haslo);
        return "success";
    }

    public String zmienMojeHaslo(String stare, String nowe) {
        kontoEndpoint.zmienMojeHaslo(stare, nowe);
        return "success";
    }

    public List<Account> pobierzWszystkieKonta() {
        return kontoEndpoint.pobierzWszystkieKonta();
    }

    public List<Account> dopasujKonta(String loginWzor, String imieWzor, String nazwiskoWzor, String emailWzor) {
        return kontoEndpoint.dopasujKonta(loginWzor, imieWzor, nazwiskoWzor, emailWzor);
    }

    public Account pobierzMojeKonto() {
        return kontoEndpoint.pobierzMojeKonto();
    }
}
