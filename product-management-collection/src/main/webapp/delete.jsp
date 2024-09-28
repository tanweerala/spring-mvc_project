<%@ include file="menu.jsp" %>
<html>
 <body>
  <form action="delete-record">
   <table class='frmta' style='background-color:red;color:white'>
    <tr>
     <td class='pa'>Enter product id</td>
     <td class='pa'><input type='text' name='pid' class='tb' required></td>
     <td class="pa" colspan="2" align="right">
     <button class="bt">Delete Record</button></td>
    </tr>
   </table>
   <div style="text-align:center;margin-top:20px">
      <label style='color:red;font-size:20'>${msg}</label>
   </div>
  </form>
 </body>
</html>