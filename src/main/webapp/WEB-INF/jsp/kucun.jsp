<%--
  Created by IntelliJ IDEA.
  User: 86137
  Date: 2021/5/24
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
    <script src="/static/jquery/jquery-1.8.3.js" ></script>
</head>
<body>

    <h2>查看库存</h2>
    <form>
        商品名称：
        <select id="demo">

        </select>
        <button id="button" type="submit">提交</button>
    </form>

<br />
该商品的数量是：





</body>
<script type="text/javascript">
    $(function () {
        $.post(
            "product/allT",//查询product所有的
            function (data) {
              //  console.log(data);
                var goodStr=`<option value="000">---请选择---</option>`;
                $.each(data,function (i,pro) {
                    goodStr+=`<option value="${pro.id}">${pro.productname}</option>`;
                    console.log(${pro.productname})
                });
                $("#demo").html(goodStr);
            },"json")
    })

    $("#button").click(function () {
        //alert("jj");
       var id=$("form select option").val();
       console.log(id);


    })



</script>
</html>
