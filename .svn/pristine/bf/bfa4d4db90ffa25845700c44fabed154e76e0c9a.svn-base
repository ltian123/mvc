<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    <h1>商品列表</h1>
    <a href="${pageContext.request.contextPath}/showMenu.do">返回主页</a>
    <a href="${pageContext.request.contextPath}/toAddProduct.do">添加商品</a>
    <hr/>
    ${modifyMsg }
    <table border="1">
    	<tr>
    		<!-- 只显示有效商品
    			如果将商品类型状态改为禁用,则不显示所有该类型的商品的信息
    		 -->
    		<th>序号</th>
    		<th>商品名称</th>
    		<th>商品价钱</th>
    		<th>商品类型</th><!-- 类型的名称 -->
    		<th>操作</th>
    	</tr>
    	
    	<c:forEach items="${productVos }" var="p" varStatus="i">
    		<tr>
    			<td>${i.index + 1 }</td>
    			<td>${p.name }</td>
    			<td>${p.price }</td>
    			<td>${p.typeName }</td>
    			<td>
    				<a href="${pageContext.request.contextPath}/toModifyProduct.do?id=${p.id}">修改</a>
    				<a>删除</a>
    			</td>
    		</tr>
    	</c:forEach>
    </table>
  </body>
</html>
