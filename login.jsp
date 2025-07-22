<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login</title>
  <style>
    body {
      background-color: black;
      color: white;
      font-family: 'Segoe UI', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .form-container {
      background-color: #1c1c1c;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 0 10px orangered;
      width: 300px;
    }
    .form-container h2 {
      color: orangered;
      text-align: center;
      margin-bottom: 20px;
    }
    input {
      width: 100%;
      padding: 10px;
      margin-bottom: 15px;
      background-color: #333;
      color: white;
      border: none;
      border-radius: 5px;
    }
    button {
      width: 100%;
      padding: 10px;
      background-color: orangered;
      color: white;
      border: none;
      border-radius: 5px;
      font-weight: bold;
      cursor: pointer;
    }
    button:hover {
      background-color: darkorange;
    }
    p {
      text-align: center;
      margin-top: 10px;
    }
    a {
      color: orangered;
      text-decoration: none;
    }
  </style>
</head>
<body>
  <div class="form-container">
    <h2>Welcome Back</h2>
    <form action="login">
      <input type="text" name="userName"  placeholder="User Name" required />
      <input type="password" name="password" placeholder="Password" required />
      <button type="submit">Login</button>
    </form>
    <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
  </div>
</body>
</html>