<%@page import="java.text.SimpleDateFormat"%>
<%@page import="ba.celebration.organization.ejb.celebration.entity.Celebration"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discount Rules</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
    </head>
    <body>
        <div class="card">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
                Celebrations
            </h3>
            <div style="padding: 20px">
                <%
                    Celebration editCelebration = (Celebration) request.getAttribute("editCelebration");
                    String action = editCelebration == null ? "addCelebration" : "updateCelebration";
                    String celebrationDate = "";
                    if (editCelebration != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
                        celebrationDate = dateFormat.format(editCelebration.getCelebrationDate());
                    }
                    String buttonText = editCelebration == null ? "Add celebration" : "Edit celebration";
                    List<Celebration> celebrations = (List<Celebration>) request.getAttribute("celebrations");
                %>
                <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="celebrationName">Celebration name</label>
                            <input type="text" id="celebrationName"
                                   class="form-control" name="celebrationName"
                                   value="<%=editCelebration != null ? editCelebration.getName() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="celebrationDate">Date of celebration</label>
                            <input type="date" id="celebrationDate"
                                   class="form-control" name="celebrationDate"
                                   value="<%=celebrationDate%>"/>
                        </div>
                    </div>

                    <input name="celebrationId" type="hidden" value="<%=editCelebration != null ? editCelebration.getId() : ""%>" />
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
                                <th class="text-center">Delete</th>
                                <th class="text-center">Add items</th>
                                <th class="text-center">Celebration name</th>
                                <th class="text-center">Celebration date</th>
                                <th class="text-center">User creator</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Celebration celebration : celebrations) {
                            %>
                            <tr>
                                <td>
                                    <span class="table-remove">
                                        <form action="editCelebration" method="POST">  
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Change
                                            </button>
                                            <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>"/>
                                        </form>

                                    </span>
                                </td>
                                <td>
                                    <%
                                        if (celebration.getCelebrationCostList().isEmpty()) {
                                    %>
                                    <span class="table-remove">
                                        <form action="deleteCelebration" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Delete
                                            </button>
                                            <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>"/>
                                        </form>
                                    </span>
                                    <%}%>
                                </td>
                                <td>
                                    <span class="table-remove">
                                        <form action="celebrationCost" method="POST">
                                            <button type="submit" class="btn btn-success btn-rounded btn-sm my-0">
                                                Add items
                                            </button>
                                            <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>"/>
                                        </form>
                                    </span>
                                </td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebration.getName()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebration.getCelebrationDate()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebration.getUserCreator()%></td>
                            </tr>
                            <%}%>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
