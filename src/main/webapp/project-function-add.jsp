<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加功能信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>


<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
	    $.ajax({
			type:"get",
			url:"pro/jsonList1",
			success:function(msg){
			    $(msg.list).each(function(index,item){
					var option = "<option value='"+item.pid+"'>"+item.pname+"</option>";
					$("#pname").append(option)
				})
			}
		})
	})

	function change(pid) {
        $.ajax({
            type: "get",
            url: "analy/findAnalyById" + pid,
            success: function (msg) {
                $("#analy").empty();
                var option = "<option value='" + msg.analysis.id + "'>" + msg.analysis.title + "</option>";
                $("#analy").append(option)
            }
        })

        $.ajax({
            type: "get",
            url: "mod/findModule" + pid,
            success: function (msg) {
                $("#module").empty();
                $(msg.list).each(function (index, item) {
                    var option = "<option '" + item.id + "'>" + item.modname + "</option>";
                    $("#module").append(option)
                })
            }
        })
    }



            </script>

            <!--  快速转换位置按钮  -->
            <table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
                <tr>
                <td height="26" background="skin/images/newlinebg3.gif">
                <table width="58%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                <td >
                当前位置:项目管理>>添加功能信息
            </td>
            </tr>
            </table>
            </td>
            </tr>
            </table>

            <form name="form2">

                <table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
                <tr bgcolor="#E7E7E7">
                <td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加新功能&nbsp;</td>
            </tr>
            <tr >
            <td align="right" bgcolor="#FAFAF1" height="22">选择项目：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="pname" onchange="change(this.value)">
                <option>请选择...</option>
                </select>
                </td>
                </tr>
                <tr >
                <td align="right" bgcolor="#FAFAF1" height="22">选择需求：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="analy">
                <option>请选择...</option>
                </select>
                </td>
                </tr>
                <tr >
                <td align="right" bgcolor="#FAFAF1" height="22">选择模块：</td>
            <td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
                <select id="module">
			<option>请选择...</option>
		</select>
	</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">功能名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">优先级：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><select><option>高</option><option>中</option><option>低</option><option>暂缓</option></select></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">简单描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=10 cols=130></textarea></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">详细描述：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130></textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea rows=10 cols=130></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="project-function.jsp" class="coolbg">保存</a>
	<a href="project-function.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  

</body>
</html>