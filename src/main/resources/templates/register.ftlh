<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container"><form action="/register" method="post">

  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  <label for="name">Name</label><br>
  <input type="text" id="name" name="name" required><br><br>

  <label for="email">Email</label><br>
  <input type="email" id="email" name="email" required><br><br>

  <label for="password">Password</label><br>
  <input type="password" id="password" name="password" required><br><br>

  <label for="login">Username</label><br>
  <input type="text" id="login" name="login"><br><br>
  <input type="hidden" id="enabled" name="enabled" value="true">
  <label for="role">Role</label><br>
  <select id="role" name="role" required>
    <option value="DEVELOPER">Developer</option>
    <option value="MANAGER">Manager</option>
  </select><br><br>


  <input type="submit" value="Register">
</form></div>


</body>
</html>