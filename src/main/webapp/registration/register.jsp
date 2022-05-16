<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="javax.naming.Context" %>
<%@page import="javax.naming.InitialContext" %>
<%@page import="ba.celebration.organization.user.registration.model.RegistrationModel" %>
<%@page import="jakarta.inject.Inject" %>
<%@page import="ba.celebration.organization.ejb.town.entity.Town" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
</head>
<body>
<div style="padding:20px">
    <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Registration Form</h3>
    <form action="register" method="post" style="border:1px solid #ccc; padding: 20px;">

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="name" id="fn">Name :</label>
                <input id="name" class="form-control" required="true" type="text" name="name"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="surname" id="ln">Surname :</label>
                <input id="surname" class="form-control" required="true" type="text" name="surname"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="username">Username :</label>
                <input id="username" class="form-control" required="true" type="text" name="username"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="password">Password :</label>
                <input id="password" class="form-control" required="true" type="password" name="password"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="email">Email :</label>
                <input id="email" class="form-control" required="true" type="text" name="email"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="contact">Contact :</label>
                <input id="contact" class="form-control" required="true" type="text" name="contact"><br/>
            </div>
        </div>

        <div class="col-md-4">
            <div class="form-outline">
                <label class="form-label" for="town">Town: </label>
                <select id="town" class="form-control" required="true" name="town">
                    <c:forEach items="${towns}" var="town">
                        <option>${town}</option>
                    </c:forEach>
                </select><br/><br/>
            </div>
        </div>

        <div class="col-md-6">
            <button class="col-md-8 btn btn-info" type="submit" value="Submit">Register</button>
            <button class="col-md-8 btn btn-link" type="button" onclick="location.href = 'authentication';">Back to
                login page
            </button>
        </div>
    </form>
</div>
</body>
</html>
