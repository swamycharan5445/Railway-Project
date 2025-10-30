<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="styles.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h2>Available Trains</h2>

    <c:if test="${empty trains}">
        <p>No trains found for your search.</p>
    </c:if>

    <c:if test="${not empty trains}">
        <form action="/bookTicket" method="post">
            <input type="hidden" name="fromStation" value="${param.fromStation}" />
            <input type="hidden" name="toStation" value="${param.toStation}" />
            <input type="hidden" name="seatClass" value="${param.seatClass}" />
            <input type="hidden" name="quota" value="${param.quota}" />
            <input type="hidden" name="dateOfJourney" value="${param.dateOfJourney}" />

            <table>
                <thead>
                    <tr>
                        <th>Train No</th>
                        <th>Train Name</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Departure</th>
                        <th>Arrival</th>
                        <th>Select</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="train" items="${trains}">
                        <tr>
                            <td>${train.trainNumber}</td>
                            <td>${train.trainName}</td>
                            <td>${train.fromStation}</td>
                            <td>${train.toStation}</td>
                            <td>${train.departureTime}</td>
                            <td>${train.arrivalTime}</td>
                            <td>
                                <input type="radio" name="trainId" value="${train.id}" required />
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="submit" class="btn">Proceed with Selected Train</button>
        </form>
    </c:if>
</div>
