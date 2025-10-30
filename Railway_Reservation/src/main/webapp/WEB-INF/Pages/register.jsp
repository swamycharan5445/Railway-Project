<%@ include file="navbar.jsp" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <h2>Register</h2>
    <form action="register" method="post" modelAttribute="railwayData">

        <label>Full Name</label>
        <input type="text" name="fullname" required placeholder="Enter full name" />

        <label>Username</label>
        <input type="text" name="username" required placeholder="Choose a username" />

        <label>Email</label>
        <input type="email" name="email" required placeholder="Enter email" />

        <label>Password</label>
        <input type="password" name="password" required placeholder="Enter password" />

        <label>Confirm Password</label>
        <input type="password" name="confirmpassword" required placeholder="Confirm password" />

        <button type="submit">Register</button>
    </form>

    <c:if test="${not empty message}">
        <p class="success">${message}</p>
    </c:if>
    <c:if test="${not empty msg}">
        <p class="error">${msg}</p>
    </c:if>
</div>
</body>
</html>
