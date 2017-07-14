/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.facade;

import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
