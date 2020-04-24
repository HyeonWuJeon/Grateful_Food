package com.example.demo.domain;

import com.example.demo.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * member 과 order => 1:n 관계 한명이 여러주문을 할 수 있다.
 * order 와 food => n:n 하나의 주문 여러개 음식, 여러개 주문 여러개음식
 * ordder : orderfood 1:n
 * food : orderfood n:1
 */
@Entity
@Getter
@Setter
@Table(name = "orderfood")
@NoArgsConstructor
public class Orderfood extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderfood_id")
    private Long id;


//    @OneToMany(mappedBy = "orderfood")
//    private List<Food> foods = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    /**
     * Order한번에 여러주문을 넣어줄 수 있다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice; //어떻게 계산할것인가
    private int stockQuantity;
    private  int discount; //어떻게 계산할것인가


    public static Orderfood createOrderfood(Food food, Order order) {
        Orderfood orderfood = new Orderfood();
        orderfood.setOrderprice(food.getPrice());
        orderfood.Orderfood_Food(food);
        orderfood.Orderfood_Order(order);


        return orderfood;

    }


    public void Orderfood_Food(Food food) {
        this.food = food;
    }

    public void Orderfood_Order(Order order){
        this.order = order;
    }





    //총가

//    public int getTotalPrice() {
//        return getOrderprice() * getCount()-getDiscount();
//    }

    /**
     * 장바구니를 control하는 함수 위의 cancel함수와 차이가있습니다.
     */



    @Builder
    public Orderfood(int stockQuantity, int orderprice) {
        this.stockQuantity=stockQuantity;
        this.orderprice = orderprice;
    }
}
