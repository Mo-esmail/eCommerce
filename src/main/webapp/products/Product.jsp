<%@page import="eCommerce.models.Product"%>
<%@page import="eCommerce.JDBCControl.JDBCControler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<%String j=request.getParameter("product");
	JDBCControler worker = new JDBCControler();
	Product product=worker.getProduct(j); %> 
<html>
	<head>
		<title><%=product.getName() %></title>
		<style>
			body{
			background: #48BCE2;
			}
	</style>
	</head>
	<body>
		<h1><%=product.getName()%></h1>
		<p>
			<img src="<%=product.getImgSrc()%>" alt="photo missing" style="float:left;width:200px;height:200px;">
			<%=product.getDescription() %>
		</p>
		<h3>price</h3>
		<b><%=product.getPrice() %> EGP</b>
	</body>
</html>