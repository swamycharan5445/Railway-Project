<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="styles.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h2>My Bookings</h2>

    <c:if test="${empty bookings}">
        <p>You have not booked any tickets yet.</p>
    </c:if>

    <c:if test="${not empty bookings}">
        <table>
            <thead>
                <tr>
                    <th>Train No</th>
                    <th>Train Name</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Date</th>
                    <th>Class</th>
                    <th>Quota</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookings}">
                    <tr>
                        <td>${booking.train.trainNumber}</td>
                        <td>${booking.train.trainName}</td>
                        <td>${booking.fromStation}</td>
                        <td>${booking.toStation}</td>
                        <td>${booking.dateOfJourney}</td>
                        <td>${booking.seatClass}</td>
                        <td>${booking.quota}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>
