package cn.kgc.demo.dao;

import cn.kgc.demo.pojo.Sale;

public interface SaleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sale record);

    int insertSelective(Sale record);

    Sale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sale record);

    int updateByPrimaryKey(Sale record);
}