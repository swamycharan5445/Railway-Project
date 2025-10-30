<%@ include file="navbar.jsp" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <%@ include file="styles.jsp" %>
</head>
<body>
<div class="container">
    <h2>User Login</h2>
    <form action="login" method="post">
        <label>Username</label>
        <input type="text" name="username" required placeholder="Enter username">

        <label>Password</label>
        <input type="password" name="password" required placeholder="Enter password">

        <button type="submit">Login</button>
    </form>

    <p>Don't have an account? <a href="register">Register here</a></p>

    <c:if test="${not empty error}">
        <p class="error">${error}</p>
    </c:if>
    <c:if test="${not empty success}">
        <p class="success">${success}</p>
    </c:if>
</div>
</body>
</html>
