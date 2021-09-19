<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
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
th,td{
text-align:center;
font-size:20px;
color:blue;
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
  </tr>
    <tr>
    <td>
    <form  method="POST">
    <button type="submit" formaction="ViewCreateCourse.do" >Create Course</button>
    <button type="submit" formaction="ViewAddStudent.do" >Add Student</button>
    <button type="submit" formaction="ViewAddInstructor.do" >Add Instructor</button>
    <button type="submit" formaction="ViewAddAdmin.do">Add New Admin</button>
    </form>
    </td>
    </tr>
 </table>
</body>
</html>
