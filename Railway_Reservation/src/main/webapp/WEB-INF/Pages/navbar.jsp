<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar">
    <div class="nav-left">
        <a href="/welcome" class="brand">Indian Railway</a>
    </div>

    <div class="nav-right">
        <a href="/welcome">Home</a>
        <a href="/booking">Book Ticket</a>

        <!-- If user is logged in -->
        <c:if test="${not empty sessionScope.loggedInUser}">
            <span class="welcome-msg">
                Welcome, ${sessionScope.loggedInUser.fullname}
            </span>
            <a href="/myBookings">My Bookings</a>
            <a href="/logout">Logout</a>
        </c:if>

        <!-- If user is NOT logged in -->
        <c:if test="${empty sessionScope.loggedInUser}">
            <a href="/login">Login</a>
            <a href="/register">Register</a>
        </c:if>
    </div>
</div>
