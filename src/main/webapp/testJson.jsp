
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href="${pageContext.request.contextPath}/">
</head>

<body>
<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>

<script type="text/javascript">
    $(function (){
        var person = [{"name":"xiaoming","age":18,"hobby":"singing"},
            {"name":"xiaoming","age":18,"hobby":"singing"},
            {"name":"xiaoming","age":18,"hobby":"singing"}
            ]
        var a = [1,2,3];
        alert(typeof(a))
        alert(typeof(person))
    })
</script>


</body>
</html>
