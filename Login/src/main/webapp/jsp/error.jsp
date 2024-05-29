<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

失敗しました、もう一度やり直してください。
 <p>An error occurred: <%= request.getAttribute("errorMessage") %></p>

<%@include file="../footer.html" %>