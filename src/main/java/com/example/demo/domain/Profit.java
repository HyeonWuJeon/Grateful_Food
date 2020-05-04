package com.example.demo.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//병원이익
@Getter
@Entity
@Setter
@EntityListeners(AuditingEntityListener.class) //BaseTimeEntity클래스에 Auditing 기능을 포함시킨다.
public class Profit {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private int profit_tax; //수수료
    private int profit_total; //수익

    @LastModifiedDate
    private LocalDateTime modifiedDate;


}
