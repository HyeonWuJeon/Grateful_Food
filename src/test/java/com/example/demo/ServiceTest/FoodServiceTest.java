//package com.example.demo.ServiceTest;
//
//
//import com.example.demo.eating.pizza.PizzaHut;
//import com.example.demo.repository.FoodRepository;
//import com.example.demo.service.FoodService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FoodServiceTest {
//
//    @Autowired
//    FoodRepository foodRepository;
//    @Autowired
//    FoodService foodService;
////
////    @Autowired
////    private TestEntityManager testEntityManager;
//
////    @Test
////    public void Find() {
////
////
////        List<Food> test = foodRepository.findAll();
////        for(Food t : test) {
////            if (t.getStore().getId() == 7) {
////                System.out.println(t.getName());
////            }
////        }
////
////        System.out.println("-----------구분선-----------");
////        List<FoodListResponseDto> foods = foodService.findOne(7);
////
////        for(FoodListResponseDto Dto : foods) {
////
////            System.out.println(Dto.getName());
////
////        }
////
////    }
//
//    /**
//     * Food & eating Joint Test
//     */
//
//    @Test
//    public void 조인확인_Join() throws Exception {
//        PizzaHut pizzaHut  = new PizzaHut();
//        pizzaHut.setHut_taste("매운맛");
//        pizzaHut.setHut_value("치즈");
//        pizzaHut.NamePrice("고구마스노우피자",12345);
//        testEntityManager.persist(pizzaHut);
//        testEntityManager.flush();
//        testEntityManager.clear();
////        assertThat(p.getName()).isEqualTo("고구마스노우피자");
////        assertThat(p.getPrice()).isEqualTo(12345);
//
//    }
//}
