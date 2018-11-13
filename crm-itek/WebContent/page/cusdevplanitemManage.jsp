<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	// 页面加载完成后执行该方法
	$(function(){
		$.post("${pageContext.request.contextPath}/saleChance/findById.do", // 通过id查找到具体信息，填充到营销机会信息单中
			{id:'${param.saleChanceId}'},
			function(result){
				 $("#customerName").val(result.customerName);
				 $("#chanceSource").val(result.chanceSource);
				 $("#linkMan").val(result.linkMan);
				 $("#linkPhone").val(result.linkPhone);
				 $("#cgjl").val(result.cgjl);
				 $("#overView").val(result.overView);
				 $("#description").val(result.description);
				 $("#createMan").val(result.createMan);
				 $("#createTime").val(result.createTime);
				 $("#assignMan").val(result.assignMan);
				 $("#assignTime").val(result.assignTime);
			},"json");
		
		// 操作表格，easyui固定写法，加接口地址url
		$("#dg").edatagrid({
			url:'${pageContext.request.contextPath}/cusDevPlan/list.do?saleChanceId=${param.saleChanceId}',
			saveUrl:'${pageContext.request.contextPath}/cusDevPlan/save.do?saleChance.id=${param.saleChanceId}',
			updateUrl:'${pageContext.request.contextPath}/cusDevPlan/save.do?saleChance.id=${param.saleChanceId}',
			destroyUrl:'${pageContext.request.contextPath}/cusDevPlan/delete.do'
		 });
	});
	
	// 更改开发状态，设置为：开发成功或者终止开发，通过更改devResult的数值
	// devResult,2:开发成功,3:终止开发
	function updateSaleChanceDevResult(devResult){
		 $.post("${pageContext.request.contextPath}/cusDevPlan/updateSaleChanceDevResult.do",
			 	{id:'${param.saleChanceId}',
			 	 devResult:devResult},
			 	function(result){
					 if(result.success){
						 $.messager.alert("系统提示","执行成功！");
					 }else{
						 $.messager.alert("系统提示","执行失败！");
					 }
				 },"json");
	 }
</script>
<title>客户开发计划项管理</title>
</head>
<body style="margin: 15px">
	<!-- 上半部分:销售机会信息预览，只读状态，不允许修改 -->
	<!-- easyui的panel组件 -->
	<div id="p" class="easyui-panel" title="销售机会信息" style="width: 700px;height: 400px;padding: 10px"> 
		<table cellspacing="8px">
	 		<tr>
	 			<td>客户名称：</td>
	 			<td><input type="text" id="customerName" name="customerName" readonly="readonly"/></td>
	 			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 			<td>机会来源</td>
	 			<td><input type="text" id="chanceSource" name="chanceSource" readonly="readonly"/></td>
	 		</tr>
	 		<tr>
	 			<td>联系人：</td>
	 			<td><input type="text" id="linkMan" name="linkMan" readonly="readonly"/></td>
	 			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 			<td>联系电话：</td>
	 			<td><input type="text" id="linkPhone" name="linkPhone" readonly="readonly"/></td>
	 		</tr>
	 		<tr>
	 			<td>成功几率(%)：</td>
	 			<td><input type="text" id="cgjl" name="cgjl" readonly="readonly"/></td>
	 			<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
	 		</tr>
	 		<tr>
	 			<td>概要：</td>
	 			<td colspan="4"><input type="text" id="overView" name="overView" style="width: 420px" readonly="readonly"/></td>
	  		</tr>
	  		<tr>
	  			<td>机会描述：</td>
	  			<td colspan="4">
	  				<textarea rows="5" cols="50" id="description" name="description" readonly="readonly"></textarea>
	  			</td>
	  		</tr>
	  		<tr>
	  			<td>创建人：</td>
	  			<td><input type="text" id="createMan" name="createMan" readonly="readonly"/></td>
	  			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  			<td>创建时间：</td>
	  			<td><input type="text" id="createTime" name="createTime" readonly="readonly"/></td>
	  		</tr>
	  		<tr>
	  			<td>指派给：</td>
	  			<td>
	  				<input type="text" id="assignMan" name="assignMan" readonly="readonly" />
	  			</td>
	  			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
	  			<td>指派时间：</td>
	  			<td><input type="text" id="assignTime" name="assignTime" readonly="readonly"/></td>
	  		</tr>
	  	</table>
	</div>
	
	<br/> <!-- 分割线 -->
	
	<!-- 下半部分：客户开发计划项 -->
 	<table id="dg" title="开发计划项" style="width:700px;height:250px" toolbar="#toolbar" idField="id" 
 		   rownumbers="true" fitColumns="true" singleSelect="true">
	   <thead>
	   	<tr>
	   		<th field="id" width="50">编号</th>
	   		<th field="planDate" width="50" editor="{type:'datebox',options:{required:true}}">日期</th>
	   		<th field="planItem" width="100" editor="{type:'validatebox',options:{required:true}}">计划内容</th>
	   		<th field="exeAffect" width="100" editor="{type:'validatebox',options:{required:true}}">执行效果</th>
	   	</tr>
	   </thead>
	</table>
	
	<!-- 下半部分工具栏 -->
	<!-- href="javascript:void(0)"：表示超链接不进行任何操作 -->
	<div id="toolbar">
		<!-- 注意：使用c标签一定要导入c标签库 -->
	 	<c:if test="${param.show!='true'}">  <!-- 通过show属性来控制下面toolbar的有无
	 											  开发：需要toolbar  查看详情：不需要toolbar -->
	 		<!-- 以下是easyui的固定写法方式 -->
		 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="javascript:$('#dg').edatagrid('addRow')">添加计划</a>
		 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="javascript:$('#dg').edatagrid('destroyRow')">删除计划</a>
		 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:$('#dg').edatagrid('saveRow');$('#dg').edatagrid('reload')">保存计划</a>
		 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true" onclick="updateSaleChanceDevResult(2)">开发成功</a>
		 	<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-zzkf" plain="true" onclick="updateSaleChanceDevResult(3)">终止开发</a>
	 	</c:if>
	</div>
</body>
</html>