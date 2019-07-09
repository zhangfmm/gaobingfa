package com.test;/**
 * Created by Administrator on 2019/3/21/021.
 */

import com.test.entity.Inventory;
import com.test.service.InventoryService;
import com.test.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName TestInventory
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02114:52
 * @Version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestInventory {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderService orderService;
    @Test
    public void addTest(){

//        Inventory inventory = new Inventory();
//        inventory.setId(1L);
//        inventory.setInventory(1);
//        inventory.setGoodName("test_1");
//        inventoryService.add(inventory);

         Inventory inventory = inventoryService.find(1L);
        System.out.println(inventory);
//        Order order = new Order();
//        order.setInventory(1);
//        order.setOrderNo(UUIDUtil.getOrderIdByUUId());
//        orderService.save(order);
    }

//    @Test
//    public void addOrder {
//        Order order = new Order();
//        order.setInventory(1);
//        order.setOrderNo(UUIDUtil.getOrderIdByUUId());
//        orderService.save(order);
//    }
}
