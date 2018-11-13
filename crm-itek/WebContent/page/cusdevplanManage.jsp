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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
	
	//查询客户开发计划
	function searchSaleChance(){
		 $("#dg").datagrid('load',{
			"customerName":$("#s_customerName").val(), 
			"overView":$("#s_overView").val(), 
			"devResult":$("#s_devResult").combobox("getValue")
		 });
	}
	
	//格式化状态
	function formatState(val,row){
		 if(val==1){
			 return "已分配";
		 }else{
			 return "未分配";
		 }
	}
	
	//格式化客户开发状态
	function formatDevResult(val,row){
		 if(val==0){
			 return "未开发";
		 }else if(val==1){
			 return "开发中";
		 }else if(val==2){
			 return "开发成功";
		 }else if(val==3){
			 return "开发失败";
		 }
	}
	
	// 格式化操作
	function formatAction(val,row){
		if(row.devResult==0||row.devResult==1){ // 客户状态是未开发或者开发中
		 	return "<a href='javascript:openCusDevPlanTab("+row.id+")'>开发</a>"; // 通过嵌入html片段实现
		}else{ // 客户状态是开发成功或者开发失败
		 	return "<a href='javascript:openCusDevPlanTab2("+row.id+")'>查看详细信息</a>";// 通过嵌入html片段实现
		}
	}

	//打开开发计划Tab页--开发
	function openCusDevPlanTab(id){
		window.parent.openTab('客户开发计划项管理','cusdevplanitemManage.jsp?saleChanceId='+id,'icon-khkfjh');
	}
	
	//打开开发计划Tab页--查看详细信息
	function openCusDevPlanTab2(id){
		window.parent.openTab('查看客户开发计划项','cusdevplanitemManage.jsp?saleChanceId='+id+'&show=true','icon-khkfjh');
	}
</script>
<title>客户开发计划管理</title>
</head>
<body>
	<table id="dg" title="客户开发计划管理" class="easyui-datagrid" fitColumns="true" pagination="true" rownumbers="true"
	 	   url="${pageContext.request.contextPath}/saleChance/list.do?state=1" fit="true" toolbar="#tb"> <!-- 通过state=1,查找到状态为已开发的营销机会 -->
	  <thead>
	  	<tr>
	  		<th field="cb" checkbox="true" align="center"></th>
	  		<th field="id" width="50" align="center">编号</th>
	  		<th field="chanceSource" width="200" align="center" hidden="true">机会来源</th>
	  		<th field="customerName" width="80" align="center">客户名称</th>
	  		<th field="cgjl" width="50" align="center" hidden="true">成功几率</th>
	  		<th field="overView" width="150" align="center">概要</th>
	  		<th field="linkMan" width="80" align="center">联系人</th>
	  		<th field="linkPhone" width="100" align="center" hidden="true">联系电话</th>
	  		<th field="description" width="200" align="center" hidden="true">机会描述</th>
	  		<th field="createMan" width="80" align="center">创建人</th>
	  		<th field="createTime" width="150" align="center">创建时间</th>
	  		<th field="assignMan" width="50" align="center" >指派人</th>
	  		<th field="assignTime" width="150" align="center" >指派时间</th>
	  		<th field="state" width="100" align="center" formatter="formatState" hidden="true">状态</th>
	  		<th field="devResult" width="100" align="center" formatter="formatDevResult">客户开发状态</th>
	  		<th field="a" width="100" align="center" formatter="formatAction">操作</th>  <!-- 这里是重点，在jsp中嵌入html片段，达到功能 -->
	  	</tr>
	  </thead>
	</table>
	<div id="tb">
		<div>
			&nbsp;客户名称：&nbsp;<input type="text" id="s_customerName" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;概要：&nbsp;   <input type="text" id="s_overView" size="20" onkeydown="if(event.keyCode==13) searchSaleChance()"/>
			&nbsp;客户开发状态：&nbsp;<select class="easyui-combobox" id="s_devResult" editable="false" panelHeight="auto" >
									<option value="">请选择...</option>	
									<option value="0">未开发</option>
									<option value="1">开发中</option>	
									<option value="2">开发成功</option>	
									<option value="3">开发失败</option>					
			                    </select>
			<a href="javascript:searchSaleChance()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
		</div>
	</div>
</body>
</html>