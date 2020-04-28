package com.example.demo.repository;


import com.example.demo.domain.Food;
import com.example.demo.domain.Order;
import com.example.demo.domain.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StoreRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public List<Store> findByName(String name) {
        return em.createQuery("select s from Store s where s.name = :name", Store.class)
                .getResultList();
    }
    public List<Store> findStore(Store store) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Store> cq = cb.createQuery(Store.class);
        Root<Store> s = cq.from(Store.class);
        List<Predicate> criteria = new ArrayList<Predicate>();

        if (StringUtils.hasText(store.getName())) {
            Predicate info =
                    cb.equal(s.get("storeInfo"), Store.class);
            criteria.add(info);

        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Store> query =
                em.createQuery(cq).setMaxResults(100);
        return query.getResultList();
    }



}
