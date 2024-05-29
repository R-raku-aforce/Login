<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="<%= request.getContextPath() %>/jp/co/aforce/Login.action" method="post">
    <p>ログイン名<input type="text" name="username" value="<%= (request.getParameter("username") != null) ? request.getParameter("username") : "" %>"></p>
    <p>パスワード<input type="password" name="password"></p>
    <p><input type="submit" value="ログイン"></p>

    <!-- 显示错误消息 -->
    <% 
        // 检查是否有错误消息
        String error = (String) request.getSession().getAttribute("error");
        if (error != null && !error.isEmpty()) {
    %>
        <p style="color: red;"><%= error %></p>
    <% } %>
</form>

<p>
    <a href="<%= request.getContextPath() %>/jsp/register.jsp">会員登録が済んでいない人はこちら</a>
</p>

<%@include file="../footer.html" %>


