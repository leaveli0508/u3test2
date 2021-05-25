package cn.kgc.demo.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class Sale {
    private Integer id;

    private Long price;

    private Integer quantity;

    private Long totalprice;

    private Date saledate;

    private Integer userid;

    private Integer productid;

    //

    private Product product;

    private Users users;


}