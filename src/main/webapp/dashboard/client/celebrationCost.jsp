<%@page import="ba.celebration.organization.ejb.service.type.entity.ServiceType"%>
<%@page import="ba.celebration.organization.ejb.celebration.cost.entity.CelebrationCost"%>
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
        <%
            Celebration celebration = (Celebration) request.getAttribute("celebration");
            List<CelebrationCost> celebrationCosts = (List<CelebrationCost>) request.getAttribute("celebrationCosts");
            List<ServiceType> serviceTypes = (List<ServiceType>) request.getAttribute("serviceTypes");

            CelebrationCost editCelebrationCost = (CelebrationCost) request.getAttribute("editCelebrationCost");
            String action = editCelebrationCost == null ? "addCelebrationCost" : "updateCelebrationCost";
            String buttonText = editCelebrationCost == null ? "Add celebration cost" : "Edit celebration";

        %>
        <div class="card">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
                Costs for '<%=celebration.getName()%>'
            </h3>
            <div style="padding: 20px">

                <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
                    <!-- celebration -->
                    <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>" />
                    <%if (editCelebrationCost != null) {%>
                    <!-- celebration cost -->
                    <input name="celebrationCostId" type="hidden" value="<%=editCelebrationCost.getId()%>" />
                    <%}%>
                    <!-- choose service type-->
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="serviceType" id="cy">Select service type</label>
                            <select id="serviceType" class="form-control" required="true" name="serviceType" id="r8">
                                <%  for (ServiceType serviceType : serviceTypes) {
                                %><option><%=serviceType%></option>
                                <%}%>
                            </select><br/><br/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="quantity">Quantity</label>
                            <input type="number" id="quantity"
                                   class="form-control" name="quantity"
                                   value="<%=editCelebrationCost != null ? editCelebrationCost.getQuantity() : ""%>"/>
                        </div>
                    </div>

                    <div class="col-8" style="padding: 20px;">
                        <button class="btn btn-primary" type="submit"><%=buttonText%></button>
                        <button class="btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/dashboardAccess';">Back to homepage</button>
                        <button class="btn btn-link" type="button" onclick="location.href = '${pageContext.request.contextPath}/celebration';">Back to celebration</button>
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
                                <th class="text-center">Add</th>
                                <th class="text-center">Delete</th>
                                <th class="text-center">Celebration name</th>
                                <th class="text-center">Service type</th>
                                <th class="text-center">Quantity</th>
                                <th class="text-center">Cost amount</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (CelebrationCost celebrationCost : celebrationCosts) {
                            %>
                            <tr>
                                <td>
                                    <span class="table-remove">
                                        <form action="editCelebrationCost" method="POST">  
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Change
                                            </button>
                                            <input name="celebrationCostId" type="hidden" value="<%=celebrationCost.getId()%>"/>
                                            <!-- celebration -->
                                            <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>" />
                                        </form>

                                    </span>
                                </td>
                                <td>
                                    <span class="table-remove">
                                        <form action="deleteCelebrationCost" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Delete
                                            </button>
                                            <input name="celebrationCostId" type="hidden" value="<%=celebrationCost.getId()%>"/>
                                            <!-- celebration -->
                                            <input name="celebrationId" type="hidden" value="<%=celebration.getId()%>" />
                                        </form>
                                    </span>
                                </td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebrationCost.getCelebration().getName()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebrationCost.getServiceType()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebrationCost.getQuantity()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=celebrationCost.getAmount()%></td>
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
