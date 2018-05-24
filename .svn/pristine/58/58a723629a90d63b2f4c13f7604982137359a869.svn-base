<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <h1>商品修改</h1>
    <a>返回查询</a>
    <hr/>
    
     <form action="${pageContext.request.contextPath}/modifyProduct.do" method="post">
     	<input type="hidden" name="id" value="${product.id }">
    	商品名称:<input type="text" name="name" value="${product.name }"/><br/>
    	商品价钱:<input type="text" name="price" value="${product.price }"/><br/>
    	商品类型:
    		<select name="typeId">
    			<option value="-1">--请选择--</option>
    			<c:forEach items="${types }" var="type">
    				<option value="${type.id }" ${type.id eq product.typeId ? "selected" :"" }>${type.name }</option>
    			</c:forEach>
    		</select>
    	<br/>
    	<input type="submit" value="修改"/>
    	<span style="color:red;">${typeMsg }</span>
    </form> 
  </body>
</html>
