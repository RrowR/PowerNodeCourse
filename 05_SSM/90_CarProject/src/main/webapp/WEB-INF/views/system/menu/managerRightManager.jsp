<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>菜单管理-右侧</title>
    <!--引入layui的css-->
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui-v2.6.3/css/layui.css">
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/font-awesome-4.7.0/css/font-awesome.min.css" media="all">
    <link rel="stylesheet" href="${ctx}/resources/layuimini/css/public.css" media="all">
    <%-- 引入detree --%>
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui_ext/dtree/font/dtreefont.css">
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

<!--添加和修改的弹出层开始-->
<div id="addOrUpdateDiv" style="display: none;padding: 5px">
    <form class="layui-form layui-form-pane" id="dataFrm" lay-filter="dataFrm">
        <div class="layui-form-item">
            <label class="layui-form-label">父级菜单</label>
            <div class="layui-input-block">
                <ul id="pid" name="pid" class="dtree" data-id="0" ></ul>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单名称</label>
            <div class="layui-input-block">
                <input type="hidden" name="id">
                <input type="text" class="layui-input" name="title" placeholder="请输入菜单名称">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">菜单地址</label>
            <div class="layui-input-block">
                <input type="text" class="layui-input" name="href" placeholder="请输入菜单地址">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">菜单图标</label>
                <div class="layui-input-inline">
                    <input type="text" id="iconPicker" name="icon" lay-filter="iconPicker" class="hide">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">TARGET</label>
                <div class="layui-input-inline">
                    <input type="text" class="layui-input" name="target" placeholder="请输入TARGET">
                </div>
            </div>
        </div>
        <div class="layui-form-item">

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
<!--添加和修改的弹出层结束-->


</body>
<!--引入layui的核心JS-->
<script type="text/javascript" src="${ctx}/resources/layuimini/lib/layui-v2.6.3/layui.js"></script>
<%--<script src="${ctx}/resources/layuimini/js/lay-config.js" charset="utf-8"></script>--%>
<script>

    let newsTable;
    layui.extend({
        dtree: '${ctx}/resources/layuimini/lib/layui_ext/dtree/dtree',   // {/}的意思即代表采用自有路径，即不跟随 base 路径
        iconPickerFa:'${ctx}/resources/layuimini/js/lay-module/iconPicker/iconPickerFa'
    }).use(['table','layer','jquery','form','laydate','iconPickerFa','dtree'], function() {
        //引入表格模块
        let table = layui.table;
        let layer = layui.layer;
        let $ = layui.jquery;
        let form = layui.form;
        let laydate = layui.laydate;
        // 引入图标
        let iconPickerFa = layui.iconPickerFa;
        // 引入dtree
        let dtree = layui.dtree;

        //使用list+layui的格式
        menuTree = dtree.renderSelect({
            elem: "#pid",
            dataStyle: "layuiStyle",  //使用layui风格的数据格式
            dataFormat: "list",
            response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
            url: "${ctx}/menu/loadMenuTreeJson.action", // 使用url加载
            icon:"4",
            selectInputName: {
                nodeId: "pid",      // 获得当前节点的id
                context: "node_title"
            }
        });


        iconPickerFa.render({
            // 选择器，推荐使用input
            elem: '#iconPicker',
            // fa 图标接口
            url: "${ctx}/resources/layuimini/lib/font-awesome-4.7.0/less/variables.less",
            // 是否开启搜索：true/false，默认true
            search: true,
            // 是否开启分页：true/false，默认true
            page: true,
            // 每页显示数量，默认12
            limit: 12,
            // 点击回调
            click: function (data) {
                $("#iconPicker").val("fa "+data.icon);      // 选中图标按钮，在点击的时候给图标重新赋值
                console.log(data);
            },
            // 渲染成功后的回调
            success: function (d) {
                console.log(d);
            }
        });


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

       let url;

        // 监听弹出层的提交按钮
        form.on("submit(doSubmit)",function (obj){
            // console.log(obj);
            let field = obj.field;
            $.post(url,field,function (res){
                if (res.code == 200){
                    newsTable.reload(); //刷新表格
                    window.parent.left.menuTree.reload();   // 刷新frameset左边的menuTree
                    menuTree.reload();      // 刷新自己这个页面的menuTree
                }
                layer.msg(res.msg);
            })
        })

        //监听行工具条事件
        table.on("tool(newsTable)",function (obj) {
            let event=obj.event;
            let data=obj.data;
            if(event=="del"){
                doDelete(data);
            }else if (event=="update"){
                openUpdateLayer(data);
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
                openAddMenuLayer();         // 打开头工具条的添加弹出层
            }
        })

        // 上面调用打开弹出层的方法
        function openAddMenuLayer(){
            mainIndex = layer.open({
                type:1,
                title:"创建菜单",
                content:$("#addOrUpdateDiv"),
                area:["700px","600px"],
                success:function (){
                    $("#doReset").click();
                    url="${ctx}/menu/add.action";
                }
            })
        }


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