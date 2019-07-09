package com.test.dao;

import com.test.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;

/**
 * @ClassName InventoryMapper
 * @Description TODO
 * @Date 2019/3/21/02114:06
 * @Version 1.0
 **/
@Repository
public interface  InventoryDao extends JpaRepository<Inventory, Long> {
    /**
     * 自定义查询，利用sql加行锁
     * @param id
     * @return
     */
   @Query(value = "select * from t_inventory t1 where t1.id= :id for update",nativeQuery = true)
    public  Inventory selectOneByIdForSqlLock (@Param("id") Long id);

    /**
     * 自定义查询，利用JPA自带的注解加行锁
     * @param id
     * @return
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query(value = "select t1 from Inventory t1 where t1.id= :id ")
    public  Inventory selectOneByIdForJpaLock (@Param("id") Long id);


    /**
     * 自定义更新方法，对比版本号更新
     * @param id
     * @param inventory
     * @param version
     * @return
     */
    @Modifying
    @Query(value = "update t_inventory set inventory = :inventory, version = version + 1 where id = :id and version = :version", nativeQuery = true)
    public int updateById (@Param("id") Long id,@Param("inventory") int inventory,@Param("version") int version);
}
