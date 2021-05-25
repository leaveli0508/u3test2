package cn.kgc.demo.service.imp;

import cn.kgc.demo.dao.BaseMapper;
import cn.kgc.demo.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T>{

    @Autowired
    private BaseMapper<T> baseMapper;

    //条件查询所有的信息
    @Override
    public Map<String, Object> selectAllBy(Integer page, Integer limit, T t) {
        Map<String, Object> map =new HashMap<>();
        //分页查询
        PageHelper.startPage(page,limit);
        //开始查询数据
        List<T> list=baseMapper.selectTBy(t);
        //封装数据
        PageInfo pageInfo=new PageInfo(list);
        //注意：count的名称必须跟前端layui要求的返回格式完全一致
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }

    //查询所有部门
    @Override
    public List<T> selAll() {
        return baseMapper.selectAll();
    }

    //删除一行数据
    @Override
    public String deleteById(Integer id) {
        if(baseMapper.deleteByPrimaryKey(id)>0){
            return "success";
        }else return "fail";
    }

    //删除多行数据
    @Override
    public String deleteByIds(Integer[] ids) {
        if(baseMapper.deleteSome(ids)>0){
            return "success";
        }else return "fail";
    }

    //增加一行数据
    @Override
    public String insertT(T t) {
        if(baseMapper.insert(t)>0){
            return "success";
        }else return "fail" ;
    }

    //修改一行数据
    @Override
    public String updateT(T t) {
        if(baseMapper.updateByPrimaryKeySelective(t)>0){
            return "success";
        }else return "fail" ;
    }


    //（根据参数查询到类）根据身份证查询到这个类
    @Override
    public T selParamsToT(T t) {
        return baseMapper.selParamsToT(t);
    }


    //根据参数查询到类的集合
    @Override
    public List<T> selTsByParams(T t) {
        return baseMapper.selTsByParams(t);
    }

    //根据多个ID修改T类参数
    @Override
    public String updTByParams(Integer[] ids, T t) {
        if(  baseMapper.updTByParams(ids,t)>0){
            return "success";
        }else return "fail" ;
    }

    @Override
    public Long selNumTByParams(T t) {
        return baseMapper.selNumTByParams(t);
    }
}
