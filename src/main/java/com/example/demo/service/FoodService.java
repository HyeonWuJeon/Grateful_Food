package com.example.demo.service;




import com.example.demo.domain.Comments;
import com.example.demo.domain.Food;
import com.example.demo.domain.Store;
import com.example.demo.repository.FoodRepository;

import com.example.demo.repository.StoreRepository;
import com.example.demo.web.Response.CommentResponseDto;
import com.example.demo.web.Response.FoodListResponseDto;
import com.example.demo.web.Response.StoreListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public List<FoodListResponseDto> findOne(int id) {
        List<Food> entity = foodRepository.findAll();
        List<Food> result_entity = new ArrayList<>();
        for(Food s : entity){
            if(s.getStore().getId() ==id){
                result_entity.add(s);
            }
        }
        return result_entity.stream().map(FoodListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StoreListResponseDto findStore(int id) {
        List<Food> entity = foodRepository.findAll();
        Store store = null;
        for (Food s : entity) {
            if (s.getStore().getId() == id) {
                store = s.getStore();
            }
        }
        return new StoreListResponseDto(store);
    }

    //    //띄우기
    public FoodListResponseDto findById(Long id){
        Food entity = foodRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("수량이 없습니다. id="+ id));

        return new FoodListResponseDto(entity);
    }

}

//    @Transactional(readOnly = true)
//    public List<Food> findtest(Long id){
//
//        List<Food> foods = foodRepository.findAll();
//
//    }

//
//
//
//
//
//    /**
//     *  필요없음
//     * @return
//
//    public List<Food> findFoods() {
//        return foodRepository.findAll(); //푸드정보
//    }
//
//
//    @Transactional(readOnly =true)
//    public Food findOne(Long foodId) {
//        return foodRepository.findOne(foodId);
//    }
//
//    @Transactional
//    public Long SingUp(Food food) {
//        foodRepository.save(food);
//        return food.getId();
//    }
//     */
//}
//
//
