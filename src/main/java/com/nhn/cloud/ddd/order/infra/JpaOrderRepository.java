package com.nhn.cloud.ddd.order.infra;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.nhn.cloud.ddd.order.domain.Order;
import com.nhn.cloud.ddd.order.domain.OrderNo;
import com.nhn.cloud.ddd.order.domain.OrderRepository;

@Repository
public class JpaOrderRepository implements OrderRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Order> findById(OrderNo no) {
        return Optional.ofNullable(entityManager.find(Order.class, no));
    }

    // JPQL
    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int size) {
        TypedQuery<Order> query = entityManager.createQuery(
            "SELECT o "
            + "FROM Order o "
            + "WHERE o.orderer.memberId.id = :ordererId "
            + "ORDER BY o.number.number DESC",
            Order.class);

        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(size);
        return query.getResultList();
    }

    // Criteria
    // @Override
    // public List<Order> findByOrdererId(String ordererId, int startRow, int size) {
    //     CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    //     CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);
    //     Root<Order> order = criteriaQuery.from(Order.class);
    //
    //     Predicate ordererIdEqual = criteriaBuilder.equal(order.get("memberId").get("id"), ordererId);
    //     javax.persistence.criteria.Order orderNumberDesc = criteriaBuilder.desc(order.get("number").get("number"));
    //
    //     // 쿼리 생성
    //     criteriaQuery.select(order)
    //         .where(ordererIdEqual)
    //         .orderBy(orderNumberDesc);
    //
    //     return entityManager.createQuery(criteriaQuery)
    //         .getResultList();
    // }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public void delete(Order order) {
        entityManager.remove(order);
    }
}
