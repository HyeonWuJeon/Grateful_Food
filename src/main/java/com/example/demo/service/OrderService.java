package com.example.demo.service;



import com.example.demo.domain.*;
import com.example.demo.exception.NotEnoughStockException;
import com.example.demo.repository.*;
import com.example.demo.web.Request.OrderSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderfoodRepository orderfoodRepository;

    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */


    /**
     * 장바구니에서 order저장
     */
    @Transactional
    public Long order(OrderSaveRequestDto orderSaveRequestDto) {
        return orderRepository.save(orderSaveRequestDto.toEntity()).getId();

    }

    //orderfood매핑하기
    @Transactional
    public void saveOrderfood(Long id, Food food){
        Order order = orderRepository.findOne(id);
        Orderfood orderfood = Orderfood.createOrderfood(food,order); //대량으로 엮어줘야한다.

        order.addOrderFood(orderfood); //이것도 사실 필요없음.
//        for(Orderfood orderfoods : orders){
//            order.addOrderFood(orderfoods);
//        }
        orderfoodRepository.save(orderfood);

    }


    /**
     * 주문취소
     */
    @Transactional
    public  void cancle(Long orderId) {
        Order order = orderRepository.findOne(orderId);
//        if(order.getStatus() == DeliveryStatus.ARRIVE) {
//            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
//                    "없습니다.");
//        }

        order.SetCancle_DeliveryStatus(DeliveryStatus.CANCEL);


        for(Orderfood orderfood : order.getOrderfoods()) {
            System.out.println("orderfood id값 : "+orderfood.getId().getClass());
            orderfoodRepository.deleteById(orderfood.getId()); //삭제
            orderfoodRepository.deleteAll();
//            orderfoodRepository.deleteById(orderfood.getId());
//            orderfoodRepository.flush();
            System.out.println("----------------------------------");
        }
    }



//    @Transactional
//    public void cancelbasketOrder(Long foodId, Long orderId) {
//
//        Order order = orderRepository.findOne(orderId);
//        Food food = foodRepository.findOne(foodId); //음식이름 ,가격
//        //주문 취소 로직
//
//        order.basket_cancel(order.getStockQuantity());
//    }

}





//cascade -> 정보 다날려~
