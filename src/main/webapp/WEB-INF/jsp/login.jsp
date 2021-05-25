<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/5/24
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
</head>
<body>
<div class="login" style="height: 300px;">
    <h1>用户登录</h1>
    <!--拦截后的提示-->
 <%--   <input type="hidden" id="loginUIMsg" value="${loginUIMsg }">--%>
    <form class="layui-form" action="" lay-filter="example">
        <div class="layui-form-item">
            <input id="userName" class="layui-input" name="username" placeholder="用户名"
                   lay-verify="required" type="text" autocomplete="off">
        </div>
        <div class="layui-form-item">
            <input id="pwd" class="layui-input" name="password" placeholder="密码"
                   lay-verify="required" type="password" autocomplete="off">
        </div>
        <button class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
    </form>
</div>
</body>
<script src="/static/lib/layui/layui.js"></script>
<script src="/static/js/login.js"></script>
</html>
