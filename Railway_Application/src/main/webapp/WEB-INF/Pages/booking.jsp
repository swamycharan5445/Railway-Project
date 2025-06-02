<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Ticket</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', sans-serif;
	background-image:
		url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}

.container {
	background-color: rgba(0, 0, 0, 0.75);
	padding: 40px 30px;
	border-radius: 16px;
	width: 90%;
	max-width: 500px;
	color: white;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.6);
}

.title {
	text-align: center;
	font-size: 28px;
	font-weight: bold;
	color: #ff5733;
	margin-bottom: 30px;
}

form {
	display: flex;
	flex-direction: column;
	gap: 20px;
}

label {
	font-size: 14px;
	margin-bottom: 6px;
	display: block;
	color: #ccc;
}

select, input[type="date"] {
	width: 100%;
	padding: 12px 15px;
	font-size: 16px;
	border-radius: 8px;
	border: none;
	box-sizing: border-box;
}

.submit-btn {
	padding: 14px;
	background-color: #ff5733;
	border: none;
	border-radius: 40px;
	color: white;
	font-size: 18px;
	font-weight: bold;
	cursor: pointer;
	transition: background 0.3s ease;
}

.submit-btn:hover {
	background-color: #e94e2b;
}
</style>
</head>
<body>
	<div class="container">
		<div class="title">BOOK TICKET</div>
		<form method="post" action="bookTicket">
			<!-- From Station Dropdown -->
			<div>
				<label for="fromStation">From</label> <select name="fromStation"
					id="fromStation" required>
					<option value="" disabled selected>Select a station</option>
					<option value="Narasapuram">Narasapuram</option>
					<option value="Bhimavaram">Bhimavaram</option>
					<option value="Akividu">Akividu</option>
					<option value="Gudivada">Gudivada</option>
					<option value="Vijayawada">Vijayawada</option>
					<option value="Secunderabad">Secunderabad</option>
				</select>
			</div>

			<!-- To Station Dropdown -->
			<div>
				<label for="toStation">To</label> <select name="toStation"
					id="toStation" required>
					<option value="" disabled selected>Select a station</option>
					<option value="Narasapuram">Narasapuram</option>
					<option value="Bhimavaram">Bhimavaram</option>
					<option value="Akividu">Akividu</option>
					<option value="Gudivada">Gudivada</option>
					<option value="Vijayawada">Vijayawada</option>
					<option value="Secunderabad">Secunderabad</option>
				</select>
			</div>

			<!-- Date of Journey -->
			<div>
				<label for="dateOfJourney">Date of Journey *</label> <input
					type="date" id="dateOfJourney" name="dateOfJourney" required>
			</div>

			<!-- Class Selection -->
			<div>
				<label for="seatclass">Class</label> <select name="seatclass"
					id="seatclass">
					<option value="Sleeper">Sleeper</option>
					<option value="First AC">First AC</option>
					<option value="Second AC">Second AC</option>
					<option value="Third AC">Third AC</option>
				</select>
			</div>

			<!-- Quota Selection -->
			<div>
				<label for="quota">Quota</label> <select name="quota" id="quota">
					<option value="GENERAL">GENERAL</option>
					<option value="TATKAL">TATKAL</option>
					<option value="LADIES">LADIES</option>
					<option value="PREMIUM TATKAL">PREMIUM TATKAL</option>
				</select>
			</div>

			<button type="submit" class="submit-btn">Book Now</button>
		</form>

	</div>
</body>
</html>
