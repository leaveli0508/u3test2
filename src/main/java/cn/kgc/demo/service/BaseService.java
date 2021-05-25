package cn.kgc.demo.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    //条件查询所有的信息
    Map<String,Object> selectAllBy(Integer page, Integer limit, T t);

    //查询所有部门
    List<T> selAll();

    //删除一行数据
    String deleteById(Integer id);

    //删除多行数据
    String deleteByIds(Integer[] ids);

    //插入新的数据
    String insertT(T t);

    //修改数据
    String updateT(T t);

    //（根据参数查询到类）根据身份证查询到这个类
    T selParamsToT(T t);

    //根据参数查询到类的集合
    List<T> selTsByParams(T t);

    //根据多个ID修改T类参数
    String updTByParams(@Param("ids") Integer[] ids, @Param("t") T t);

    //根据参数查询类的个数
    Long selNumTByParams(T t);


}
