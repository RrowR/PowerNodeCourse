<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单左侧管理</title>
    <link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui-v2.6.3/css/layui.css">
</head>
<body>
<ul id="menuTree" class="dtree" data-id="0"></ul>
</body>
<%-- 引入detree --%>
<link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui_ext/dtree/dtree.css">
<link rel="stylesheet" href="${ctx}/resources/layuimini/lib/layui_ext/dtree/font/dtreefont.css">
<!--引入layui的核心JS-->
<script type="text/javascript" src="${ctx}/resources/layuimini/lib/layui-v2.6.3/layui.js"></script>
<%--<script src="${ctx}/resources/layuimini/js/lay-config.js" charset="utf-8"></script>--%>
<script>
    layui.extend({
        dtree: '${ctx}/resources/layuimini/lib/layui_ext/dtree/dtree'   // {/}的意思即代表采用自有路径，即不跟随 base 路径
    }).use(['form',"layer","table","jquery",'dtree'],function () {
        let dtree=layui.dtree;
        let layer = layui.layer;
        let $ = layui.jquery;
        //使用list+layui的格式
        let menuTree = dtree.render({
            elem: "#menuTree",
            dataStyle: "layuiStyle",  //使用layui风格的数据格式
            dataFormat: "list",
            response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
            url: "${ctx}/menu/loadMenuTreeJson.action", // 使用url加载
            icon:"4",
            checkbar: true  //开启复选框
        });
        //监听树的点击事件
        dtree.on("node('menuTree')" ,function(obj){
            // layer.msg(JSON.stringify(obj.param));
            let currentNodeId=obj.param.nodeId;
            // 获取当前父窗口的左边窗口里的方法，传入id
            window.parent.right.reloadMenuTable(currentNodeId);
        });

    })
</script>
</html>
