<%@ include file="menu.jsp" %>
<html>
 <body>
  <form action="save-record" method="post">
   <table class='frmta'>
    <tr>
     <td class='pa'>Enter product id</td>
     <td class='pa'><input type='text' name='pid' class='tb' required></td>
    </tr>
     <tr>
     <td class='pa'>Enter product name</td>
     <td class='pa'><input type='text' name='name' class='tb' required></td>
    </tr>
     <tr>
     <td class='pa'>Enter product brand</td>
     <td class='pa'><input type='text' name='brand' class='tb' required></td>
    </tr>
     <tr>
     <td class='pa'>Enter product price</td>
     <td class='pa'><input type='text' name='price' class='tb' required></td>
    </tr>
    <tr>
     <td class="pa" colspan="2" align="right">
       <button class="bt">Save Record</button>
     </td>
    </tr>
   </table>
  </form>
 </body>
</html>