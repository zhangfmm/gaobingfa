package com.test.controller;/**
 * Created by Administrator on 2019/3/21/021.
 */

import com.test.common.UUIDUtil;
import com.test.entity.Inventory;
import com.test.entity.Order;
import com.test.service.InventoryService;
import com.test.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02111:16
 * @Version 1.0
 **/
@RestController
public class TestController {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/test/find")
    public int find(){
        return inventoryService.find(1L).getInventory();
    }

    @RequestMapping("/test/add")
    public void addInven(){
        inventoryService.addInven();
    }

    /**
     * 模拟用户购买 并生成订单
     */
    @Transactional
    @RequestMapping("/test/buy")
    public int buy(){
        //查询库存
        Inventory inventory = inventoryService.find(1L);

        //减库存
         inventory.setInventory(inventory.getInventory() - 1 );
        //悲观锁调用
        inventoryService.add(inventory);
        //乐观锁调用
//        int result = inventoryService.updateById(inventory.getId(),(inventory.getInventory() - 1),inventory.getVersion());
//        //保存订单
//        if ( result == 0 ) {
//           throw new RuntimeException("服务器忙线中。。。。");
//        }
//        if ( inventory.getInventory() > 0 && result > 0 ) {
//            Order order = new Order();
//            order.setInventory(inventory.getInventory());
//            order.setOrderNo(UUIDUtil.getOrderIdByUUId());
//            order.setUserName("xiao_ming_" + inventory.getInventory() );
//            order.setGoodId(inventory.getGoodId());
//            orderService.save(order);
//        }
        return inventory.getInventory();
    }
}
