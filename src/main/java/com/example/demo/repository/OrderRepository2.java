package com.example.demo.repository;

import com.example.demo.domain.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository2 extends CrudRepository<Order, Long> {

    @Transactional
    @Modifying
    @Query("delete from Order s where s.id in :ids")
    public void deleteAllByIdInQuery(@Param("ids") List<Long> ids);

//
//    @Transactional
//    @Modifying
//    @Query("insert into orderfood values(order_id,food_id)"
//    void insertorderfood(@Param("discount") int discount, @Param("orderpice") int orderprice, @Param("stock_quantity")
//            int stock_quantity, @Param ("food_id") Long food_id, @Param("order_id") Long order_id);

}
