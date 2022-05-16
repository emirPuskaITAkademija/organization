<%@page import="ba.celebration.organization.ejb.town.entity.Town"%>
<%@page import="java.util.List"%>
<%@page import="ba.celebration.organization.user.session.UserSession"%>
<%@ page import="ba.celebration.organization.ejb.user.entity.User" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User's Settings</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute(UserSession.USER.getSessionKey());
            List<Town> towns = (List<Town>) request.getAttribute("townList");
        %>
        <div style="padding:20px">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">Update <%=user.getName()%>'s Credentials</h3>

            <form name="regi" action="${pageContext.request.contextPath}/updateUserAccount" method="post" style="border:1px solid #ccc; padding: 20px;" class="row g-3 needs-validation" novalidate>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label class="form-label" for="r1" id="fn">Name :</label>
                        <input class="form-control" required="true" type="text" name="name" id="r1" value="<%=user.getName()%>"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label class="form-label" for="r2" id="ln">Surname :</label>
                        <input class="form-control" required="true"  type="text" name="surname" id="r2" value="<%=user.getSurname()%>"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label  class="form-label" for="r3" id="un">Username :</label>
                        <input class="form-control" disabled="true" required="true" type="text" name="username" id="r3" value="<%=user.getUsername()%>"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label class="form-label"  for="r4" id="pwd">Password :</label>
                        <input class="form-control" required="true" type="password" name="password" id="r4"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label  class="form-label" for="r5" id="em">Email :</label>
                        <input class="form-control" type="text" name="email" id="r5" value="<%=user.getEmail()%>"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label  class="form-label" for="r6" id="mn">Contact :</label>
                        <input class="form-control" required="true" type="text" name="contact" id="r6" value="<%=user.getContact()%>"><br/>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="form-outline">
                        <label class="form-label" for="r8" id="cy">Select town: </label>
                        <select class="form-control" required="true" name="town" id="r8">
                            <%  for (Town town : towns) {
                            %><option><%=town%></option>
                            <%}%>
                        </select><br/><br/>
                    </div>
                </div>

                <div class="col-md-10">
                    <button class="col-md-4 btn btn-primary" type="submit" value="Submit" id="button">Update</button>
                    <button class="col-md-4 btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/dashboardAccess';">Back to homepage</button>
                </div>
            </form>
        </div>
    </body>
</html>
