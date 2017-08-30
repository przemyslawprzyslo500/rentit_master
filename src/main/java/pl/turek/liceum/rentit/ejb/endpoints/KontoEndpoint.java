package pl.turek.liceum.rentit.ejb.endpoints;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.*;
import pl.turek.liceum.rentit.exception.AppBaseException;
import pl.turek.liceum.rentit.facade.AccountFacade;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.web.utils.KontoUtils;

/**
 *
 * @author java
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class KontoEndpoint extends AbstractEndpoint implements SessionSynchronization {

    @EJB
    private AccountFacade kontoFacade;

    @Resource
    SessionContext sctx;

    private Account kontoStan;

    public Account pobierzMojeKonto() {
        return kontoFacade.znajdzLogin(sctx.getCallerPrincipal().getName());
    }

    public List<Account> pobierzWszystkieKonta() {
        return kontoFacade.findAll();
    }

    public Account znajdzLogin(String login) {
        return kontoFacade.znajdzLogin(login);
    }

    public Account pobierzKontoDoEdycji(Account konto) {
        kontoStan = znajdzLogin(konto.getLogin());
        return kontoStan;
    }

    public void zapiszKontoPoEdycji(Account konto) throws AppBaseException, NoSuchAlgorithmException, UnsupportedEncodingException {
        if (null == kontoStan) {
            throw new IllegalArgumentException("Brak wczytanego konta do modyfikacji");
        }
        if (!kontoStan.equals(konto)) {
            throw new IllegalArgumentException("Modyfikowane konto niezgodne z wczytanym");
        }
        KontoUtils.przepiszDanePoEdycji(konto, kontoStan);
        kontoFacade.edit(kontoStan);
        kontoStan = null;
    }

    public void zmienMojeHaslo(String nowe) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        Account mojeKonto = pobierzMojeKonto();
        mojeKonto.setHashPassword(nowe);
    }
}
