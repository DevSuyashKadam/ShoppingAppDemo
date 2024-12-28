<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Product Form</title>
</head>
<body>
<h3> Add Product here </h3>
<form action="add_Product" method="post">
<table style="width: 20%">
                 <tr>
                 <td>Product</td>
                                    <td><input type="text" name="product_id" /></td>
                         </tr>
                                    <tr>
                                    <td>ProductName</td>
                                    <td><input type="text" name="product_name" /></td>
                           </tr>
                 </table>
                 <input type="submit" value="submit_Product" /></form>
</body>
</html>