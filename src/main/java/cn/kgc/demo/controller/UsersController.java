package cn.kgc.demo.controller;

import cn.kgc.demo.pojo.Users;
import cn.kgc.demo.service.imp.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("users")
public class UsersController extends BaseController<Users> {

    @Autowired
    private UsersServiceImpl usersService;

    //根据用户名和密码验证是否登录成功
    @RequestMapping("checkLogin")
    @ResponseBody
    public String checkLogin(Users users, HttpSession session) {
        //将用户输入的密码（123456）进行MD5加密（e10adc3949ba59abbe56e057f20f883e），再到数据库进行条件查询登陆
        try {
            Users users1 = usersService.selParamsToT(users);
            if (users1 != null) {
                session.setAttribute("user", users1);
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


}
