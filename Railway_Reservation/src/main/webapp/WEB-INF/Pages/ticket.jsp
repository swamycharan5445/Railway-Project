<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="styles.jsp" %>
<%@ include file="navbar.jsp" %>
<div class="container">
    <h2>Ticket Details</h2>
    <p><strong>Passenger:</strong> ${sessionScope.loggedInUser.fullname}</p>
    <p><strong>From:</strong> ${booking.fromStation}</p>
    <p><strong>To:</strong> ${booking.toStation}</p>
    <p><strong>Date:</strong> ${booking.dateOfJourney}</p>
    <p><strong>Class:</strong> ${booking.seatclass}</p>
    <p><strong>Quota:</strong> ${booking.quota}</p>
</div>
