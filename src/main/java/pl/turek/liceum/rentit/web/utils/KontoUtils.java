
package pl.turek.liceum.rentit.web.utils;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.session.HashPassword;
import static pl.turek.liceum.rentit.session.HashPassword.hashPassword;
/**
 *
 */
public class KontoUtils {
    
    /** Przepisuje do przekazanej encji dane z formularza edycji konta.
     * Uwzględnione są klasy rozszerzające Konto (Administrator, Pracownik, Klient), przy czym tylko dane występujące na formularzu sa przepisywane. Pomijane są: login, hasło, id, wersja.
     * 
     * @param zrodlo encja zawierająca dane z formularza edycji
     * @param cel encja docelowa
     */
    public static void przepiszDanePoEdycji(Account zrodlo, Account cel) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        
        if (null == zrodlo || null == cel) return;
        
        System.out.println("KontoUtils-PrzepiszDanePoEdycji_przed");
        cel.setName(zrodlo.getName());
        cel.setSurname(zrodlo.getSurname());
        cel.setEmail(zrodlo.getEmail());
        cel.setPhone(zrodlo.getPhone());
        cel.setPassword(hashPassword(zrodlo.getPassword()));
        cel.setAccountFunction(zrodlo.getAccountFunction());
        System.out.println("KontoUtils-PrzepiszDanePoEdycji_po");
    }
    
    public static String wyliczSkrotHasla(String hasloJawne){
        //TODO: wstawić algorytm skrótu hasła
//        String output = Hashing.sha256().hashString(hasloJawne, Charsets.UTF_8)
        return hasloJawne;
    }

}
