<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="styles.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h2>Book Your Ticket</h2>

    <form action="/searchTrains" method="post">
        <input type="text" name="fromStation" placeholder="From Station" required />
        <input type="text" name="toStation" placeholder="To Station" required />
        <input type="date" name="dateOfJourney" required />
        
        <select name="seatClass" required>
            <option value="">-- Select Seat Class --</option>
            <option value="Sleeper">Sleeper</option>
            <option value="Third AC">Third AC</option>
            <option value="Second AC">Second AC</option>
            <option value="First AC">First AC</option>
        </select>

        <select name="quota" required>
            <option value="">-- Select Quota --</option>
            <option value="General">General</option>
            <option value="Tatkal">Tatkal</option>
            <option value="Ladies">Ladies</option>
        </select>

        <button type="submit" class="btn">Search Trains</button>
    </form>
</div>
