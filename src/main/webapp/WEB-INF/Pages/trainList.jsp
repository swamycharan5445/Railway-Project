<%@page import="com.nit.model.BookingData"%>
<%@page import="java.time.LocalDate"%>
<%@ page import="com.nit.model.TrainData"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Available Trains</title>
<style>
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
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: #000; /* Black table */
        color: white;
    }
    th, td {
        border: 1px solid #444; /* Dark border */
        padding: 12px;
        text-align: center;
    }
    th {
        background-color: #ff5733;
        color: white;
    }
    td {
        background-color: #111; /* Slightly lighter than black for readability */
    }
    .btn {
        display: block;
        margin: 20px auto 0;
        padding: 10px 20px;
        background-color: #ff5733;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-weight: bold;
    }
</style>

</head>
<body>
	<div class="container">
		<h2>Available Trains</h2>

		<%
            List<TrainData> trainDatas = (List<TrainData>) request.getAttribute("trains");
            List<BookingData> bookdata= (List<BookingData>) request.getAttribute("booking");
        %>

		<p>
			<strong>From:</strong>
			<%=  bookdata != null ? bookdata.get(0).getFromStation() : "N/A" %>
			&nbsp;&nbsp; <strong>To:</strong>
			<%= bookdata != null ? bookdata.get(0).getToStation() : "N/A" %>
			&nbsp;&nbsp; <strong>Date:</strong>
			<%= bookdata != null ? bookdata.get(0).getDateOfJourney() : "N/A" %>
		</p>

		<form action="bookTrain" method="post">
			<table>
				<thead>
					<tr>
						<th>Train No</th>
						<th>Train Name</th>
						<th>Departure</th>
						<th>Arrival</th>
						<th>Duration</th>
						<th>From Station</th>
						<th>To Station</th>
						<th>Select</th>
					</tr>
				</thead>
				<tbody>
					<%
                        if (trainDatas != null && !trainDatas.isEmpty()) {
                            for (TrainData t : trainDatas) {
                    %>
					<tr>
						<td><%= t.getTrainNumber() %></td>
						<td><%= t.getTrainName() %></td>
						<td><%= t.getDepartureTime() %></td>
						<td><%= t.getArrivalTime() %></td>
						<td><%= t.getDuration() %></td>
						<td><%= t.getFromStation() %></td>
						<td><%= t.getToStation() %></td>
						<td> <input type="radio" name="selectedTrain" value="<%= t.getId() %>" required>
						
						</td>
					</tr>
					<%
                            }
                        } else {
                    %>
					<tr>
						<td colspan="8">No matching trains found for the selected
							route.</td>
					</tr>
					<%
                        }
                    %>
				</tbody>
			</table>

			<button type="submit" class="btn">Book Selected Train</button>
		</form>
	</div>
</body>
</html>