<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <h1>商品添加</h1>
    <hr/>
    
    <form action="${pageContext.request.contextPath}/addProduct.do" method="post">
    	商品名称:<input type="text" name="name"/><br/>
    	商品价钱:<input type="text" name="price"/><br/>
    	商品类型:
    		<select name="typeId">
    			<option value="-1">--请选择--</option>
    			<c:forEach items="${types }" var="type">
    				<option value="${type.id }">${type.name }</option>
    			</c:forEach>
    		</select>
    	<br/>
    	<input type="submit" value="添加"/>
    	<span style="color:red;">${typeMsg }</span>
    </form> 
  </body>
</html>
