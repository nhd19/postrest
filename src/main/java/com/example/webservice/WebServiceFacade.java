package com.example.webservice;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// SOAP Web Service
@WebService
@Path("/webservice")
public class WebServiceFacade {

    // SOAP Method
    public String soapMethod(String input) {
        return "SOAP Response: " + input;
    }

    // REST Endpoint
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/restMethod")
    public String restMethod() {
        return "{\"message\": \"REST Response\"}";
    }
}