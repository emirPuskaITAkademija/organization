<%@page import="ba.celebration.organization.user.session.UserSession" %>
<%@page import="ba.celebration.organization.ejb.user.entity.User" %>
<%@page import="ba.celebration.organization.ejb.user.privilege.entity.Privilege" %>
<%@page import="ba.celebration.organization.user.session.UserRole" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Birthday celebration</title>
    <link rel="icon" type="image/x-icon" href="images/favicon.ico">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>

<%
    User sessionUser = UserSession.USER.getFromSession(request);
    Privilege privilege = sessionUser.getPrivilege();
    String nameOfPrivilege = privilege.getName();
%>

<div style="padding: 20px">
    <ul class="topnav">
        <li><a href="${pageContext.request.contextPath}/dashboardAccess">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/celebration">Celebration</a></li>
        <%
            if (nameOfPrivilege.equalsIgnoreCase(UserRole.ADMINISTRATOR)) {
        %>
        <li><a href="${pageContext.request.contextPath}/userAdmin"> Users's administration</a></li>
        <%}%>
        <%
            if (nameOfPrivilege.equalsIgnoreCase(UserRole.ADMINISTRATOR) || nameOfPrivilege.equals(UserRole.MANAGER)) {
        %>
        <li><a href="${pageContext.request.contextPath}/serviceType">Service types</a></li>
        <li><a href="${pageContext.request.contextPath}/discountRule">Discount rules</a></li>
        <%}%>
        <li><a href="${pageContext.request.contextPath}/updatingUserAccount">Credentials</a></li>
        <li class="right"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
    </ul>

    <h2 class="card-header text-center font-weight-bold text-uppercase py-4">Birthday Image Gallery</h2>
    <h4 class="card-header text-center font-weight-bold py-4">Celebrating one's birthday is a special event that's meant
        to be shared with loved ones.</h4>

    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="http://static.everypixel.com/ep-pixabay/0357/6852/6166/97132/3576852616697132288-birthday.jpg">
                <img src="http://static.everypixel.com/ep-pixabay/0357/6852/6166/97132/3576852616697132288-birthday.jpg"
                     alt="Cinque Terre" width="600" height="400">
            </a>
            <div class="desc">Choose how will looks like your celebration letter.</div>
        </div>
    </div>


    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="http://static.everypixel.com/ep-pixabay/0511/7823/3298/70909/5117823329870909994-happy_birthday.jpg">
                <img src="http://static.everypixel.com/ep-pixabay/0511/7823/3298/70909/5117823329870909994-happy_birthday.jpg"
                     alt="Forest" width="600" height="400">
            </a>
            <div class="desc">Choose your favorite cake and we will arrange it for you.</div>
        </div>
    </div>

    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="http://static.everypixel.com/ep-pixabay/0264/1455/9799/77353/2641455979977353270-girl.jpg">
                <img src="http://static.everypixel.com/ep-pixabay/0264/1455/9799/77353/2641455979977353270-girl.jpg"
                     alt="Northern Lights" width="600" height="400">
            </a>
            <div class="desc">If you have someone special to you and want that this day would be special for her or him.
                Trust us and you won't regret.
            </div>
        </div>
    </div>

    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="http://static7.depositphotos.com/1155356/680/i/450/depositphotos_6802331-Clown-Makes-Funny-Face.jpg">
                <img src="http://static7.depositphotos.com/1155356/680/i/450/depositphotos_6802331-Clown-Makes-Funny-Face.jpg"
                     alt="Mountains" width="600" height="400">
            </a>
            <div class="desc">If you need entertainment for your youngest but you cannot find someone who will entertain
                them we are here for you.
            </div>
        </div>
    </div>

    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="https://www.thespruce.com/thmb/0Q5n4uLyV8PIiwxFXpWN6J0I2d8=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/birthday-party-planning-timeline-2104701-hero-ff1bca0c42e847c4b7079928f1abff54.jpg">
                <img src="https://www.thespruce.com/thmb/0Q5n4uLyV8PIiwxFXpWN6J0I2d8=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/birthday-party-planning-timeline-2104701-hero-ff1bca0c42e847c4b7079928f1abff54.jpg"
                     alt="Mountains" width="600" height="400">
            </a>
            <div class="desc">Planning a birthday party can feel overwhelming, but it’s not if you break it down into
                small tasks.
            </div>
        </div>
    </div>
    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="https://www.thespruce.com/thmb/uLR0KEGfcAJnwMnzZih9EOzX3YE=/2121x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/preparation-for-birthday-party-in-the-garden-882162222-5c57dece46e0fb0001be6f8e.jpg">
                <img src="https://www.thespruce.com/thmb/uLR0KEGfcAJnwMnzZih9EOzX3YE=/2121x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/preparation-for-birthday-party-in-the-garden-882162222-5c57dece46e0fb0001be6f8e.jpg"
                     alt="Mountains" width="600" height="400">
            </a>
            <div class="desc">For those who choose to, drop off your child at a friend,
                relative or baby sitter’s house to give you time to focus on the party details.
            </div>
        </div>
    </div>
    <div class="responsive">
        <div class="gallery">
            <a target="_blank"
               href="https://www.thespruce.com/thmb/16-Ht_yB-lEv73-wTgcdg6LBhxE=/2121x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/cupcake-after-the-party-1063995382-5c57e196c9e77c000132a1d4.jpg">
                <img src="https://www.thespruce.com/thmb/16-Ht_yB-lEv73-wTgcdg6LBhxE=/2121x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/cupcake-after-the-party-1063995382-5c57e196c9e77c000132a1d4.jpg"
                     alt="Mountains" width="600" height="400">
            </a>
            <div class="desc">For those who choose to, drop off your child at a friend,
                relative or baby sitter’s house to give you time to focus on the party details.
            </div>
        </div>
    </div>
</div>
</body>
</html>