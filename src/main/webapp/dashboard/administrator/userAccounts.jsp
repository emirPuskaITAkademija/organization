<%@page import="ba.celebration.organization.ejb.user.privilege.entity.Privilege"%>
<%@page import="ba.celebration.organization.ejb.town.entity.Town"%>
<%@page import="ba.celebration.organization.ejb.user.entity.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Administration</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
    </head>
    <body>
        <!-- Service type-->
        <div class="card">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
                User Administration
            </h3>
            <div style="padding: 20px">
                <%
                    User editUserAccount = (User) request.getAttribute("editUserAccount");
                    String action = editUserAccount == null ? "addUserAdmin" : "updateUserAdmin";
                    String buttonText = editUserAccount == null ? "Add user" : "Edit user";
                    List<User> users = (List<User>) request.getAttribute("userAccounts");
                    List<Town> towns = (List<Town>) request.getAttribute("townList");
                    List<Privilege> privileges = (List<Privilege>) request.getAttribute("privilegeList");

                %>
                <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="serviceTypeName">Username</label>
                            <input type="text" id="serviceTypeName" 
                                   class="form-control" name="username"
                                   value="<%=editUserAccount != null ? editUserAccount.getUsername() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="password">Password</label>
                            <input type="password"  id="password"
                                   class="form-control" name="password"
                                   value="<%=editUserAccount != null ? editUserAccount.getPassword() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="name">Name</label>
                            <input type="text" id="name"
                                   class="form-control" name="name"
                                   value="<%=editUserAccount != null ? editUserAccount.getName() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="surname">Surname</label>
                            <input type="text"  id="surname"
                                   class="form-control" name="surname"
                                   value="<%=editUserAccount != null ? editUserAccount.getSurname() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="email">Email</label>
                            <input type="text" id="email"
                                   class="form-control" name="email"
                                   value="<%=editUserAccount != null ? editUserAccount.getEmail() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="contact">Contact</label>
                            <input type="text" id="contact"
                                   class="form-control" name="contact"
                                   value="<%=editUserAccount != null ? editUserAccount.getContact() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="town">Town</label>
                            <select class="form-control" name="town" id="town">
                                <% for (Town town : towns) {%>
                                <option value="<%=town.getId()%>"><%=town%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="privilege">Privilege</label>
                            <select name="privilege" class="form-control" id="privilege">
                                <% for (Privilege privilege : privileges) {%>
                                <option value="<%=privilege.getId()%>"><%=privilege%></option>
                                <%}%>
                            </select>
                        </div>
                    </div>
                    <input name="userId" type="hidden" value="<%=editUserAccount != null ? editUserAccount.getId() : ""%>" />
                    <div class="col-8" style="padding: 20px;">
                        <button class="btn btn-primary" type="submit"><%=buttonText%></button>
                        <button class="btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/dashboardAccess';">Back to homepage</button>
                    </div>
                </form>
            </div>



            <div class="card-body" style="padding: 20px;">
                <div id="table" class="table-editable">
                    <span class="table-add float-right mb-3 mr-2">
                        <a href="#!" class="text-success"><i class="fas fa-plus fa-2x" aria-hidden="true"></i></a>
                    </span>
                    <table class="table table-bordered table-responsive-md table-striped text-center">
                        <thead>
                            <tr>
                                <th class="text-center">Edit</th>
                                <th class="text-center">Deactivate</th>
                                <th class="text-center">Username</th>
                                <th class="text-center">Name</th>
                                <th class="text-center">Surname</th>
                                <th class="text-center">Email</th>
                                <th class="text-center">Contact</th>
                                <th class="text-center">Town</th>
                                <th class="text-center">Privilege</th>
                                <th class="text-center">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (User user : users) {%>
                            <tr>
                                <td>
                                    <span class="table-remove">
                                        <form action="editUserAdmin" method="POST">  
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Change
                                            </button>
                                            <input name="userId" type="hidden" value="<%=user.getId()%>"/>
                                        </form>

                                    </span>
                                </td>
                                <td>
                                    <span class="table-remove">
                                        <form action="deactivateUserAdmin" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Deactivate
                                            </button>
                                            <input name="userId" type="hidden" value="<%=user.getId()%>"/>
                                        </form>
                                    </span>
                                </td>
                                <td id="serviceTypeNameTd" class="pt-3-half" contenteditable="true"><%=user.getUsername()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getName()%></td>
                                <td class="pt-3-half" contenteditable="true"><%=user.getSurname()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getEmail()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getContact()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getTown()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getPrivilege()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=user.getStatus()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- Editable table -->
    </body>
</html>
