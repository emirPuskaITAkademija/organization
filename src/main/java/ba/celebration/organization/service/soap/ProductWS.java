package ba.celebration.organization.service.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(serviceName = "ProductWS")
public class ProductWS {


    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt){
        return "Hello '" +txt+"' !";
    }
}
