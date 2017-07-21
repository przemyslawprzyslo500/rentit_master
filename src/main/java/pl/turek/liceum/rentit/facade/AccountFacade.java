/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.facade;

import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import pl.turek.liceum.rentit.model.Account;
import pl.turek.liceum.rentit.model.Account_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pl.turek.liceum.rentit.model.Reserv;

/**
 *
 * @author miszcz
 */
@Stateless
@RolesAllowed("admin")
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "pl.turek.liceum.rentit_RentIt_war_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Account findByName(String name) {
        return (Account) em.createQuery("SELECT a FROM ACCOUNT a where a.login = :login")
                .setParameter("login", name).getSingleResult();
    }

//    public Account znajdzLogin(String login) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Konto> query = cb.createQuery(Konto.class);
//        Root<Konto> from = query.from(Konto.class);
//        query = query.select(from);
//        query = query.where(cb.equal(from.get(Konto_.login), login));
//        TypedQuery<Konto> tq = em.createQuery(query);
//        return tq.getSingleResult();
//    }

//    private Account getCurrentAccount() {
//        Account u = null;
//        FacesContext fc = FacesContext.getCurrentInstance();
//        ExternalContext externalContext = fc.getExternalContext();
//        if (externalContext.getUserPrincipal() == null) {
//            System.out.println("current principal is null");
//        } else {
//            Long id = Long.parseLong(externalContext.getUserPrincipal().getName());
//            try {
//                u = UserLocalServiceUtil.getUserById(id);
//            } catch (PortalException ex) {
//                Logger.getLogger(mybean.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (SystemException ex) {
//                Logger.getLogger(mybean.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return u;
//    }
    public AccountFacade() {
        super(Account.class);
    }

    public boolean isReservCollectionEmpty(Account entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Account> account = cq.from(Account.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(account, entity), cb.isNotEmpty(account.get(Account_.reservCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Reserv> findReservCollection(Account entity) {
        Account mergedEntity = this.getMergedEntity(entity);
        Collection<Reserv> reservCollection = mergedEntity.getReservCollection();
        reservCollection.size();
        return reservCollection;
    }

}
