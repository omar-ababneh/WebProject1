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
table{
width:100%;
}
</style>
</head>

<body>
<h1 style="text-align:center">Hello Dr.${FName}</h1>
<br>
  <form action="logout"  method="POST">
    <button type="submit" name="logout" class="design">Logout</button>
    </form>
<table>
  <tr>
    <th>Course</th>
  </tr>
<c:forEach items="${Courses}" var="entry">
    <tr>
    <td>
    <form action="courseinfo" method="POST">
    <button type="submit" name="CID" value=${entry.key}>${entry.value}</button>
    </form>
    </td>
    </tr>
</c:forEach>
 </table>
</body>
</html>
