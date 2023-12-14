
<%@page import="eCommerce.models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eCommerce.JDBCControl.JDBCControler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
	<html>
		<head>
			<meta name='viewport' content='width=device-width, initial-scale=1.0'>
			<title>Home page</title>
			<style>
			body{
			background: #48BCE2;
			}
				table {
 				   font-family: arial, sans-serif;
 				   border-collapse: collapse;
 				   width: 100%;
				}

				td, th {
				    border: 1px solid #0c80a6;
				    text-align: left;
				    padding: 8px;
				}

				tr:nth-child(even) {
				    background-color: #2094ba;
				}
				#a{color:black;text-decoration: none;}
			</style>
		</head>
		<body>
			<table>
				<tr>
					<th>Product</th>
					<th>Price</th>
				</tr>
				<%JDBCControler controler=new JDBCControler();
				ArrayList<Product> products=controler.getAllProducts();
				int i=products.size();
				for(int s=0;s<i;s++)
					out.println("<tr>"+
						    "<td><a id='a' href='http://localhost:8080/Souq/products/Product.jsp?product="+products.get(s).getID()+"'>"+products.get(s).getName()+"</a></td>"+
						    "<td>"+products.get(s).getPrice()+" EGP</td>"+
						  "</tr>");
				%>
				<tr>
					<td><a id='a' href="Admins_LogIn.html">Add product</a></td>
					<td>For Admins only</td>
						  </tr>
			</table>
		</body>
	</html>