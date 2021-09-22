<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>公告管理</title>
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
                    <label class="layui-form-label">公告标题</label>
                    <div class="layui-input-inline">
                        <input type="text" name="title" placeholder="请输入公告标题" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">公告内容</label>
                    <div class="layui-input-inline">
                        <input type="text" name="content" placeholder="请输入公告内容" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">开始时间</label>
                    <div class="layui-input-inline">
                        <input type="text" id="startTime" name="startTime" placeholder="请选择开始时间" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">结束时间</label>
                    <div class="layui-input-inline">
                        <input type="text"  id="endTime" name="endTime" placeholder="请选择结束时间" class="layui-input">
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
        <input  type="button" class="layui-btn layui-btn-sm layui-btn-danger" lay-event="batchDel" value="批量删除" >
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
<script src="${ctx}/resources/layuimini/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script>
    layui.use(['table','layer','jquery','form','laydate'], function() {
        //引入表格模块
        let table = layui.table;
        let layer = layui.layer;
        let $ = layui.jquery;
        let form = layui.form;
        let laydate = layui.laydate;
        // 给查询条件绑定时间选择器(给元素绑定时间的作用)
        laydate.render({
            elem: "#startTime",
            type: "datetime"
        })
        laydate.render({
            elem: "#endTime",
            type: "datetime"
        })

        //渲染数据表格
        let newsTable=table.render({
            elem: '#newsTable'//绑定最后表格数据组装好之后渲染的容器
            ,url:'${ctx}/news/queryForPage.action'//数据源的url
            ,toolbar:'#newsTableHeadToolbar'//指向页面上的DOM的头部工具条
            ,defaultToolbar: ["print",'exports',"filter"]//设置表格右上角的过滤 导出  打印的按钮
            ,cellMinWidth:150//前提是所有列设置为自动宽度，当行内容放不下时，会限定表元格的最小宽度
            ,page:true//是否开启分页
            ,height:"full-200"
            ,cols: [[   //表格里面的数据列field对应的数据源json里面的data里面的key
                {type:"checkbox"}
                ,{field:'id', align:"center", title: 'ID'}
                ,{field:'title',  title: '标题', align:"center"}
                ,{field:'createtime',  title: '发布时间', align:"center"}
                ,{field:'opername',  title: '发布人', align:"center"}
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
        //监听头工具条事件
        table.on("toolbar(newsTable)",function (obj) {
            let event=obj.event;
            if(event=="batchDel"){
                doBatchDel();
            }
        })

        //删除一个
        function doDelete(data){
            layer.confirm("你确定要删除【"+data.title+"】这个公告吗?",function () {
                //使用AJAX发送请求到后台
                $.post("${ctx}/news/delete.action",{id:data.id},function (res) {
                    if(res.code==200){
                        newsTable.reload(); //刷新表格
                    }
                    layer.msg(res.msg);
                })
            })
        }
        //批量删除
        function doBatchDel(){
            //得到选中行
            let checkStatus = table.checkStatus('newsTable'); //customerTable 即为基础参数 id 对应的值
            let count=checkStatus.data.length;
            if(count==0){
                layer.msg("请选中操作行");
                return;
            }
            layer.confirm("你确定要删除选中的这些公告吗?",function () {
                let params="";
                $.each(checkStatus.data,function (i,item) {
                    if(i==0){
                        params+="ids="+item.id;
                    }else{
                        params+="&ids="+item.id;
                    }
                })
                //使用AJAX发送请求到后台
                $.post("${ctx}/news/batchDel.action",params,function (res) {
                    if(res.code==200){
                        newsTable.reload(); //刷新表格
                    }
                    layer.msg(res.msg);
                })
            })
        }

    });
</script>
</html>