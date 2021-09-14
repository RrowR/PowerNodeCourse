<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <!--引入layui的css-->
    <link rel="stylesheet" href="resources/layuimini/lib/layui-v2.6.8/css/layui.css">
</head>
<body style="margin: 10px;">
<!--查询条件开始-->
<div>
    <blockquote class="layui-elem-quote">
        <form class="layui-form" action="#" method="get" id="searchFrm" lay-filter="searchFrm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">登陆名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="username" placeholder="请输入登陆名" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">真实名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="realName" placeholder="请输入真实名" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">在职状态</label>
                    <div class="layui-input-inline">
                        <input type="radio" name="deleted" value="1" title="在职">
                        <input type="radio" name="deleted" value="2" title="离职">
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
    <table class="layui-hide" id="userTable" lay-filter="userTable"></table>
    <!--声明一个表格的头部工具条-->
    <div id="userTableHeadToolbar" style="display: none">
        <input  type="button" class="layui-btn layui-btn-sm" lay-event="add" value="添加" >
    </div>
    <!--声明一个表格的行工具条-->
    <div id="userTableRowToolbar" style="display: none">
        <input  type="button" class="layui-btn layui-btn-sm" lay-event="update"  value="修改" >
        <input  type="button" class="layui-btn layui-btn-danger layui-btn-sm" lay-event="quit" value="离职" >
        <input  type="button" class="layui-btn layui-btn-sm layui-btn-warm" lay-event="resetPwd"  value="重置密码" >

    </div>
</div>
<!--数据表格结束-->

<!--添加和修改的弹出层内容开始-->
<div id="addOrUpdateUserDiv" style="display: none;margin: 10px">
    <form class="layui-form" action="#" method="get" id="dataFrm" lay-filter="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">登陆名</label>
            <div class="layui-input-block">
                <input type="hidden" name="id">
                <input type="text" lay-verify="required" name="username" placeholder="请输入登陆名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">真实名</label>
            <div class="layui-input-block">
                <input type="text" lay-verify="required" name="realName" placeholder="请输入真实名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <input type="radio"  name="role" value="1" title="管理员">
                <input type="radio" name="role" checked value="2" title="业务员">
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
<!--添加和修改的弹出层内容结束-->

</body>
<!--引入layui的核心JS-->
<script type="text/javascript" src="resources/layuimini/lib/layui-v2.6.8/layui.js"></script>
<script src="resources/layuimini/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script>
    layui.use(['table','layer','jquery','form'], function() {
        //引入表格模块
        let table = layui.table;
        let layer = layui.layer;
        let $ = layui.jquery;
        let form = layui.form;
        //渲染数据表格
        let userTable=table.render({
            elem: '#userTable'//绑定最后表格数据组装好之后渲染的容器
            ,url:'user.do?service=query'//数据源的url
            ,toolbar:'#userTableHeadToolbar'//指向页面上的DOM的头部工具条
            ,defaultToolbar: ["print",'exports',"filter"]//设置表格右上角的过滤 导出  打印的按钮
            ,cellMinWidth:150//前提是所有列设置为自动宽度，当行内容放不下时，会限定表元格的最小宽度
            ,page:true//是否开启分页
            ,height:"full-200"
            ,cols: [[//表格里面的数据列field对应的数据源json里面的data里面的key
                {field:'id', align:"center", title: 'ID'}
                ,{field:'username',  title: '登陆名', align:"center"}
                ,{field:'realName',  title: '真实名', align:"center"}
                ,{field:'role',  title: '角色', align:"center",templet:function (d){
                        //上面的d是指整行数据
                        return d.role=="1"?"管理员":"业务员";
                    }}
                ,{field:'deleted',  title: '在职状态', align:"center",templet:function (d){
                        //上面的d是指整行数据
                        return d.deleted=="1"?"在职":"离职";
                    }}
                ,{field:'createTime',  title: '创建时间', align:"center"}
                ,{field:'updateTime', title: '更新时间',align:"center"}
                ,{field:'deletedTime', title: '离职时间', align:"center"}
                ,{title: '操作',width:'249',fixed:"right",toolbar:"#userTableRowToolbar", align:"center"}
            ]]
        });

        //监听查询条件的查询按钮
        form.on("submit(doSearch)",function (obj) {
            let params=obj.field;//它是一个json的对象
            //请求后台数据，刷新表格
            userTable.reload({
                where:params
            })
        })

        //监听行工具条事件
        table.on("tool(userTable)",function (obj) {
            let event=obj.event;
            let data=obj.data;
            if(event=="update"){
                openUpdateUserLayer(data);
            }else if(event=="quit"){
                doQuit(data)
            }else if(event=="resetPwd"){
                doResetPwd(data)
            }

        })
        //监听头工具条事件
        table.on("toolbar(userTable)",function (obj) {
            let event=obj.event;
            if(event=="add"){
                openAddUserLayer();
            }
        })
        //声明一个全局的url
        let url="";
        //声明一个弹出层的索引
        let mainIndex;
        //打开添加和弹出层
        function openAddUserLayer() {
            // layer.msg("添加");
            mainIndex=layer.open({
                type:1,
                title:"添加用户",
                content:$("#addOrUpdateUserDiv"),
                area:["400px","300px"],
                success:function () {
                    // layer.msg("添加页面弹出成功");
                    //模拟点击重置
                    $("#doReset").click();
                    //设置提交地址为添加的地址
                    url="user.do?service=add";
                }
            })
        }
        //打开修改的弹出层
        function openUpdateUserLayer(data) {
            // layer.msg("更新"+JSON.stringify(data))
            mainIndex=layer.open({
                type:1,
                title:"修改【"+data.username+"】用户",
                content:$("#addOrUpdateUserDiv"),
                area:["400px","300px"],
                success:function () {
                    //载入把当前这一行的数据载入表单
                    form.val("dataFrm",data);
                    // 设置url为更新的地址
                    url="user.do?service=update";
                }
            })
        }
        //离职
        function doQuit(data) {
            if(data.deleted==2){
                layer.msg("【"+data.realName+"】这个员工已离职，不能再进行操作")
                return;
            }
            layer.confirm("你确定要删除【"+data.username+"】这个用户离职吗?",function () {
                //使用AJAX发送请求到后台
                $.post("user.do?service=quit",{id:data.id},function (res) {
                    if(res.code==200){
                        userTable.reload(); //刷新表格
                    }
                    layer.msg(res.msg);
                })
            })
        }
        //重置密码
        function doResetPwd(data) {
            layer.confirm("你确定要重置【"+data.username+"】这个用户的密码吗?",function () {
                //使用AJAX发送请求到后台
                $.post("user.do?service=resetPwd",{id:data.id},function (res) {
                    layer.msg(res.msg);
                })
            })
        }
        //监听提交数据表单按钮的事件
        form.on("submit(doSubmit)",function (obj) {
             $.post(url,obj.field,function (res) {
                 if(res.code==200){
                     //刷新表格
                     userTable.reload();
                 }
                 layer.close(mainIndex);
                 layer.msg(res.msg);
             })
        })
    });
</script>
</html>
