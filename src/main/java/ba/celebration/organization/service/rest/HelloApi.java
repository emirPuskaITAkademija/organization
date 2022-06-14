package ba.celebration.organization.service.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/hello")
public class HelloApi {
    @GET
    public String sayHello() {

        return "Hello World";
    }
}
