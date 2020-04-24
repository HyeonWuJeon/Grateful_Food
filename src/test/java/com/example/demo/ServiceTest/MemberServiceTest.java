//package com.example.demo.ServiceTest;
//
//
//import com.example.demo.domain.*;
//import com.example.demo.domain.user.Role;
//import com.example.demo.repository.FoodRepository;
//import com.example.demo.repository.MemberRepository;
//
//import com.example.demo.service.MemberService;
//import com.example.demo.web.Request.MemberSaveRequestDto;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//import static com.example.demo.domain.Coupon.이천원;
//import static com.example.demo.domain.Coupon.천원;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.Assert.fail;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
////@Configuration
////@ComponentScan({"com.example.demo.repository", "com.example.demo.service"})
////@DataJpaTest
//public class MemberServiceTest {
//
//    @Autowired
//    MemberService  memberService;
//
//    @Autowired
//    MemberRepository memberRepository;g
//
////    @Autowired
////    private TestEntityManager testEntityManager;
////
////    @Autowired
////    private MemberService memberService;
//
//    @Test
//    public void 회원가입_Test() throws Exception {
//        String name = "현우";
//        String street = "서울";
//        String zipcode = "광진";
//        Address address = new Address(zipcode, street);
//
//        MemberSaveRequestDto memberSaveRequestDto = new MemberSaveRequestDto();
////        MemberSaveRequestDto memberSaveRequestDto = testEntityManager.persist(new MemberSaveRequestDto());
//
//        memberService.SingUp(memberSaveRequestDto.builder()
//                .name(name)
//                .email("tkawnd111@gmail.com")
//                .address(address)
//                .coupon(이천원).role(Role.GUEST)
//                .password(1234)
//                .build());
//
//        System.out.println("--------------------------");
//
////
////        assertThat(member.getCoupon()).isEqualTo(이천원);
//    }
//
////    @Test
////    public void 아이디비밀번호체크_Test() throws Exception {
////
////        String name ="정우";
////        int password = 1234;
////        String result = memberService.Check_Login(name, password);
////        assertThat(result).isEqualTo("YES");
////
////    }
//
//
//
//}
//
//    /**
//    @Test(expected = IllegalStateException.class)
//    public void Test_overlap() throws Exception {
//
//
//        List<Member> mm = memberRepository.findAll();
//        Member member = mm.get(0);
//        Member member2 = mm.get(1);
//        memberService.SingUp(member);//save
//        memberService.SingUp(member2); //save
//        fail("예외가 발생해야 한다.");
//    }
//*/
//
