<html>
 <body>
  <form action="login-authentication" method="post">
   <table style='border:3px solid silver;font-size:20px' cellpadding='10px'>
    <tr>
     <td>Enter user name</td>
     <td><input type="text" value="${name}" name="username" style="font-size:19px" required></td>
    </tr>  
    <tr>
     <td>Enter password</td>
     <td><input type="password" name="password" style="font-size:19px" required></td>
    </tr>
    <tr>
     <td colspan="2" align="right">
      <button style="font-size:18px">Submit</button>
     </td>
    </tr>
    <tr>
     <td colspan="2" align="center">
      <label style="color:red;font-size:19px">${msg}</label>
     </td>
    </tr>
   </table>
  </form>
 </body>
</html>