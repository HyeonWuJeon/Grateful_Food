package com.example.demo.SaveRequest;


import com.example.demo.domain.*;
import com.example.demo.domain.Member;
import com.example.demo.repository.*;
import com.example.demo.service.OrderService;
import com.example.demo.web.Request.OrderSaveRequestDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.domain.Coupon.천원;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Rollback(false)
public class OrderApiControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;

//    @After
//    public void tearDown() throws Exception{
//        orderRepository.deleteAll();
//    }

    @Test
    public void order_등록된다() throws Exception{


        //멤버 한명이 음식 3개를 주문한다
        Member member = memberRepository.findOne(1L);

        System.out.println("타입확인 : " + member.getCoupon().getClass());
        //3가지 음식정보
        Food food = foodRepository.findOne(1L);
        Food food2 = foodRepository.findOne(2L);
        Food food3 = foodRepository.findOne(3L);

        List<Food> foods = new ArrayList<>();
        foods.add(food);
        foods.add(food2);
        foods.add(food3);


        OrderSaveRequestDto requestDto = OrderSaveRequestDto.builder()
                .coupon(member.getCoupon()) // 쿠폰사용유무
                .member(member)
                .build();

        List<Integer> stock = new ArrayList<>(); //구매수량
        stock.add(3);
        stock.add(1);
        stock.add(2);

        orderService.saveOrderfood(requestDto, foods, stock);






        /**
         * orderfood 세팅을 어떻게 해줄까?
         */



//
//
//        String url = "http://localhost:" + port + "/Guest/order";
//
//        //when
//
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Order> all = orderRepository.findAll();
//        assertThat(all.get(0).getStockQuantity()).isEqualTo(2000);

    }

    @Test
    public void order_취소된다() throws Exception{
        orderService.cancle(5L);

    }


    @Test
    public void 승인된다() throws Exception{
        orderService.success(5L);

    }
}
