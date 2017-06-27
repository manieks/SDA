package pl.sdacademy.course;

import pl.sdacademy.course.rest.client.StudentsClient;

/**
 * Created by lukasz on 25.03.17.
 */
public class Main {

    public static void main(String[] args) {
        StudentsClient studentsClient = new StudentsClient();
        String student = "{\n" +
                "\"name\":\"NEW\",\n" +
                "\"surname\":\"USER\",\n" +
                "\"email\":\"new.user@gmail.com\",\n" +
                "\"interests\":\"REST SERVICES\"\n" +
                "}";
        String url = "http://rest-test.cloudhub.io/api/students/";
        System.out.println(studentsClient.deleteStudent("http://rest-test.cloudhub.io/api/students/b7550112-eb13-4882-9b6a-d544fef9f64c"));
    }
}
