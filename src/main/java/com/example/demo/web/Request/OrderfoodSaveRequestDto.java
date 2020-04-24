package com.example.demo.web.Request;

import com.example.demo.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sun.text.resources.cldr.ti.FormatData_ti_ER;

@Getter
@NoArgsConstructor
public class OrderfoodSaveRequestDto {
    private int stockQuantity;
    private int orderprice;

        @Builder
        public OrderfoodSaveRequestDto(int stockQuantity ,int orderprice){
            this.stockQuantity = stockQuantity;
            this.orderprice = orderprice;
        }
        //builder로 값을 전달해준다.
        public Orderfood toEntity(){
            return Orderfood.builder()
                    .stockQuantity(stockQuantity)
                    .orderprice(orderprice)
                    .build();

        }
    }

