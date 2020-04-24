package com.example.demo.service;


import com.example.demo.repository.CategoryRepository;
import com.example.demo.web.Response.CategoryListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    @Transactional(readOnly = true)
    public List<CategoryListResponseDto> findAllDesc(){ //list
        return categoryRepository.findAllDesc().stream().map(CategoryListResponseDto::new).collect(Collectors.toList());
    }
}
