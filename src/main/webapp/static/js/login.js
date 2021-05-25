layui.use(['jquery','layer','form'], function() {
    var $ = layui.jquery    //引入jquery模块
        , layer = layui.layer  //引用layer弹出层模块
        , form = layui.form  //引用form表单模块





    //登录界面的提交
    form.on('submit(login)',function (data) {
        var loginJsonUser = data.field;  //重新将查询条件赋值
        loginUser(loginJsonUser);  //执行登陆
        return false;  //阻止表单跳转提交
    })


    /************************************自定义函数****************************************************/
    //登录界面的提交
    function  loginUser(loginJsonUser){
        $.post(
            "/users/checkLogin",
            loginJsonUser,
            function (data){
                // console.log(data);
                if(data ==='success'){ //登录成功
                    layer.msg("登陆成功！！",{icon: 1,time:2000,anim: 4,shade:0.5});
                    //定时器，2s后跳转到平台首页页面
                    setTimeout("window.location.href='/goto/tozhuye'",2000);
                }else{ //登录失败
                    layer.msg("登陆失败！！",{icon: 2,time:2000,anim: 3,shade:0.5});
                }
            },"text"
        ).error(function (){
            layer.msg("服务器异常！！！",{icon: 3,time:2000,anim: 6,shade:0.5});
        })
    }









});