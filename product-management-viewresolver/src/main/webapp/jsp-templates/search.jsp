<%@ include file="menu.jsp" %>
<html>
 <body>
  <form action="search-record">
   <table class='frmta' style='background-color:gray;color:white'>
    <tr>
     <td class='pa'>Enter product id</td>
     <td class='pa'><input type='text' name='pid' class='tb' required></td>
     <td class="pa" colspan="2" align="right">
     <button class="bt">Search Record</button></td>
    </tr>
    <tr>
     <td colspan="3" align="center">
      <h3 style='color:red'>${msg}</h3>
     </td>
    </tr>
   </table>
  </form>
 </body>
</html>