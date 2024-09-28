<%@ page import="java.sql.*"%>
<html>
 <head>
  <script src="/timeout-timein-tracker/JS/script.js"></script> 
  <link href='/timeout-timein-tracker/CSS/style.css' rel='stylesheet'>
  <link href='/timeout-timein-tracker/CSS/bootstrap.min.css' rel='stylesheet'>
 </head>
 <body bgcolor='cyan'>
   <hr style='border:2px solid green'>
    <nav class='navbar navbar-expand navbar-light bg-light'>
    <label style='font-size:2vw'>Hi, ${sessionScope.name}</label>
     <ul class='nav nav-pills mx-auto'>
      <li><a id="home1" class='nav-link lau' href='/timeout-timein-tracker/tracker/home'>Home</a>
      <li><a id='out' class='nav-link lau' href='/timeout-timein-tracker/tracker/timeout/elist'>Time Out</a>
      <li><a id='in' class='nav-link lau' href='/timeout-timein-tracker/tracker/timein/elist'>Time In</a>
      <li><a id='date' class='nav-link lau' href='/timeout-timein-tracker/tracker/reports/datewise/date'>Date wise report</a>
      <li><a id='emp' class='nav-link lau' href=''>Employee wise report</a>
      <li><a id='emp' class='nav-link lau' href='/timeout-timein-tracker/tracker/logout'>Logout</a>
     </ul>
    </nav>
   <hr style='border:2px solid green'>
 </body>
</html>