<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="<%= request.getContextPath() %>/jp/co/aforce/Register.action" method="post">
    <p>ユーザー名：<input type="text" name="username"></p>
    <p>パスワード：<input type="password" name="password"></p>
    <p><input type="submit" value="登録"></p>   
</form>

<%@include file="../footer.html" %>
