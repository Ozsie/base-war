package com.airhacks.plants.boundary;

import java.net.URI;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author airhacks.com
 */
@Stateless
@Path("base")
public class BaseResource {

    @GET
    public JsonObject get() {
        return Json.createObjectBuilder().
                add("alive", true).
                build();
    }

    @POST
    public Response save(JsonObject status, @Context UriInfo info) {
        System.out.println("status = " + status);
        URI path = info.getAbsolutePathBuilder().
                path("/" + System.currentTimeMillis()).
                build();
        return Response.created(path).build();
    }

    @GET
    @Path("{id}")
    public JsonObject getId(@PathParam("id") String id) {
        return Json.createObjectBuilder().add("id", id).build();
    }

}
