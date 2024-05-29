<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<%
jp.co.aforce.bean.Customer customer = (jp.co.aforce.bean.Customer) session.getAttribute("customer");

if(customer != null) {
%>
    <p>ログイン成功！</p>
    <p>ようこそ、<%= customer.getUsername() %> さん。</p>
    
    <!-- 在 3 秒后重定向到 menu.jsp -->
    <script type="text/javascript">
        setTimeout(function() {
            window.location.href = '<%= request.getContextPath() %>/jsp/menu.jsp';
        }, 3000); // 3000 毫秒 = 3 秒
    </script>
<%
} else {
%>
    <p>ログインしていません。</p>
<%
}
%>
<a href="<%= request.getContextPath() %>/jp/co/aforce/Logout.action">ログアウト</a>

<%@include file="../footer.html" %>



