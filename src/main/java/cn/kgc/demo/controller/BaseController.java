package cn.kgc.demo.controller;

import cn.kgc.demo.service.imp.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;


public class BaseController<T> {

    @Autowired
    private BaseServiceImpl<T> baseService;

    //条件查询所有部门和员工信息
    @RequestMapping("toData")
    @ResponseBody
    public Map<String,Object> toData(Integer page, Integer limit, T t){
        Map<String,Object>  map=null;
        try {
            map=baseService.selectAllBy(page, limit,t);
            map.put("code",0);
            map.put("msg","数据传输成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",200);
            map.put("msg","数据传输失败");
        }
        return map;
    }


    //查询所有部门信息
    @RequestMapping("allT")
    @ResponseBody
    public List<T> selAllDept(){
        return baseService.selAll();
    }

    //根据员工编号删除Emp
    @RequestMapping("deleteT")
    @ResponseBody
    public String deleteEmp(Integer id){
        try {
            return baseService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //根据ID数组多选批量删除
    @RequestMapping("deleteTs")
    @ResponseBody
    public String deletePi(Integer[] ids){
        try {
            return baseService.deleteByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //添加新的一行数据
    @RequestMapping("addT")
    @ResponseBody
    public String addEmp(T t){
        try {
            return baseService.insertT(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //执行修改Emp操作
    @RequestMapping("updateT")
    @ResponseBody
    public String updateEmp(T t){
        try {
            return baseService.updateT(t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //（根据参数查询到类）根据身份证查询到这个类
    @RequestMapping("paramsToT")
    @ResponseBody
    public T paramsToT(T t){
        try {
         return  baseService.selParamsToT(t);
        } catch (Exception e) {
            e.printStackTrace();
           return null;
        }
    }

    //根据参数查询到类的集合
    @RequestMapping("selTsByParams")
    @ResponseBody
    public List<T> selTsByParams(T t) {
        try {
            return baseService.selTsByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //根据多个ID修改T类参数
    @RequestMapping("delTsByIds")
    @ResponseBody
    public String delTsByIds(Integer[] ids,T t){
        try {
            return baseService.updTByParams(ids,t);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    //根据参数查询类的个数
    @RequestMapping("selNumTByParams")
    @ResponseBody
    public Long selNumTByParams(T t){
        try {
            return baseService.selNumTByParams(t);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    };
}
