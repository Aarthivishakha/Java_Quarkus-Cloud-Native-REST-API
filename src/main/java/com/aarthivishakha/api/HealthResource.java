package com.aarthivishakha.api;

import java.util.Collections;
import java.util.Map;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import io.smallrye.common.annotation.RunOnVirtualThread;

@RunOnVirtualThread
@Path("/health") @Produces(MediaType.APPLICATION_JSON)
public class HealthResource {
    @GET public Map<String, String> health() { return Collections.singletonMap("status", "UP"); }
}
