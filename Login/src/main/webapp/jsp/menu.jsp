<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Page</title>
</head>
<body>
    <h2>Menu</h2>
    <p>ようこそ、${sessionScope.customer.username} さん。</p>
    <!-- 其他菜单内容 -->
    
    <!-- 返回按钮 -->
    <form action="<%= request.getContextPath() %>/jsp/loginout.jsp" method="get">
        <button type="submit">戻る</button>
    </form>
</body>
</html>
