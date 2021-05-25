<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/5/24
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/lib/layui/css/layui.css">
    <script src="static/lib/layui/layui.js"></script>
</head>
<body>
<h3>添加销售</h3>
<form class="layui-form" action="">

    <div class="layui-form-item">
        <label class="layui-form-label">选择框</label>
        <div class="layui-input-block">
            <select name="city" lay-verify="required" id="selGood">
                <option value=""></option>
            </select>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">销售单价：</label>
        <div class="layui-input-block">
            <input type="text" name="price" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">销售数量：</label>
        <div class="layui-input-block">
            <input type="text" name="quantity" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">保存</button>
        </div>
    </div>
</form>



<script type="text/javascript">
    layui.use(['jquery','layer','form'], function() {
        var $ = layui.jquery    //引入jquery模块
            , layer = layui.layer  //引用layer弹出层模块
            , form = layui.form  //引用form表单模块
    })

    jiazaiSel();

    function jiazaiSel() {
        $.ajaxSettings.async = false;
        $.post(
            "/product/allT",
            function (data) {
                var goodStr = `<option value="">---请选择商品---</option>`;
                $.each(data,function (i,e) {
                    goodStr+=`<option value="${e.id}">${e.productName}</option>`;
                })
                $("#selGood").html(goodStr);
                form.render("select"); //渲染
            },"json"
        ).error(function () {
            layer.msg("服务器异常！！！",{icon: 3,time:2000,anim: 6,shade:0.5});
        })
    }




</script >



</body>
</html>
