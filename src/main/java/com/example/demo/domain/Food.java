package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Ftype")
@Getter
@Embeddable
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Long id;

    protected String name;

    public int price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Food(){

    }
   public void NamePrice(String name, int price){
       this.name = name;
       this.price = price;
   }


}