<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        background-image: url('https://as2.ftcdn.net/v2/jpg/06/21/68/41/1000_F_621684156_GHCg1koda7y1FKwCZ1WsuwIxk27Sezuh.jpg');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        min-height: 100vh;
        color: white;
    }

    .navbar {
        width: 100%;
        background-color: rgba(0, 0, 0, 0.7);
        padding: 15px 30px;
        display: flex;
        justify-content: space-between;
        align-items: center;
        box-sizing: border-box;
    }

    .navbar a {
        color: white;
        text-decoration: none;
        margin: 0 15px;
        font-weight: bold;
        transition: color 0.3s ease;
    }

    .navbar a:hover {
        color: #ffcc00;
    }

    .brand {
        font-size: 1.5em;
        color: #ffcc00;
        font-weight: bold;
    }

    .welcome-msg {
        margin-right: 20px;
        font-size: 1.1em;
        font-weight: bold;
        color: #ffcc00;
    }

    .container {
        background-color: rgba(0, 0, 0, 0.6);
        padding: 30px;
        margin: 50px auto;
        border-radius: 10px;
        width: 50%;
        text-align: center;
    }

    input, select {
        padding: 10px;
        width: 80%;
        margin: 10px 0;
        border-radius: 5px;
        border: none;
    }

    .btn {
        padding: 12px 25px;
        background-color: #ff5733;
        color: white;
        font-weight: bold;
        border-radius: 30px;
        border: none;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn:hover {
        background-color: #e84118;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background-color: rgba(0, 0, 0, 0.5);
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: center;
    }

    th {
        background-color: rgba(255, 255, 255, 0.2);
        color: #ffcc00;
    }
</style>
