<%@ page contentType = "text/html;charset=UTF-8" language="java" %>
<head>
    <title>Dashboard</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" type="text/css" href="css/dashboard.css">
</head>

<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <!-- page content -->
    <div class="content">
        <div>
            <aside class="left-sidebar">
                <div class="logo">Dashboard Page</div>
                    <ul class="menu">
                        <li><a href="dashboard?page=dashboard">Dashboard</a></li>
                        <li><a href="dashboard?page=expense">Expenses</a></li>
                        <li><a href="dashboard?page=setting">Settings</a></li>
                        <li><a href="dashboard?page=research">Research</a></li>
                        <li><a href="dashboard?page=analysis">Analysis</a></li>
                    </ul>
                    <div></div>
            </aside>
        </div>
        <div>
            <main class="main-content">
            <header>
                <input type="search" placeholder="Search...">
            </header>

            <section class="stats">
            <!-- Income, Expense, Deposit cards -->
            </section>

            <section class="chart">
            <!-- Chart or statistics -->
            </section>

            <section class="transfer">
            <!-- Transfer Money area -->
            </section>

            <section class="credit-card">
            <!-- Card balance and payments -->
            </section>
            </main>
        </div>
        <div>
            <aside class="right-sidebar">
                <div class="profile">
                    <button class="notification">notif</button>
                    <div class="profile-card">
                        <p>username</p>
                        <button>pfp</button>
                    </div>
                </div>
                <div class="bank-card-box">
                    <!-- display an atm card or something similar -->
                    cards
                    <div class="show-card"></div>
                </div>
                <div class="recent-payments">
                    <ul>
                        <li>payement 1</li>
                        <li>payment 2</li>
                        <li>payment 3</li>
                        <li>payement 4</li>
                        <li>payement 5</li>
                    </ul>
                </div>
            </aside>
        </div>
    </div>

</body>
</html>