package com.example.demo.service;



import com.example.demo.domain.*;
import com.example.demo.domain.Order;
import com.example.demo.repository.*;
import com.example.demo.web.Request.OrderSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.domain.Coupon.천원;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final EntityManager em;


    /**
     * 주문 / 취소 / 검색 / 주문검색 로직을 담겨 있습니다.
     *
     */


    /**
     * 주문완료
     */
    @Transactional
    public void saveOrderfood(OrderSaveRequestDto orderSaveRequestDto, List<Food> food, List<Integer> stock) {
        Order enter = orderRepository.save(orderSaveRequestDto.toEntity());
        Order order = orderRepository.findOne(enter.getId());
        int sum = 0;
        int total = 0;
        for (int k = 0; k < food.size(); k++) {
            Orderfood orderfood = Orderfood.createOrderfood(food.get(k), order, stock.get(k)); //List로 엮어줘야한다.
            order.addOrderFood(orderfood);

            sum += orderfood.getOrderprice();
        }

        if (order.getCoupon() != null) {
            total = sum - order.getCoupon().getCoupon();
            order.setTotalPrice(total);
        } else {
            order.setTotalPrice(sum);
        }

        orderRepository.save(order);

    }

    /**
     * 주문취소
     */
    @Transactional
    public  void cancle(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        if(order.getStatus() == DeliveryStatus.ARRIVE) {
            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
                    "없습니다.");
        }
        orderRepository.deleteById(orderId);

    }
    /**
    * 검색
     */

    @Transactional
    public  List<Order> findAll(OrderSearch orderSearch)
    {
        String jpql = "select o from ";
        return em.createQuery("select  o from Order o join o.member m " +
                "where o.status = :status " +
                "and m.name like :name", Order.class)
                .setParameter("status", orderSearch.getDeliveryStatus())
                .setParameter("name", orderSearch.getMemberName())
                .getResultList();
    }


    /**
     * 주문목록 검색
     */

    @Transactional
    public List<Order> findOrderSearch(OrderSearch orderSearch) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        Root<Order> o = cq.from(Order.class);

        List<Predicate> criteria = new ArrayList<Predicate>();

        //?
        if (orderSearch.getDeliveryStatus() != null) {
            Predicate status =
                    cb.equal(o.get("status"), orderSearch.getDeliveryStatus());
            criteria.add(status);
        }

        if (StringUtils.hasText(orderSearch.getMemberName())) {

            Join<Order, Member> m = o.join("member", JoinType.INNER);
            Predicate name =
                    cb.like(m.<String>get("name"), "%" +
                            orderSearch.getMemberName()
                            + "%");
        }

        cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
        TypedQuery<Order> query =
                em.createQuery(cq).setMaxResults(100);
        return query.getResultList();

    }

}

