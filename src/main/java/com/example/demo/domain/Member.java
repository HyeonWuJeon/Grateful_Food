package com.example.demo.domain;


import com.example.demo.domain.user.Role;
import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long id;

//        @Column(nullable = false)
        private String name;

//        @Column(nullable = false)
        private String email;
        @Column
        private String picture;

        @Column
        private int password;

        @Embedded
        private Address address;

        @Enumerated(EnumType.STRING)
        private Coupon coupon;

        @Enumerated(EnumType.STRING)
        @Column
        private Role role;

        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
        private List<Comments> comment = new ArrayList<>();

        @Builder // 값변경.
        public  Member(String name, Address address, Coupon coupon, Role role,String email, String picture,int password) {
                this.name = name;
                this.address = address;
                this.coupon = coupon;
                this.role = role;
                this.picture = picture;
                this.email = email;
                this.password = password;



        }

        public Member update_google(String name, String picture) {
                this.name = name;
                this.picture = picture;

                return this;
        }

        public Member update(int password) {
                this.password = password;

                return this;
        }

        public String getRoleKey() {
                return this.role.getKey();
        }

}
