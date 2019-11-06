<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<tr align="right" bgcolor="#EEF4EA">
    <td height="36" colspan="12" align="center">
        <!--翻页代码 -->
        <div>
            <a href="${requestURI}?pageNum=1${str}">首页</a>
            <a href="${requestURI}?pageNum=${page.pageNum-1}${str}">上一页</a>
            <c:forEach items="${page.navigatepageNums}" var="pageNum">
                <c:if test="${pageNum == page.pageNum}">
                    <%--判断导航页是否为当前页--%>
                    <span style="color:deeppink;font-weight: bold" ><a href="${requestURI}?pageNum=${pageNum}">${pageNum}</a></span>
                </c:if>
                <c:if test="${pageNum != page.pageNum}">
                    <a href="${requestURI}?pageNum=${pageNum}${str}">${pageNum}</a></span>
                </c:if>
            </c:forEach>
            <a href="${requestURI}?pageNum=${page.pageNum+1}${str}">下一页</a>
            <a href="${requestURI}?pageNum=${page.pages}${str}">尾页</a>
            &nbsp;&nbsp;跳转到&nbsp;&nbsp;<input id="blur" size="1px" onblur="queryList()" />&nbsp;页
        </div>
    </td>
</tr>

</body>
</html>
