<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">

	// 在文档加载完成后执行以下方法
	$(function(){
		
		// ajax请求数据填充到客户基本信息栏中
		 $.post("${pageContext.request.contextPath}/customer/findById.do",{id:'${param.cusId}'},function(result){
			 $("#khno").val(result.khno);
			 $("#name").val(result.name);
			},"json");
		
		// easyui的datagrid组件
		 $("#dg").edatagrid({
			url:'${pageContext.request.contextPath}/contact/list.do?cusId=${param.cusId}',
			saveUrl:'${pageContext.request.contextPath}/contact/save.do?customer.id=${param.cusId}',
			updateUrl:'${pageContext.request.contextPath}/contact/save.do',
			destroyUrl:'${pageContext.request.contextPath}/contact/delete.do'
		 });
	}); 
	
</script>
<title>交往记录管理</title>
</head>
<body style="margin: 15px">

	<!-- 上半部分：客户基本信息 -->
	<div id="p" class="easyui-panel" title="客户基本信息" style="width: 700px;height: 100px;padding: 10px">
		<table cellspacing="8px">
	  		<tr>
	  			<td>客户编号：</td>
	  			<td><input type="text" id="khno" name="khno" readonly="readonly"/></td>
	  			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  			<td>客户名称:</td>
	  			<td><input type="text" id="name" name="name" readonly="readonly"/></td>
	  		</tr>
	  	</table>
	</div>
	
	<br/> <!-- 分割线 -->
	
	<!-- 下半部分:交往记录管理 -->
	<table id="dg" title="交往记录管理" style="width:700px;height:250px"
		   toolbar="#toolbar" idField="id" rownumbers="true" fitColumns="true" singleSelect="true">
	  <thead>
	  	<tr>
	  		<th field="id" width="50">编号</th>
	  		<th field="contactTime" width="100" editor="{type:'datebox',options:{required:true}}">交往时间</th>
	  		<th field="address" width="200" editor="{type:'validatebox',options:{required:true}}">交往地址</th>
	  		<th field="overView" width="300" editor="{type:'validatebox',options:{required:true}}">概要</th>
	  	</tr>
	  </thead>
	</table>
 
	<!-- 状态栏 -->
	<div id="toolbar">
		<!-- 以下是easyui组件 -->
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true" onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
	</div>

</body>
</html>