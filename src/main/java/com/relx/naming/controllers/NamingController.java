package com.relx.naming.controllers;

import com.relx.naming.services.NamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;

import java.util.ArrayList;

import static javax.ws.rs.core.MediaType.*;

/**
 *  REST Controller that exposes the NamingService service and its methods
 */
@Controller
@Path("/namingService")
public class NamingController {

    @Autowired
    private NamingService service;

    @POST
    @Path("/parseName")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public String parseName(String name) {
        return service.parseName(name);
    }

    @POST
    @Path("/parseJoinedNames")
    @Consumes({APPLICATION_JSON})
    @Produces({APPLICATION_JSON})
    public ArrayList<String> parseJoinedNames(String names){
        return service.parseJoinedNames(names);
    }
}
