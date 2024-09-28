<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <%@ include file="add-css.jsp" %>
 <body>
  <div class='dvv'>
   <label class='lah'>Account Dashbaord</label>
  </div>
  <div class='container'>
  <a href='add' class='la'><i class='fa fa-user-plus'></i>Create Account</a>
   <div class='card col-md-12 mx-auto'>
    <div class='card-body'>
      <c:if test="${alist=='[]'}">
      <div class='dv'>
         <label class='la' style='color:red'>Account dash board has no record</label>
       </div>
      </c:if>
     <c:if test="${alist!='[]'}">
     <div class='table scrollit'>
     <table class='table table-hover'>
      <thead>
       <tr>
        <th>User id</th><th>User Password</th>
        <th>User Name</th><th>User Phone</th>
        <th style='color:blue'>Action</th>
       </tr>
      </thead>
      <tbody>
      <c:forEach var="user" items="${alist}">
        <tr>
    	   <td>${user.userid}</td>
    	   <td>${user.password}</td>
    	   <td>${user.name}</td>
    	   <td>${user.phone}</td>
    	   <td>
    	      <a href='edit-record?uid=${user.userid}'>Edit |</a>
    	      <a href='delete-record?uid=${user.userid}' onclick='return confirm("Are you sure to delete?")'>Delete</a>
    	   </td>
    	  </tr>
    	</c:forEach>  
      </tbody>
     </table>
     </div>
     </c:if>
    </div>
   </div>
   <a href='/timeout-timein-tracker/admin/home' class='la'><i class='fa fa-home'></i>Home</a>
  </div>
 </body>
</html>