<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="styles.jsp" %>
<%@ include file="navbar.jsp" %>

<div class="container">
    <h2>Enter Passenger Details</h2>

    <form action="/submitPassenger" method="post">
        <input type="text" name="name" placeholder="Passenger Name" required />
        <input type="number" name="age" placeholder="Age" required />
        
        <select name="gender" required>
            <option value="">-- Select Gender --</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select>

        <input type="text" name="berthPref" placeholder="Berth Preference (Optional)" />

        <button type="submit" class="btn">Generate Ticket</button>
    </form>
</div>
