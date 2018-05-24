<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
    <h1>修改类型</h1>
    <a href="${pageContext.request.contextPath}/findAllTypes.do">返回商品类型列表</a>
    <hr/>
    
    <form action="${pageContext.request.contextPath}/modifyType.do" method="post">
    	<input type="hidden" name="id" value="${type.id }"><br/>
    	类型:<input type="text" name="name" value="${type.name }" /><br/>
    	<input type="submit" value="修改">
    </form>
  </body>
</html>
