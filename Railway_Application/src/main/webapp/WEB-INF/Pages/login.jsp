

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login - Railway Reservation System</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
            background-size: cover;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: white;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            background-color: rgba(0, 0, 0, 0.7);
            padding: 40px 30px;
            border-radius: 10px;
            width: 350px;
            box-sizing: border-box;
            text-align: center;
        }

        h2 {
            margin-bottom: 25px;
            font-weight: bold;
            color: #ff5733;
        }

        label {
            display: block;
            text-align: left;
            margin-bottom: 8px;
            font-weight: bold;
            font-size: 1em;
            color: #ccc;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: none;
            border-radius: 5px;
            font-size: 1em;
        }

        input[type="submit"] {
            background-color: #ff5733;
            border: none;
            color: white;
            font-weight: bold;
            padding: 12px;
            width: 100%;
            border-radius: 30px;
            cursor: pointer;
            font-size: 1em;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #e84118;
        }

        .forgot-password {
            margin-top: 15px;
        }

        .forgot-password a {
            color: #3399ff;
            text-decoration: none;
            font-size: 0.9em;
        }

        .forgot-password a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" placeholder="Enter username" required>

            <label for="password">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter password" required>

            <input type="submit" value="Login">
        </form>
        <div class="forgot-password">
            <a href="forgot-password">Forgot Password?</a>
        </div>
    </div>
</body>
</html>
