<%@ page language="java"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>添加客户信息</title>
<link rel="stylesheet" type="text/css" href="skin/css/base.css">
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.7.2.js"></script>
<script type="text/javascript">
	function commit(){
	    $("#form2").submit();
	}
</script>
<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
<tr>
 <td height="26" background="skin/images/newlinebg3.gif">
  <table width="58%" border="0" cellspacing="0" cellpadding="0">
  <tr>
  <td >
    当前位置:客户信息管理>>添加客户信息
 </td>
 </tr>
</table>
</td>
</tr>
</table>

<form id="form2" name="form2" action="${pageContext.request.contextPath}/cust/insert" method="post">

<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
<tr bgcolor="#E7E7E7">
	<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="comname" type="text" name="comname"/><span id="msg1"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="companyperson" type="text" name="companyperson"/><span id="msg2"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="comaddress" type="text" name="comaddress" size="60"/><span id="msg3"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input id="comphone" type="text" name="comphone"/><span id="msg4"></span></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
	<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<input type="text" name="camera"/></td>
</tr>
<tr >
	<td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
	<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
		<textarea  name="present" rows=15 cols=130></textarea></td>
</tr>

<tr >
	<td align="right" bgcolor="#FAFAF1" >备注：</td>
	<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
		<textarea name="remark" rows=10 cols=130></textarea>
	</td>
</tr>


<tr bgcolor="#FAFAF1">
<td height="28" colspan=4 align=center>
	&nbsp;
	<a href="javascript:commit()"  class="coolbg">保存</a>
	<a href="customer.jsp" class="coolbg">返回</a>
</td>
</tr>
</table>

</form>
  <script type="text/javascript">
      $("#comname").blur(function(){
          var value = $("#comname").val();
          if(value == null || value == ""){
              $("#msg1").text("公司名称不能为空").css("color","red")
              $(this).focus();

          }else{
              $("#msg1").text("公司名称输入正确").css("color","green")
          }
      })


	  $("#companyperson").blur(function(){
	      var value = $("#companyperson").val();
	      if(value == null || value == ""){
	          $("#msg2").text("公司联系人不能为空").css("color","red")
              $(this).focus();

		  }else{
              $("#msg2").text("公司联系人输入正确").css("color","green")
          }
	  })

      $("#comaddress").blur(function(){
          var value = $("#comaddress").val();
          if(value == null || value == ""){
              $("#msg3").text("公司地址不能为空").css("color","red")
              $(this).focus();

          }else{
              $("#msg3").text("公司地址输入正确").css("color","green")
          }
      })


      $("#comphone").blur(function(){
          var value = $("#comphone").val();
          if(value == null || value == ""){
              $("#msg4").text("电话号码不能为空").css("color","red")
              $(this).focus();
              return;
          }
          if(!(/^1[3456789]\d{9}$/.test(phone))){
              $("#msg4").text("电话号码格式错误，请重新填写").css("color","red")
              $(this).focus();
          }

      })


  </script>

</body>
</html>