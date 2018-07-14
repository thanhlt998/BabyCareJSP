<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="resources/css/style.css">
        <link rel="stylesheet" href="vendors/css/grid.css">
        <link rel="stylesheet" href="vendors/css/normalize.css">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400" rel="stylesheet">
    
    </head>
    
    <body>
        <header>
            <nav>
                <ul class="main-nav clearfix">
                    <li><a href="home">BabyCare</a></li>
                    <li><a href="home">Home</a></li>
                    <li><a href="viewBabyNames">Baby Names</a></li>
                    <li><a href="tips">Tips</a></li>
                    <li><a href="food">Food</a></li>
                    <li><a href="product">Product</a></li>
                    <li><a href="loginForm">Admin</a></li>
                </ul>
            </nav>
            <div class="row login-form">
                <h2>Admin Login</h2>
                <%if(request.getAttribute("loginMessage") != null) { %>
                	<p><%=(String) request.getAttribute("loginMessage") %></p>
                <%} else { %>
                	<p>&nbsp;</p>
                <%} %>
                <form action="login" method="post">
                    <label for="name">Name</label><br>
                    <input type="text" name="name" id="name" required><br>
                    <label for="password">Password</label><br>
                    <input type="password" name="password" id="password" required><br>
                    <button type="submit">Login</button>
                </form>
            </div>
        </header>
        
        <footer>
            <div class="row">
                ©Copyright BabyCareSolution 2010-2016.
            </div>
        </footer>
    </body>

</html>        