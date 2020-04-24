package com.example.demo.web.Response;

import com.example.demo.domain.Coupon;
import com.example.demo.domain.Member;
import com.example.demo.domain.Order;
import com.sun.xml.bind.v2.runtime.output.C14nXmlOutput;
import lombok.Builder;
import lombok.Getter;

@Getter
public class OrderListResponseDto {
        private Long id;
        private Member membmer;
        private Coupon coupon;

        @Builder
        public OrderListResponseDto(Order entity){
            this.id = entity.getId();
            this.membmer = entity.getMember();
            this.coupon= entity.getCoupon();
        }

}
