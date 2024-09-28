<%@ include file="menu.jsp" %>
<html>
 <body>
  <table class='listta' border='1'>
	<tr style='background-color:orange;color:white;font-size:22px'>
	 <th colspan="2" align="center">Product Details</th>
	</tr>  
	<tr>
	 <th align="left">Product Id</th>
	 <td>${product.pid}</td>
	</tr>
	<tr>
	 <th align="left">Product name</th>
	 <td>${product.name}</td>
	</tr>
	<tr>
	 <th align="left">Product brand</th>
	 <td>${product.brand}</td>
	</tr>
	<tr>
	 <th align="left">Product price</th>
	 <td>${product.price}</td>
	</tr>
  </table>
 </body>
</html>