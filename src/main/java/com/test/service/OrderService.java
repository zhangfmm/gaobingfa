package com.test.service;/**
 * Created by Administrator on 2019/3/21/021.
 */

import com.test.dao.OrderDao;
import com.test.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName OrderService
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02115:43
 * @Version 1.0
 **/
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public void save(Order order){
        orderDao.save(order);
    }
}
