package com.test.entity;/**
 * Created by Administrator on 2019/3/21/021.
 */

import lombok.Data;

import javax.persistence.*;

/**
 * 商品库存表
 * @ClassName InventoryDo
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02114:23
 * @Version 1.0
 **/
@Table(name = "t_inventory")
@Entity
@Data
public class Inventory {
    @Id
    private Long id;
    private int inventory;
    private String goodName;
    private int goodId;
    //@Version
    private int version;
}
