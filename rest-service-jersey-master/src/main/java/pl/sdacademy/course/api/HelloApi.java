package pl.sdacademy.course.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class HelloApi {

    @GET
    public String getHello() {
        return "Hello REST!";
    }

}
