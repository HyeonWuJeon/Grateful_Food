package com.example.demo.web.Controller;

import com.example.demo.domain.*;
import com.example.demo.service.OrderService;
import com.example.demo.web.Request.OrderSaveRequestDto;
import com.example.demo.web.Request.OrderfoodSaveRequestDto;
import com.example.demo.web.Response.FoodListResponseDto;
import com.example.demo.web.Response.OrderListResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderApiController {
    private final OrderService orderService;



    @PostMapping("/api/guest/order") //주문정보저장
    public String save(@RequestBody OrderSaveRequestDto requestDto, List<Food> foods, List<Integer> stock){

        orderService.saveOrderfood(requestDto, foods,  stock); //수량, 가격, 음식정보 join

        return "YES";
    }

    @PostMapping("/api/guest/ordercancle") //주문정보취소
    public String cancle(@RequestBody OrderListResponseDto orderListResponseDto){
        orderService.cancle(orderListResponseDto.getId());

        return "NO";
    }


//
//    //cancle 을 어떻게 처리해줄가?
//    @PostMapping("/api/Order/Cancle") // 취소
//    public void Cancle(@RequestBody Order order){
//        orderService.cancelOrder(order.getId());
//    }

}

/**
 *
 * Food class 맴버와 연관관계 x
 *
 */