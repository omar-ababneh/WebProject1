<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

input[type=text], input[type=password] {
  width: 40%;
  padding: 10px;
  margin: 8px;
  display: inline-block;
  border: 1px solid #ccc;
   margin-left: 390px;
}

button {
  background-color: #9999FF;
  color: white;
  padding: 10px;
  margin: 40px;
  border: none;
  cursor: pointer;
  width: 40%;
  margin-left: 400px;
}
.container {
  padding: 10px;
}
</style>
</head>
<body>

<h2>Login Form</h2>
<p><font color="red">${errorMessage}</font></p>
<form action="viewprocess" method="post">
  <div class="container">
    <input type="text" placeholder="Enter Email" name="email" required><br>
    <input type="password" placeholder="Enter Password" name="psw" required><br>
    <button type="submit">Login</button>
  </div>
</form>
</body>
</html>

