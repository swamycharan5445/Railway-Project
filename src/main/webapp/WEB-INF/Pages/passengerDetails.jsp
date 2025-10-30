<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Enter Passenger Details</title>
    <style>
        /* your existing CSS */
        body {
            font-family: 'Segoe UI', sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
            background-size: cover;
            background-position: center;
            color: white;
            min-height: 100vh;
        }

        .container {
            background: rgba(0, 0, 0, 0.7);
            padding: 30px;
            border-radius: 10px;
            max-width: 900px;
            margin: 40px auto;
            box-shadow: 0 0 20px rgba(0,0,0,0.3);
        }

        h2 {
            text-align: center;
            color: #ff5733;
        }

        .passenger-block {
            background-color: rgba(255, 255, 255, 0.1);
            border: 1px solid #888;
            padding: 20px;
            border-radius: 6px;
            margin-bottom: 20px;
        }

        input, select {
            margin: 10px 15px 0 0;
            padding: 10px;
            width: 200px;
            border: none;
            border-radius: 4px;
            background-color: rgba(255, 255, 255, 0.2);
            color: white;
        }

        input::placeholder {
            color: #ccc;
        }

        select option {
            color: black;
        }

        .add-btn {
            background-color: #ff5733;
            color: white;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
        }

        .submit-btn {
            background-color: #00b894;
            color: white;
            padding: 12px 30px;
            border: none;
            cursor: pointer;
            border-radius: 4px;
            font-weight: bold;
            display: block;
            margin: 30px auto 0;
        }

        .limit-message {
            color: #ff6b6b;
            font-weight: bold;
            margin-top: 10px;
            text-align: center;
        }
    </style>

 
</head>
<body>
<div class="container">
    <h2>Enter Passenger Details</h2>
    <form action="submitPassengers" method="post">
        <input type="hidden" name="trainNo" value="${trainNumber}">

        <div id="passengerContainer">
            <div class="passenger-block">
                <h3 style="color: #ff9f43;">Passenger </h3>
                <input type="text" name="name" placeholder="Name" required>
                <input type="number" name="age" placeholder="Age" required>
                <select name="gender" required>
                    <option value="">Gender</option>
                    <option value="Male">Male</option>
                    <option value="Female">Female</option>
                    <option value="Other">Other</option>
                </select>
                <select name="berthPref">
                    <option value="">No Preference</option>
                    <option value="Lower">Lower</option>
                    <option value="Middle">Middle</option>
                    <option value="Upper">Upper</option>
                    <option value="Side Lower">Side Lower</option>
                    <option value="Side Upper">Side Upper</option>
                </select>
            </div>
        </div>

        <!-- <button type="button" class="add-btn" onclick="addPassenger()">+ Add Passenger</button> -->
        <div id="limitMsg" class="limit-message"></div>
        <input type="submit" class="submit-btn" value="Submit">
    </form>
</div>
</body>
</html>
