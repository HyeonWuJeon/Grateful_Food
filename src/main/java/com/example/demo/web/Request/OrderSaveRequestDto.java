package com.example.demo.web.Request;

import com.example.demo.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {

    private Long id;
    private DeliveryStatus status; //ready
    private  Coupon coupon;
    private Member member;

    @Builder
    //값 등록이 필요없다.
    public OrderSaveRequestDto(Long id,DeliveryStatus status, Coupon coupon, Member member){
        this.id = id;
        this.coupon = coupon;
        this.status = status; //ready
        this.member = member;

    }


    //builder로 값을 전달해준다.
    public Order toEntity(){
        return Order.builder()
                .id(id)
                .coupon(coupon)
                .member(member)
                .build();
    }
}
