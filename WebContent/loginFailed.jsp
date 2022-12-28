<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<jsp:useBean id="cb" class="mybeans.ShoppingDBBean" scope="request"/>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body>
<div style="text-align: center;">
<h2>認証失敗</h2>
<hr/>
<br/>
<br/>
<form action="http://localhost:8080/ShoppingSample/login.html" method="GET">

<input type="submit" value="ログイン画面に戻る"/>
</form>

</div>
</body>
</html>