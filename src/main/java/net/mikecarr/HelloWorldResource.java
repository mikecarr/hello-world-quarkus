package net.mikecarr;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class HelloWorldResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello World from Quarkus!";
    }
    
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public HelloResponse helloJson() {
        return new HelloResponse("Hello World from Quarkus!", "JSON");
    }
    
    public static class HelloResponse {
        public String message;
        public String format;
        
        public HelloResponse(String message, String format) {
            this.message = message;
            this.format = format;
        }
    }
}