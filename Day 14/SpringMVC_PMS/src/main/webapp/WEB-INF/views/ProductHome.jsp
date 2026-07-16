<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Management System</title>
</head>
<body>

	<h2 align="center">Product Management System</h2>

	<form action="product" method="post">

		<table align="center">

			<tr>
				<td>Product ID</td>
				<td><input type="text" name="pid"></td>
			</tr>

			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname"></td>
			</tr>

			<tr>
				<td>Product Price</td>
				<td><input type="text" name="pprice"></td>
			</tr>

			<tr>
				<td>Product Quantity</td>
				<td><input type="text" name="pquantity"></td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="Insert" value="Insert">
					<input type="submit" name="Update" value="Update">
					<input type="submit" name="Delete" value="Delete">
					<input type="submit" name="Find" value="Find">
					<input type="submit" name="FindAll" value="FindAll">
				</td>
			</tr>

			<tr>
				<td colspan="2" align="center">
					${result}
				</td>
			</tr>

		</table>

	</form>

</body>
</html>