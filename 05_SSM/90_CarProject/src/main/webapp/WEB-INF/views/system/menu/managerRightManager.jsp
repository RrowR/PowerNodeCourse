<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理-右侧</title>
    <!--引入layui的css-->
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui-v2.6.3/css/layui.css">
</head>
<body style="margin: 10px;">
<!--查询条件开始-->
<div>
    <blockquote class="layui-elem-quote">
        <form class="layui-form" action="#" method="get" id="searchFrm" lay-filter="searchFrm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">菜单名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" placeholder="请输入菜单名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <input type="button" value="查询" class="layui-btn" id="doSearch" lay-submit lay-filter="doSearch">
                    <input type="reset" value="重置" class="layui-btn layui-btn-danger">
                </div>
            </div>
        </form>
    </blockquote>
</div>
<!--查询条件结束-->


<!--数据表格开始-->
<div>
    <table class="layui-hide" id="newsTable" lay-filter="newsTable"></table>
    <!--声明一个表格的头部工具条-->
    <div id="newsTableHeadToolbar" style="display: none">
        <input  type="button" class="layui-btn layui-btn-sm" lay-event="add" value="添加" >
    </div>

    <!--声明一个表格的列工具条-->
    <div id="newsTableRowToolbar" style="display: none">
        <input  type="button" class="layui-btn layui-btn-sm layui-btn-warm" lay-event="update"  value="修改" >
        <input  type="button" class="layui-btn layui-btn-sm layui-btn-danger" lay-event="del"  value="删除" >
    </div>
</div>
<!--数据表格结束-->
</body>
<!--引入layui的核心JS-->
<script type="text/javascript" src="${ctx}/resources/layuimini/lib/layui-v2.6.3/layui.js"></script>
<script src="${ctx}/resources/layuimini/js/lay-config.js" charset="utf-8"></script>
<script>
    let newsTable;

    layui.use(['table','layer','jquery','form','laydate'], function() {
        //引入表格模块
        let table = layui.table;
        let layer = layui.layer;
        let $ = layui.jquery;
        let form = layui.form;
        let laydate = layui.laydate;


        //渲染数据表格
        newsTable = table.render({
            elem: '#newsTable'//绑定最后表格数据组装好之后渲染的容器
            ,url:'${ctx}/menu/queryForPage.action'//数据源的url
            ,toolbar:'#newsTableHeadToolbar'//指向页面上的DOM的头部工具条
            ,defaultToolbar: ["print",'exports',"filter"]//设置表格右上角的过滤 导出  打印的按钮
            ,cellMinWidth:40//前提是所有列设置为自动宽度，当行内容放不下时，会限定表元格的最小宽度
            ,page:true//是否开启分页
            ,height:"full-200"
            ,cols: [[   //表格里面的数据列field对应的数据源json里面的data里面的key
                {field:'id', align:"center", title: 'ID'}
                ,{field:'pid', align:"center", title: 'pid'}
                ,{field:'title',  title: '标题', align:"center"}
                ,{field:'href',  title: '菜单地址', align:"href"}
                ,{field:'target',  title: '目标地址', align:"target"}
                ,{field:'icon',  title: '图标', align:"icon"}
                ,{field:'available',  title: '是否可用', align:"available",templet:function (d){
                        return d.available == 1 ? "可用":"不可用";
                    }}
                ,{title: '操作',fixed:"right",toolbar:"#newsTableRowToolbar", align:"center"}
            ]]
        });

        //监听查询条件的查询按钮
        form.on("submit(doSearch)",function (obj) {
            let params=obj.field;//它是表单里的数据(JSON格式)
            //请求后台数据，刷新表格
            newsTable.reload({
                where:params,
                page:{
                    curr:1
                }
            })
        })

        //监听行工具条事件
        table.on("tool(newsTable)",function (obj) {
            let event=obj.event;
            let data=obj.data;
            if(event=="del"){
                doDelete(data);
            }
        })

        //删除一个
        function doDelete(data){
            layer.confirm("你确定要删除【"+data.title+"】这个公告吗?",function () {
                //使用AJAX发送请求到后台
                $.post("${ctx}/menu/delete.action",{id:data.id},function (res) {
                    if(res.code==200){
                        newsTable.reload(); //刷新表格
                    }
                    layer.msg(res.msg);
                })
            })
        }

        //监听头工具条事件
        table.on("toolbar(newsTable)",function (obj) {
            let event=obj.event;
            if(event=="add"){

            }
        })



    });

    function reloadMenuTable(id){
        // layer.msg(id);
        // 重新去加载左边页面传过来的id
        newsTable.reload({
            where: {id:id}
        })
    }

</script>
</html>