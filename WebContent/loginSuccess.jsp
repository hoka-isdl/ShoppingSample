<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="mybeans.ShoppingDBBean" %>
<jsp:useBean id="cb" class="mybeans.ShoppingDBBean" scope="request"/>

<%String name=cb.getname(); %>

<!DOCTYPE html>
<html>
<head>
<title></title>
</head>
<body background="background.jpg">

<div style="text-align: center;">
<h2>認証成功</h2>
<hr/>
ようこそショッピングサイトへ！<br/>
<br/>
<%=name %>様

<br/>
<form action="http://localhost:8080/ShoppingSample/purchase.jsp" method="GET">
<table border="1" align="center">
　<tr>
　　<th>商品</th> <th>値段</th>
　</tr>
　<tr>
　　<td><img src="car.jpg" width="150" height="150"/></td>
<td>１００万円<br/><input type="submit" value="購入"/></td>
　</tr>
</table>
<br/>

<table border="1" align="center">
　<tr>
　　<th>商品</th><th>値段</th>
　</tr>
　<tr>
　　<td><img src="car2.jpg" width="150" height="150"/></td><td>１５０万円<br/><input type="submit" value="購入"/></td>
　</tr>
</table>
<br/>

<table border="1" align="center">
　<tr>
　　<th>商品</th><th>値段</th>
　</tr>
　<tr>
　　<td><img src="car3.jpg" width="150" height="150"/></td><td>３００万円<br/><input type="submit" value="購入"/></td>
　</tr>
</table>
<br/>
</form>
</div>

</body>
</html>