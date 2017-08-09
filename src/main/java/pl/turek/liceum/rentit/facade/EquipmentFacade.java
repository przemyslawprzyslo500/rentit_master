/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.facade;

import java.util.Collection;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.turek.liceum.rentit.model.Equipment;
import pl.turek.liceum.rentit.model.Equipment_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import pl.turek.liceum.rentit.ejb.interceptor.LoggingInterceptor;
import pl.turek.liceum.rentit.ejb.interceptor.PerformanceInterceptor;
import pl.turek.liceum.rentit.model.LicenseType;
import pl.turek.liceum.rentit.model.UsePlace;
import pl.turek.liceum.rentit.model.Reserv;

/**
 *
 * @author miszcz
 */
@Stateless
@LocalBean
@Interceptors({LoggingInterceptor.class, PerformanceInterceptor.class})
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EquipmentFacade extends AbstractFacade<Equipment> {

    @PersistenceContext(unitName = "pl.turek.liceum.rentit_RentIt_war_PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquipmentFacade() {
        super(Equipment.class);
    }

    public boolean isLicenseTypeIdEmpty(Equipment entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipment> equipment = cq.from(Equipment.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipment, entity), cb.isNotNull(equipment.get(Equipment_.licenseTypeId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public LicenseType findLicenseTypeId(Equipment entity) {
        return this.getMergedEntity(entity).getLicenseTypeId();
    }

    public boolean isUsePlaceIdEmpty(Equipment entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipment> equipment = cq.from(Equipment.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipment, entity), cb.isNotNull(equipment.get(Equipment_.usePlaceId)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

//        public Account findByName(String name) {
//        return (Account) em.createQuery("SELECT a FROM ACCOUNT a where a.login = :login")
//                .setParameter("login", name).getSingleResult();
//    }
//    public List<Equipment> findEquipmentRentable() {
//        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
//        return getEntityManager().createNamedQuery("Equipment.findEquipmentRentable")
//                .setParameter("rentPermission", "1").getResultList();
//        return em.createQuery("SELECT e FROM Equipment e WHERE e.rentPermission = :rentPermission")
//                .setParameter("rentPermission", 1).getResultList();
//        return em.createNamedQuery("Equipment.findByRentPermission").setParameter("rentPermission", 1).getResultList();
//        TypedQuery<Equipment> tq = getEntityManager().createNamedQuery("Equipment.findByRentPermission", Equipment.class);
//        TypedQuery<Equipment> tq = em.createNamedQuery("Equipment.findByRentPermission", Equipment.class);
//        tq.setParameter("rentPermission", '1');
//        return tq.getResultList();
//        return tq.setParameter("rentPermission", 1).getResultList();
//                createQuery(tq.setParameter("rentPermission", 1).getResultList());
//    }

//    public List<Equipment> findEquipmentRentable() {
//        TypedQuery<Equipment> tq = em.createNamedQuery("Equipment.findByRentPermission", Equipment.class);
//        tq.setParameter("rentPermission", "true");
//        return tq.getResultList();
//    }
//        public List<Zamowienie> znajdzZamowieniaDlaKlienta(String login) {
//        TypedQuery<Zamowienie> tq = em.createNamedQuery("Zamowienie.znajdzDlaKlienta", Zamowienie.class);
//        tq.setParameter("login", login);
//        return tq.getResultList();
//    }
    public UsePlace findUsePlaceId(Equipment entity) {
        return this.getMergedEntity(entity).getUsePlaceId();
    }

    public boolean isReservCollectionEmpty(Equipment entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Equipment> equipment = cq.from(Equipment.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(equipment, entity), cb.isNotEmpty(equipment.get(Equipment_.reservCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<Reserv> findReservCollection(Equipment entity) {
        Equipment mergedEntity = this.getMergedEntity(entity);
        Collection<Reserv> reservCollection = mergedEntity.getReservCollection();
        reservCollection.size();
        return reservCollection;
    }

}
