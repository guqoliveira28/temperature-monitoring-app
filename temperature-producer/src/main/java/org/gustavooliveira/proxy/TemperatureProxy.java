package org.gustavooliveira.proxy;

import jakarta.enterprise.context.Dependent;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.gustavooliveira.model.OpenMeteoData;

@Path("/v1/")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
@Dependent
public interface TemperatureProxy {

    @GET
    @Path("/forecast")
    OpenMeteoData get(
            @QueryParam("latitude") double latitude,
            @QueryParam("longitude") double longitude,
            @QueryParam("current") String current,
            @QueryParam("forecast_days") int forecast_days
    );
}
