package ba.celebration.organization.routes;

public interface Routes {
    String AUTHENTICATION = "authentication/login.jsp";
    String AUTHENTICATION_BACK = "../authentication/login.jsp";
    String REGISTRATION = "registration/register.jsp";
    String DASHBOARD_ACCESS = "dashboardAccess";
    String DASHBOARD = "dashboard/dashboard.jsp";
    String DASHBOARD_BACK = "../dashboard/dashboard.jsp";
    String UPDATE_CREDENTIAL = "dashboard/updateUser.jsp";
    String SERVICE_TYPE = "dashboard/administrator/serviceType.jsp";
    String DISCOUNT_RULE = "dashboard/administrator/discountRule.jsp";
    String USER_ACCOUNTS_ADMIN = "dashboard/administrator/userAccounts.jsp";
    String CELEBRATION = "dashboard/client/celebration.jsp";
    String CELEBRATION_COST = "dashboard/client/celebrationCost.jsp";
}
