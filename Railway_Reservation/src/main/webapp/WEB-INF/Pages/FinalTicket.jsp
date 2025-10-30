<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Random"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Electronic Reservation Slip</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            background-image: url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
            background-size: cover;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: white;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .container {
            background-color: rgba(0, 0, 0, 0.85);
            width: 950px;
            border-radius: 12px;
            padding: 30px;
            box-shadow: 0 0 10px #000;
        }

        .header {
            text-align: center;
            font-weight: bold;
            font-size: 26px;
            text-decoration: underline;
            color: #ffcc00;
            margin-bottom: 20px;
        }

        .section {
            margin-top: 25px;
        }

        .row {
            display: flex;
            justify-content: space-between;
            gap: 15px;
            flex-wrap: wrap;
        }

        .row > div {
            flex: 1;
            min-width: 250px;
            padding: 10px;
            box-sizing: border-box;
        }

        .bordered {
            border-top: 1px solid #fff;
            border-bottom: 1px solid #fff;
            padding: 15px 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
            font-size: 14px;
            color: white;
        }

        th, td {
            border: 1px solid #fff;
            padding: 8px;
            text-align: center;
        }

        .bold {
            font-weight: bold;
            color: #ffcc00;
            font-size: 16px;
        }

        .center {
            text-align: center;
        }

        img {
            height: 24px;
            margin-bottom: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">Electronic Reservation Slip (ERS) - Normal User</div>

    <!-- Journey Info Section -->
    <div class="section row bordered">
        <div>
            <p><span class="bold">Booked From:</span><br>${bookedfrom}<br><br>Start Date*: ${dateOfJourney}</p>
        </div>
        <div class="center">
            <p><span class="bold">Boarding At:</span><br>${bookedfrom}<br><br>Departure*: ${departure}</p>
        </div>
        <div>
            <p><span class="bold">To:</span><br>${toStation}<br><br>Arrival*: ${arrival}</p>
        </div>
    </div>

    <!-- Ticket Details Section -->
    <div class="section row bordered">
        <div><span class="bold">PNR:</span><br><%out.println(new Random().nextLong(10000000000l));%></div>
        <div><span class="bold">Train No./Name:</span><br>${trainNo} / ${trainName}</div>
        <div><span class="bold">Class:</span><br>${ticketClass}</div>
        <div><span class="bold">Quota:</span><br>${quota}</div>
        <div><span class="bold">Time Of Journey:</span><br>${timeOfJourney}</div>
        <div><span class="bold">Booking Date:</span><br><%out.println(new SimpleDateFormat("dd-MM-yyyy   HH:mm:ss").format(new Date()));%></div>
    </div>

    <!-- Passenger Details -->
    <div class="section">
        <p class="bold">Passenger Details</p>
        <table>
            <tr>
                <th>SNo</th>
                <th>Name</th>
                <th>Age</th>
                <th>Gender</th>
                <th>Booking Status</th>
            </tr>
                <tr>
                    <td>${1}</td>
                    <td>${passengerList.name}</td>
                    <td>${passengerList.age}</td>
                    <td>${passengerList.gender}</td>
                    <td><%out.println("Confirmed"); %></td>
               </tr>

            
        </table>
    </div>

    <!-- Transaction ID -->
    <div class="section">
        <p><span class="bold">Transaction ID:</span> ${transactionId}</p>
    </div>

    <!-- Payment Details -->
    <div class="section">
        <p class="bold">Payment Details</p>
        <table>
            <tr>
                <th>Ticket Fare</th>
                <th>Convenience Fee</th>
                <th>Insurance</th>
                <th>Total Fare</th>
            </tr>
            <tr>
                <td>₹ ${price}</td>
                <td>₹ ${convenienceFee}</td>
                <td>₹ ${insurance}</td>
                <td>₹ ${totalFare}</td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
