<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
th,td{
text-align:center;
font-size:20px;
color:blue;
}
button {
  background-color: #9999FF;
  color: white;
  text-align:center
  padding: 10px;
  border: none;
  cursor: pointer;
  width: 40%;
}
.design{
   top: 0px;
   right: 0px;
   position: absolute;
   background-color: #9999FF;
   color: white;
   padding: 10px;
   border: none;
   cursor: pointer;
   width: 20%;
}
</style>
</head>

<body>
<h1 style="text-align:center">Hello ${FName}</h1>
<br>
  <form action="logout"  method="POST">
    <button type="submit" name="logout" class="design">Logout</button>
    </form>
<table style="width:100%">
  <tr>
    <th>Course</th>
    <th>Grade</th>
  </tr>
<c:forEach items="${Courses}" var="entry">
    <tr>
          <td> ${entry.key}</td>
          <td> ${entry.value}</td>
    </tr>
</c:forEach>
 </table>
</body>
</html>

