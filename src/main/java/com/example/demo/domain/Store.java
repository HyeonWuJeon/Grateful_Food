package com.example.demo.domain;

import com.example.demo.eating.chicken.BBQ;
import com.example.demo.eating.chicken.KFC;
import com.example.demo.eating.korea.KimbabHeaven;
import com.example.demo.eating.korea.Kimbabhell;
import com.example.demo.eating.pizza.Domino;
import com.example.demo.eating.pizza.PizzaHut;
import com.example.demo.eating.zokbal.Gazok;
import com.example.demo.eating.zokbal.HyeonwuZok;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@Entity
/**
 * 치킨 : KFC, BBQ
 * 피자 : 도미노, 피자헛
 * 한식 : 김밥천국, 김밥지옥
 * 족발 : 가장맛있는족발, 현우네족발
 */
public class Store  {


    //디비에저장
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long id;
    @Column(name = "store_name")
    private String name;

    @Column(name = "store_tel")
    private String tel;
    @Column(name = "store_address")
    private String address; //가게주소 입력 변경사항 -> address클래스에서 직접 입력하는 변수명으로 바꿈


}
