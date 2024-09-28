<%@ include file="menu.jsp" %>
<html>
 <body>
  <form action="update-record">
  <table class='listta' border='1'>
	<tr style='background-color:orange;color:white;font-size:22px'>
	 <th colspan="2" align="center">Product Details</th>
	</tr>  
	<tr>
	 <th align="left">Product Id</th>
	 <td>${product.pid}<input type="hidden" name="pid" value="${product.pid}"></td>
	</tr>
	<tr>
	 <th align="left">Product name</th>
	 <td><input type="text" name="name" value="${product.name}" style="font-size:18px;width:100%"></td>
	</tr>
	<tr>
	 <th align="left">Product brand</th>
	 <td><input type="text" name="brand" value="${product.brand}" style="font-size:18px;width:100%"></td>
	</tr>
	<tr>
	 <th align="left">Product price</th>
	 <td><input type="text" name="price" value="${product.price}" style="font-size:18px;width:100%"></td>
	</tr>
	<tr>
	 <td colspan="2" align="right">
	  <button class='bt' style="background-color:black">Update Record</button>
	 </td>
	</tr>
  </table>
  </form>
 </body>
</html>