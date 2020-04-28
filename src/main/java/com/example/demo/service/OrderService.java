package com.example.demo.service;



import com.example.demo.domain.*;
import com.example.demo.exception.NotEnoughStockException;
import com.example.demo.repository.*;
import com.example.demo.web.Request.OrderSaveRequestDto;
import com.example.demo.web.Response.FoodListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
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
     *
     */


    /**
     * 주문완료
     */
    @Transactional
    public void saveOrderfood(OrderSaveRequestDto orderSaveRequestDto, List<Food> food, List<Integer> stock){
        Order enter = orderRepository.save(orderSaveRequestDto.toEntity());
        Order order = orderRepository.findOne(enter.getId());
        int sum = 0;
        int total =0;
        for(int k =0; k<food.size();k++) {
            Orderfood orderfood = Orderfood.createOrderfood(food.get(k), order, stock.get(k)); //List로 엮어줘야한다.
            order.addOrderFood(orderfood);
            orderfoodRepository.save(orderfood);
            sum += orderfood.getOrderprice();
        }
        if(order.getCoupon() != null) {
            order.setTotalPrice(sum);
        }
        else
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

        order.SetCancle_DeliveryStatus(DeliveryStatus.CANCEL);
        List<Long> ids = new ArrayList<>();
        for(Orderfood orderfood: order.getOrderfoods()){
            ids.add(orderfood.getId());
        }
        orderfoodRepository.deleteAllByIdInQuery(ids);
    }


}





//cascade -> 정보 다날려~
