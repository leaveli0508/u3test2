package cn.kgc.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("goto")
public class ToController {

    @RequestMapping("tozhuye")
    public String zhuye(){
        return "zhuye";
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "addye";
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "login";
    }

    @RequestMapping("tokucun")
    public String tokucun(){
        return "kucun";
    }

}
