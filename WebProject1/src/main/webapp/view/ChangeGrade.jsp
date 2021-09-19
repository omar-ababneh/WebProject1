<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style>
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

<body style="text-align:center">
  <form action="logout"  method="POST">
    <button type="submit" name="logout" class="design">Logout</button>
    </form>
 <form action="savechangegrade" method="POST">
<input type="text" placeholder="Enter New Grade" name="Grade" required><br><br>
<button type="submit">Save</button>
</form>
</body>
</html>
