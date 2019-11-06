
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<link rel="stylesheet" href="${pageContext.request.contextPath}/static/js/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/ztree/jquery.ztree.all-3.5.min.js"></script>
<body>

<script type="text/javascript">
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {

    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [
        {name:"test1", open:false, children:[
                {name:"test1_1"}, {name:"test1_2"}]},
        {name:"test2", open:false, children:[
                {name:"test2_1"}, {name:"test2_2"}]}
    ];
    $(document).ready(function(){
        zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
    });
</script>

<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>
