package com.example.demo.repository;

import com.example.demo.domain.Orderfood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderfoodRepository extends JpaRepository<Orderfood, Long> {

}
