/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import com.google.gson.Gson;
import core.RentOut;
import dao.RentOutCollection;
import static java.lang.System.out;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author tthera
 */

@Path("reOu")
public class RentOutResource {
    
    private static final Logger LOG = Logger.getLogger(RentOutResource.class.getName());

    @Context
    private UriInfo uriInfo;

    @EJB
    private RentOutCollection rocoll;
    private final Gson gson = new Gson();

    
    @GET
    @Path("{id : [a-zA-Z0-9]+}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") String id) {
        RentOut p = rocoll.find(id);
        if (p != null) {
            return Response.ok(gson.toJson(p)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build(); 
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        out.println("*** findAll");
        List<RentOut> rentOuts = rocoll.findAll();
        out.println(rentOuts);
        return Response.ok(gson.toJson(rentOuts)).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Path("count")
    public Response count() {
        int count = rocoll.count();
        return Response.ok(gson.toJson(count)).build();
    }
    
    
    
    
    
    
}
