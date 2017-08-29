
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
        
        cel.setName(zrodlo.getName());
        cel.setSurname(zrodlo.getSurname());
        cel.setEmail(zrodlo.getEmail());
        cel.setPhone(zrodlo.getPhone());
        System.out.println("przepisz dane konta CEL:" + cel.getPassword());
        System.out.println("przepisz dane konta ZRODLO:" + zrodlo.getPassword());
        System.out.println("przepisz dane konta ZRODLO po Hash:" + hashPassword(zrodlo.getPassword()));
        if (!zrodlo.getPassword().equals(cel.getHashPassword())){
            cel.setPassword(hashPassword(zrodlo.getPassword()));
        }
        cel.setAccountFunction(zrodlo.getAccountFunction());
    }
    
    public static String wyliczSkrotHasla(String hasloJawne){
        //TODO: wstawić algorytm skrótu hasła
//        String output = Hashing.sha256().hashString(hasloJawne, Charsets.UTF_8)
        return hasloJawne;
    }

}
