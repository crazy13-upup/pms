<%@ page language="java"  pageEncoding="UTF-8"%>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/29 0029
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/echarts.js"></script>

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    var aa = [];
    var bb = [];
    $.ajax({
        type:"get",
        url:"${pageContext.request.contextPath}/echarts/info",
        success:function(msg){
            for(key in msg){
                aa.push(key);
               bb.push(msg[key])
            }
            // 基于准备好的dom，初始化echarts实例
            var myChart = echarts.init(document.getElementById('main'));

            // 指定图表的配置项和数据
            var option = {
                title: {
                    text: 'ECharts 服装'
                },
                tooltip: {},
                legend: {
                    data:['销量']
                },
                xAxis: {
                    data: aa
                },
                yAxis: {},
                series: [{
                    name: '销量',
                    type: 'bar',
                    data: bb
                }]
            };

            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })


</script>




</body>
</html>
