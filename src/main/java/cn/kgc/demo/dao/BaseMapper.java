package cn.kgc.demo.dao;


import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T t);

    int insertSelective(T t);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);


    //条件查询所有的数据
    List<T> selectTBy(T t);

    //批量删除
    int deleteSome(@Param("ids") Integer[] ids);

    //查询所有的部门名称
    List<T> selectAll();

    //（根据参数查询到类）根据身份证查询到这个类
    T selParamsToT(T t);

    //根据参数查询到类的集合
    List<T> selTsByParams(T t);

    //根据多个ID修改T类参数
    int updTByParams(@Param("ids") Integer[] ids,@Param("t") T t);

    //根据参数查询类的个数
    Long selNumTByParams(T t);

}
