package com.example.demo.domain;



import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "order_id")
    private Long id;

    private int TotalPrice;



    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "member_id") //외래키생성. many에서만 생성된다.
    private Member member;


    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orderfood> orderfoods = new ArrayList<>();


    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Enumerated(EnumType.STRING)
    private Coupon coupon;;

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public void setMember(Member member) {
        this.member = member; //member값을 입력받는다
    }




    public void addOrderFood(Orderfood orderfood) {
        orderfood.setOrder(this);
        orderfoods.add(orderfood); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
    }






//필요없음
//    public void setOrderfoods(List<Orderfood> orderfood ) {
//        for(Orderfood orderfoods : orderfood){
//            addOrderFood(orderfoods);
//        }
//    }

    /**
     *  이거 주문 생성 할때 만드는 것임 만약에 필요한 경우에 새롭게 추가추가
     *  해서 넣기만 하면 ok
     */



    @Builder
    public Order(Long id,Coupon coupon, Member member) {
        this.id = id;
        SetReady_DeliveryStatus(DeliveryStatus.READY); //디폴트
        this.coupon = coupon;
        this.member =member;
    }




    public void SetReady_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }
    /**
     * 주문 후에 취소 상태를 보여준다
     */



    public void SetCancle_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }

    /**
     * 주문 가격 합을 모두 가져와 보여줍니당
     */

//    public int getTotalPrice() {
//        int totalPrice =0;
//        for(Orderfood orderfood : orderfoods) {
//            totalPrice +=orderfood.getTotalPrice();
//        }
//
//        return totalPrice;
//
//    }

}
