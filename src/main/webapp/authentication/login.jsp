<%@page import="ba.celebration.organization.routes.Routes" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
<section class="login-block">
    <div class="container">
        <div class="row">
            <div class="col-md-4 login-sec">
                <h2 class="text-center">Login Now</h2>
                <form action="authenticate" method="post" class="login-form">
                    <div class="form-group">
                        <label for="username" class="text-uppercase">Username</label>
                        <input id="username" name="username" type="text" class="form-control" placeholder="">
                    </div>
                    <div class="form-group">
                        <label for="password" class="text-uppercase">Password</label>
                        <input id="password" name="password" type="password" class="form-control" placeholder="">
                    </div>

                    <div style="margin-bottom: 20px">
                        <button type="submit" class="btn  btn-info btn-lg btn-block">Login</button>
                    </div>
                    <a href="registration" class="btn btn-link">
                        You want to become member ?
                    </a>
                </form>
            </div>
            <div class="col-md-8 banner-sec">
                <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid"
                                 src="http://static.everypixel.com/ep-pixabay/0511/7823/3298/70909/5117823329870909994-happy_birthday.jpg"
                                 alt="First slide"/>
                        </div>
                    </div>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item">
                            <img class="d-block img-fluid"
                                 src="https://thumbs.dreamstime.com/z/colorful-happy-birthday-cupcakes-candles-spelling-148323072.jpg"
                                 alt="First slide"/>
                        </div>
                    </div>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item">
                            <img class="d-block img-fluid"
                                 src="https://thumbs.dreamstime.com/z/happy-birthday-cupcake-glitter-colorful-background-candle-light-happy-birthday-cupcake-glitter-colorful-background-159872612.jpg"
                                 alt="First slide"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</section>
</body>
</html>
