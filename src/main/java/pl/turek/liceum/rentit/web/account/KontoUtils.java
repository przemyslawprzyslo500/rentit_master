package pl.turek.liceum.rentit.web.account;

import pl.turek.liceum.rentit.model.Account;

/**
 *
 */
public class KontoUtils {

    /**
     *
     * @param konto
     * @return
     */
//    public static boolean isAdministrator(Konto konto) {
//        return (konto instanceof Administrator);
//    }

    /**
     *
     * @param konto
     * @return
     */
//    public static boolean isPracownik(Konto konto) {
//        return (konto instanceof Pracownik);
//    }
    /**
     *
     * @param konto
     * @return
     */
//    public static boolean isKlient(Konto konto) {
//        return (konto instanceof Klient);
//    }
    /**
     * Przepisuje do przekazanej encji dane z formularza edycji konta.
     * Uwzględnione są klasy rozszerzające Konto (Administrator, Pracownik,
     * Klient), przy czym tylko dane występujące na formularzu sa przepisywane.
     * Pomijane są: login, hasło, id, wersja.
     *
     * @param zrodlo encja zawierająca dane z formularza edycji
     * @param cel encja docelowa
     */
    public static void przepiszDanePoEdycji(Account zrodlo, Account cel) {

        if (null == zrodlo || null == cel) {
            return;
        }

        cel.setLogin(zrodlo.getLogin());
        cel.setName(zrodlo.getName());
        cel.setSurname(zrodlo.getSurname());
        cel.setEmail(zrodlo.getEmail());
        cel.setPassword(zrodlo.getPassword());
        cel.setPhone(zrodlo.getPhone());

    }

    public static String wyliczSkrotHasla(String hasloJawne) {
        //TODO: wstawić algorytm skrótu hasła
        return hasloJawne;
    }

}
