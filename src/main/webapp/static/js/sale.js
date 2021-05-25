layui.use('table', function() {
    var table = layui.table
        , $ = layui.jquery
        , layer = layui.layer  //引用layer弹出层模块
        , form = layui.form  //引用form表单模块
        , laydate = layui.laydate;  //引用日期模块


    var currentPage = 1;

    loadJsp();


    //载入页面
    function loadJsp() {
        table.render({
            elem: '#test'
            , url: '/'
            , limit: 3  //每一页显示的数据条数，默认值为10
            , limits: [2, 3, 5, 8, 10, 15, 20]   //进行每一页数据条数的选择
            , even: true  //每一行有渐变效果
            , page: true //开启分页,此时会自动的将当前页page和每一页数据条数limit的数值传回服务器端
            , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {field: 'id', width: 100, title: 'id', sort: true, align: 'center'}
                , {field: 'title', width: 350, title: '商品'}
                , {field: 'summary', width: 350, title: '单价'}
                , {field: 'author', width: 100, title: '数量'}
                , {field: 'author', width: 100, title: '总价'}
                , {field: 'createdate', title: '销售日期', width: 200, sort: true} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                , {field: 'author', width: 100, title: '销售员'}
            ]],
            done: function (res, curr, count) {  //执行分页是的函数回调；res为分页时服务器端的整个Map集合数据  curr为当前页  count为总的数据条数
                currentPage = curr;
            }
        });
    }

})