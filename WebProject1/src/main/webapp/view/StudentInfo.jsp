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
  <form action="logout"  method="POST">
    <button type="submit" name="logout" class="design">Logout</button>
    </form>
    <br>
    <br>
<table style="width:100%">
<tr>
    <th>Student</th>
    <th>Grade</th>
  </tr>
<c:forEach items="${Student}" var="entry">
    <tr>
          <td>${entry.value.getFName()}</td>
          <form action="savechangegrade" method="POST">
          <td><input type="text" value=${entry.value.getGrade()} name="Grade" required></td>
          <input type="hidden" name="SID"  value=${entry.key}>
          <td>
            <button type="submit">Save grade</button>
          </td>
            </form>
    </tr>
</c:forEach>
 </table>
</body>
</html>

