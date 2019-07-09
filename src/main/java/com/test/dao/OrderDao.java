package com.test.dao;

import com.test.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2019/3/21/021.
 */
@Repository
public interface OrderDao extends JpaRepository<Order,Integer> {
}
