<%@page import="ba.celebration.organization.ejb.celebration.discount.entity.DiscountRule"%>
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
        <!-- Service type-->
        <div class="card">
            <h3 class="card-header text-center font-weight-bold text-uppercase py-4">
                Discount Rules
            </h3>
            <div style="padding: 20px">
                <%
                    DiscountRule editDiscountRule = (DiscountRule) request.getAttribute("editDiscountRule");
                    String action = editDiscountRule == null ? "addDiscountRule" : "updateDiscountRule";
                    String buttonText = editDiscountRule == null ? "Add discount rule" : "Edit discount rule";
                    List<DiscountRule> discountRules = (List<DiscountRule>) request.getAttribute("discountRules");
                %>
                <form action="<%=action%>" method="post" class="row g-3 needs-validation" novalidate>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="spentOnCelebration">Spent on celebration</label>
                            <input type="number" id="spentOnCelebration" 
                                   class="form-control" name="spentOnCelebration"
                                   value="<%=editDiscountRule != null ? editDiscountRule.getSpentOnCelebration() : ""%>"/>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="form-outline">
                            <label class="form-label" for="costPerUnit">Earned discount</label>
                            <input type="number" id="costPerUnit" 
                                   class="form-control" name="earnedDiscount"
                                   value="<%=editDiscountRule != null ? editDiscountRule.getEarnedDiscount() : ""%>"/>
                        </div>
                    </div>

                    <input name="discountRuleId" type="hidden" value="<%=editDiscountRule != null ? editDiscountRule.getId() : ""%>" />
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
                                <th class="text-center">Amount spent on celebrations</th>
                                <th class="text-center">Percentage of earned discount</th>
                                <th class="text-center">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (DiscountRule discountRule : discountRules) {
                            %>
                            <tr>
                                <td>
                                    <span class="table-remove">
                                        <form action="editDiscountRule" method="POST">  
                                            <button type="submit" class="btn btn-primary btn-rounded btn-sm my-0">
                                                Change
                                            </button>
                                            <input name="discountRuleId" type="hidden" value="<%=discountRule.getId()%>"/>
                                        </form>

                                    </span>
                                </td>
                                <td>
                                    <span class="table-remove">
                                        <form action="deactivateDiscountRule" method="POST">
                                            <button type="submit" class="btn btn-danger btn-rounded btn-sm my-0">
                                                Deactivate
                                            </button>
                                            <input name="discountRuleId" type="hidden" value="<%=discountRule.getId()%>"/>
                                        </form>
                                    </span>
                                </td>
                                <td  class="pt-3-half" contenteditable="true"><%=discountRule.getSpentOnCelebration()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=discountRule.getEarnedDiscount()%></td>
                                <td  class="pt-3-half" contenteditable="true"><%=discountRule.getStatus()%></td>
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
