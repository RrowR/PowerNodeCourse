<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>角色管理</title>
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
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="rolename" placeholder="请输入角色名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">角色备注</label>
                    <div class="layui-input-inline">
                        <input type="text" name="roledesc" placeholder="请输入角色备注" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-inline" style="width: auto">
                        <input type="radio"  name="available" title="可用" checked value="1">
                        <input type="radio"  name="available" title="不可用" value="0">
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

<%-- 弹出层开始 --%>
<div id="addOrUpdateDiv" style="display: none;padding: 10px">
    <form class="layui-form" id="dataFrm" lay-filter="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名称:</label>
            <div class="layui-input-block">     <%-- 块级元素 --%>
                <input type="hidden" name="roleid">
                <input type="text" lay-verify="required" name="rolename" placeholder="请输入角色标题" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色描述:</label>
            <textarea class="layui-textarea" name="roledesc"></textarea>
            <div class="layui-inline">
                <label class="layui-form-label">是否可用</label>
                <div class="layui-input-inline" style="width: auto">
                    <input type="radio"  name="available" title="可用" checked value="1">
                    <input type="radio"  name="available" title="不可用" value="0">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div style="text-align: center">
                <input  type="button" lay-submit lay-filter="doSubmit" class="layui-btn" value="提交" >
                <input  type="reset"  id="doReset" class="layui-btn layui-btn-danger" value="重置" >
            </div>
        </div>
    </form>
</div>
<%-- 弹出层结束 --%>

<!--数据表格开始-->
<div>
    <table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>
    <!--声明一个表格的头部工具条-->
    <div id="roleTableHeadToolbar" style="display: none">
        <input  type="button" class="layui-btn layui-btn-sm" lay-event="add" value="添加" >
    </div>

    <!--声明一个表格的列工具条-->
    <div id="roleTableRowToolbar" style="display: none">
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
    layui.use(['table','layer','jquery','form'], function() {
        //引入表格模块
        let table = layui.table;
        let layer = layui.layer;
        let $ = layui.jquery;
        let form = layui.form;

        //渲染数据表格
        let roleTable=table.render({
            elem: '#roleTable'//绑定最后表格数据组装好之后渲染的容器
            ,url:'${ctx}/role/queryForPage.action'//数据源的url
            ,toolbar:'#roleTableHeadToolbar'//指向页面上的DOM的头部工具条
            ,defaultToolbar: ["print",'exports',"filter"]//设置表格右上角的过滤 导出  打印的按钮
            ,cellMinWidth:150//前提是所有列设置为自动宽度，当行内容放不下时，会限定表元格的最小宽度
            ,page:true//是否开启分页
            ,height:"full-200"
            ,cols: [[   //表格里面的数据列field对应的数据源json里面的data里面的key
                {field:'roleid', align:"center", title: 'ID'}
                ,{field:'rolename',  title: '角色名称', align:"center"}
                ,{field:'roledesc',  title: '角色描述', align:"center"}
                ,{field:'available',  title: '是否可用', align:"center",templet:function (d){
                        return d.available == 1 ? "可用":"不可用";
                    }}
                ,{title: '操作',fixed:"right",toolbar:"#roleTableRowToolbar", align:"center"}
            ]]
        });

        //监听查询条件的查询按钮
        form.on("submit(doSearch)",function (obj) {
            console.log(obj.field);
            let params=obj.field;//它是表单里的数据(JSON格式)
            //请求后台数据，刷新表格
            roleTable.reload({
                where:params,
                page:{
                    curr:1
                }
            })
        })

        //监听行工具条事件
        table.on("tool(roleTable)",function (obj) {
            let event=obj.event;
            let data=obj.data;
            if(event=="del"){
                doDelete(data);
            }else if (event=="update"){
                openUpdate(data);
            }

        })
        //监听头工具条事件
        table.on("toolbar(roleTable)",function (obj) {
            let event=obj.event;
            if(event=="add"){
                openAddLayer();
            }
        })

        // 声明一个全局的url
        let url = "";
        // 声明一个弹出层索引
        let mainIndex;

        //删除一个
        function doDelete(data){
            console.log(data);
            layer.confirm("你确定要删除【"+data.rolename+"】这个角色吗?",function () {
                //使用AJAX发送请求到后台
                $.post("${ctx}/role/delete.action",{id:data.roleid},function (res) {
                    if(res.code==200){
                        roleTable.reload(); //刷新表格
                    }
                    layer.msg(res.msg);
                })
            })
        }


        // 打开添加的弹出层
        function openAddLayer(){
            mainIndex = layer.open({
                type:1,
                title:"添加的系统角色",
                content:$("#addOrUpdateDiv"),
                area:['900px','600px'],
                success:function (){            // 成功打开弹出层的回调
                    url="${ctx}/role/add.action";
                }
            })
        }
        // 打开修改的弹出层
        function openUpdate(data){
            mainIndex = layer.open({
                type:1,
                title:"修改"+data.rolename+"的系统角色",
                content:$("#addOrUpdateDiv"),
                area:['900px','600px'],
                success:function (){            // 成功打开弹出层的回调
                    url="${ctx}/role/update.action";
                    form.val("dataFrm",data);           // 这里赋值的时候千万不能加 # 这里并不是jquery
                }
            })
        }

        // 监听弹出层的提交按钮
        form.on("submit(doSubmit)",function (obj){
            let field = obj.field;
            console.log(field);
            $.post(url,field,function (res){
                if (res.code==200){
                    // 刷新表格
                    roleTable.reload();
                }
                layer.close(mainIndex);
                layer.msg(res.msg);
            })
        })

    });
</script>
</html>