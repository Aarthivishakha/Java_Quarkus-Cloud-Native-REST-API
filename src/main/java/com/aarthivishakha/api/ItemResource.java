package com.aarthivishakha.api;

import java.net.URI;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.smallrye.common.annotation.RunOnVirtualThread;

@RunOnVirtualThread
@Path("/api/v1/items") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_JSON)
public class ItemResource {
    @Inject ItemService service;
    @GET public List<Item> list() { return service.list(); }
    @POST public Response create(@Valid Item input) {
        Item created = service.create(input);
        return Response.created(URI.create("/api/v1/items/" + created.id())).entity(created).build();
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
