<%@page contentType="text/html; charset=UTF-8" %>

<%@include file="../header.html" %>

<form action="<%= request.getContextPath() %>/jp/co/aforce/Login.action" method="post">

<p>ログイン名<input type="text" name="username"></p>
<p>パスワード<input type="text" name="password"></p>
<p><input type="submit" value="ログイン"></p>

</form>

<p>
	<a href="<%= request.getContextPath() %>/jsp/register.jsp">会員登録が済んでいない人はこちら
	</a>
</p>

<%@include file="../footer.html" %>