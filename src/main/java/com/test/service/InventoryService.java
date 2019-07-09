package com.test.service;/**
 * Created by Administrator on 2019/3/21/021.
 */

import com.test.common.ConstantUtil;
import com.test.dao.InventoryDao;
import com.test.entity.Inventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AddDataService
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02111:24
 * @Version 1.0
 **/
@Service
@Slf4j
public class InventoryService {
    @Autowired
    private InventoryDao inventoryDao;

    public void addInven(){
      Runnable runnable = new Runnable() {
          @Override
          public void run() {
              for (int i = 0 ; i < 100000 ; i++ ) {
                  List<Inventory> list = inventoryDao.findAll();
                  Inventory inventory = list.get(0);
                  inventory.setInventory(inventory.getInventory() + 1);
                  inventoryDao.save(inventory);
                  log.info("====更新库存为==" + inventory.getInventory());
              }

          }
      };
      try {
          Thread thread = new Thread(runnable);
          thread.start();
          Thread.sleep(ConstantUtil.Long_100);
      } catch (Exception e){
          e.printStackTrace();
      }

    }

    public Inventory find(Long id){
        //List<Inventory> list = inventoryDao.selectOneById(1L);

        /**
         * JPa带锁
         */
        Inventory inventory = inventoryDao.selectOneByIdForJpaLock(id);
        /**
         *自定义查询，带锁
         */
       // Inventory inventory  = inventoryDao.selectOneByIdForSqlLock(id);
        return inventory;
    }

    public void add(Inventory inventory){
        inventoryDao.save(inventory);
    }

    /**
     * 更新库存
     * @param id
     * @param inventory
     * @return
     */
    public int updateById(Long id,int inventory,int version){
        return inventoryDao.updateById(id,inventory,version);
    }
}
