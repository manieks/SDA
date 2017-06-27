package pl.sdacademy.course.api;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pl.sdacademy.course.model.Student;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

/**
 * Created by mariusz.przybysz on 27-Mar-17.
 */

@Path("/students")
public class StudentsApi {
private  static Map<String, Student> studentsMap = new HashMap<>();




    @POST
    public Response postStudent (Student student) throws URISyntaxException {
        String id = UUID.randomUUID().toString();
        student.setId (id);
        studentsMap.put(id, student);
        System.out.println(studentsMap.size());
        URI uri = new URI("/students/" +id);
        Response response = Response.created(uri).build();
        return response;
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Student getStudent(@PathParam("id") String id){
       return  studentsMap.get(id);

    }


    @GET
    @Produces("application/json")
    public Collection<Student > getStudents(){
        return studentsMap.values();
    }

}
