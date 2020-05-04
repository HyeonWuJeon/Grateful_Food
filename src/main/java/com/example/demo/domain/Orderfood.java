package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


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

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice;
    private int stockQuantity;
    private  int discount; //어떻게 계산할것인가


    public static Orderfood createOrderfood(Food food, Order order, int stock) {
        Orderfood orderfood = new Orderfood();
        orderfood.setStockQuantity(stock);
        orderfood.Orderfood_Order(order);

        orderfood.Orderfood_Food(food);
        orderfood.setOrderprice(food.getPrice());

        return orderfood;

    }


    public void Orderfood_Food(Food food) {
        this.food = food;
    }

    public void Orderfood_Order(Order order){
        this.order = order;
    }


    /**
     * 장바구니를 control하는 함수 위의 cancel함수와 차이가있습니다.
     */



    @Builder
    public Orderfood(Food food,int stockQuantity, int orderprice) {
        this.food = food;
        this.stockQuantity=stockQuantity;
        this.orderprice = orderprice;
    }
}
