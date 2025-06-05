<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome to Railway Reservation System</title>
    <style>
        html, body {
            margin: 0;
            padding: 0;
            height: 100vh;
            overflow: hidden;  /* Remove scrollbar */
        }

        body {
            background-image: url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: white;
            display: flex;
            flex-direction: column;
        }

        .top-header {
            width: 100%;
            padding: 20px;
            background-color: rgba(0, 0, 0, 0.7);
            text-align: center;
            font-size: 2em;
            font-weight: bold;
            color: white;
            flex-shrink: 0;
        }

        .overlay {
            padding: 20px;
            text-align: center;
            margin-top: 60px;  /* Push content down below header */
        }

        .subtext {
            display: inline-block;
            background-color: #003366; /* Dark blue */
            color: white;
            font-weight: bold;
            font-size: 1.2em;
            padding: 10px 20px;
            border-radius: 5px;
            margin-bottom: 30px;
        }

        .button-group {
            margin-top: 20px;
        }

        .btn {
            padding: 12px 25px;
            background-color: #ff5733;
            color: white;
            text-decoration: none;
            font-weight: bold;
            border-radius: 30px;
            margin: 0 15px;
            transition: background-color 0.3s ease;
            font-size: 1em;
            display: inline-block;
            min-width: 100px;
        }

        .btn:hover {
            background-color: #e84118;
        }
    </style>
</head>
<body>
    <div class="top-header">
        Welcome to Indian Railway Reservation System
    </div>

    <div class="overlay">
        <div class="subtext">
            Your gateway to seamless train travel and ticket booking!
        </div>
        <div class="button-group">
            <a href="/login" class="btn">Login</a>
            <a href="/register" class="btn">Register</a>
        </div>
    </div>
</body>
</html>
