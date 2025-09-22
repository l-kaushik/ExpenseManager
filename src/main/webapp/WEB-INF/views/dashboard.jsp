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
        <aside class="left-sidebar">
            <div class="logo">Dashboard Page</div>
            <ul class="menu">
                <li><button onclick="loadSection('dashboard')">Dashboard</button></li>
                <li><button onclick="loadSection('expense')">Expenses</button></li>
                <li><button onclick="loadSection('report')">Report</button></li>
                <li><button onclick="loadSection('export')">Export</button></li>
                <li><button onclick="loadSection('settings')">Settings</button></li>
            </ul>
            <div></div>
        </aside>
        <main class="main-content" id="main-section">
            <div class="center-content">
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
            </div>
            <aside class="right-sidebar">
                <div class="profile">
                    <button class="notification">notif</button>
                    <div class="profile-card">
                        <p>username</p>
                        <button>pfp</button>
                    </div>
                </div>
                <div class="bank-card-box">
                    cards
                    <div class="show-card"></div>
                </div>
                <div class="recent-payments">
                    <ul>
                        <li>payment 1</li>
                        <li>payment 2</li>
                        <li>payment 3</li>
                        <li>payment 4</li>
                        <li>payment 5</li>
                    </ul>
                </div>
            </aside>
        </main>
    </div>
    <script src="js/script.js"></script>
</body>

</html>