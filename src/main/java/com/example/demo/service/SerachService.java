package com.example.demo.service;



//음식 이름 검색
//가게 이름 검색

import com.example.demo.domain.Food;
import com.example.demo.domain.Store;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerachService {

    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;

    //음식 검색
        @Transactional(readOnly = true)
        public List<Food> FoodSearch(String name){
            List<Food> foods = foodRepository.findByName(name);
            return foods;
        }

     //상점검색
    @Transactional(readOnly = true)
    public List<Store> StoreSearch(String name){
        List<Store> stores = storeRepository.findByName(name);
        return stores;
    }
}
