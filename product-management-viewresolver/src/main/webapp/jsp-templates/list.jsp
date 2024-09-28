<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menu.jsp" %>
<html>
 <body>
  <table class='listta' border='1'>
   <tr>
    <th>Product id</th><th>Product name</th><th>Product brand</th><th>Product price</th>
   </tr>
   <c:forEach var="product" items="${productList}">
     <tr>
      <td>${product.pid}</td>
      <td>${product.name}</td>
      <td>${product.brand}</td>
      <td>${product.price}</td>
     </tr>
   </c:forEach>
  </table>
  </body>
</html>