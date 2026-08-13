package com.aarthivishakha.api;

import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1/items") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject ItemService service;
    @GET public List<Item> list() { return service.list(); }
    @POST public Response create(@Valid Item input) {
        Item created = service.create(input);
        return Response.created(URI.create("/api/v1/items/" + created.id)).entity(created).build();
    }
    @GET @Path("/{id}") public Response get(@PathParam("id") long id) {
        Item item = service.find(id); return item == null ? Response.status(404).build() : Response.ok(item).build();
    }
    @PUT @Path("/{id}") public Response replace(@PathParam("id") long id, @Valid Item input) {
        Item item = service.replace(id, input); return item == null ? Response.status(404).build() : Response.ok(item).build();
    }
    @DELETE @Path("/{id}") public Response delete(@PathParam("id") long id) {
        return service.delete(id) ? Response.noContent().build() : Response.status(404).build();
    }
}
