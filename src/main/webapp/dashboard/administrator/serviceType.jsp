<%@page import="java.util.List"%>
<%@page import="ba.celebration.organization.ejb.service.type.entity.ServiceType"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Service type</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"/>
    </head>
    <body>
        <!-- Service type-->
        <div class="card">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
                Service Types
            </h3>
            <div style="padding: 20px">
                <%
                    ServiceType editServiceType = (ServiceType) request.getAttribute("editServiceType");
                    String action = editServiceType == null ? "addServiceType" : "updateServiceType";
                    String buttonText = editServiceType == null ? "Add service type" : "Edit service type";

                %>
                <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="serviceTypeName">Service type name</label>
                            <input type="text" id="serviceTypeName" 
                                   class="form-control" name="serviceTypeName"
                                   value="<%=editServiceType != null ? editServiceType.getName() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="costPerUnit">Cost per unit</label>
                            <input type="number" id="costPerUnit" 
                                   class="form-control" name="costPerUnit"
                                   value="<%=editServiceType != null ? editServiceType.getCostPerUnit() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="form-outline">
                            <label class="form-label" for="serviceDescription">Description</label>
                            <textarea class="form-control" id="serviceDescription" 
                                      rows="4" name="serviceDescription">
                                <%=editServiceType != null && editServiceType.getDescription() != null ? editServiceType.getDescription() : ""%>
                            </textarea>

                        </div>
                    </div>
                    <input name="serviceTypeId" type="hidden" value="<%=editServiceType != null ? editServiceType.getId() : ""%>" />
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
                                <th class="text-center">Service name</th>
                                <th class="text-center">Cost per unit</th>
                                <th class="text-center">Description</th>
                                <th class="text-center">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                List<ServiceType> serviceTypes = (List<ServiceType>) request.getAttribute("serviceTypes");
                            %>
                            <%
                                for (ServiceType serviceType : serviceTypes) {%>
                            <tr>
                                <td>
                                    <span class="table-remove">
                                        <form action="editServiceType" method="POST">  
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Change
                                            </button>
                                            <input name="serviceTypeId" type="hidden" value="<%=serviceType.getId()%>"/>
                                        </form>

                                    </span>
                                </td>
                                <td>
                                    <span class="table-remove">
                                        <form action="deactivateServiceType" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Deactivate
                                            </button>
                                            <input name="serviceTypeId" type="hidden" value="<%=serviceType.getId()%>"/>
                                        </form>
                                    </span>
                                </td>
                                <td id="serviceTypeNameTd" class="pt-3-half" contenteditable="true"><%=serviceType.getName()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=serviceType.getCostPerUnit().toPlainString()%></td>
                                <td class="pt-3-half" contenteditable="true"><%=serviceType.getDescription() == null ? "" : serviceType.getDescription()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=serviceType.getStatus()%></td>
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
