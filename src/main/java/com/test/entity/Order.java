package com.test.entity;/**
 * Created by Administrator on 2019/3/21/021.
 */

import lombok.Data;

import javax.persistence.*;

/**
 * @ClassName Order
 * @Description TODO
 * @Author yb
 * @Date 2019/3/21/02115:38
 * @Version 1.0
 **/
@Table(name = "t_order")
@Entity
@Data
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String orderNo;
    private String userName;
    private int inventory;
    @Column(nullable = false)
    private Integer goodId;
}
