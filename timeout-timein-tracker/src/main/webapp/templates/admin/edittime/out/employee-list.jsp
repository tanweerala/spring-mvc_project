<%@ include file="../../navbar.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
 <body onload="makeActive('editout')">
 <form action="edit-outtime">
  <div class='dv'>
   <label class='hdu' style='background-color:orange'>Edit out time entry</label>
  </div>
  <div class='dv'>
   <select name="weid" id="weid" class='la'>
   	 <option value="-1">Select Wrong Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	  <option value="${emp.eid}">${emp.firstname} ${emp.lastname}(${emp.eid})</option>
   	 </c:forEach>
   </select>
   <select name="reid" id="reid" class='la'>
   	 <option value="-1">Select Right Employee</option>
   	 <c:forEach var="emp" items="${elist}">
   	  <option value="${emp.eid}">${emp.firstname} ${emp.lastname}(${emp.eid})</option>
   	 </c:forEach>
   </select>
  </div>
  <div class='dv'>
   <button id='bt' class='btn btn-primary'>Submit</button>
  </div>
  <div class='dvv' id='msg'>
  </div> 
 </form> 
 </body>
</html>