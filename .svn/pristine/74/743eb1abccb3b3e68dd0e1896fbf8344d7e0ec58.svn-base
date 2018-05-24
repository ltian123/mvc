<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  	
  </script>
  </head>
  
  <body>
    <h1>商品类型列表</h1>
    <a href="${pageContext.request.contextPath}/toAddType.do">添加商品类型</a>
    <a href="${pageContext.request.contextPath}/showMenu.do">返回主页</a>
    <hr/>
    <span>${typeMsg }</span>
    <table border="1">
    	<tr>
    		<th>序号</th>
    		<th>名称</th>
    		<th>状态</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${types }" var="type" varStatus="i">
    	<tr>
    		<td>${i.index+1 }</td>
    		<td>${type.name }</td>
    		<td>
    			<c:choose>
	    			<c:when test="${type.status == 1 }">启用</c:when>
	    			<c:otherwise>禁用</c:otherwise>
    			</c:choose>
    		</td>
    		<td>
    			<a href="${pageContext.request.contextPath}/toModifyType.do?id=${type.id}">修改</a>
    			<c:choose>
	    			<c:when test="${type.status == 1 }">
	    				<a href="${pageContext.request.contextPath}/modifyStatus.do?id=${type.id }&status=${type.status}">
	    					<span style="color:red;">禁用</span>
	    				</a>
	    			</c:when>
	    			<c:otherwise>
	    				<a href="${pageContext.request.contextPath}/modifyStatus.do?id=${type.id }&status=${type.status}">
	    					<span style="color:green;">启用</span>
	    				</a>
	    			</c:otherwise>
    			</c:choose>
    		</td>
    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
