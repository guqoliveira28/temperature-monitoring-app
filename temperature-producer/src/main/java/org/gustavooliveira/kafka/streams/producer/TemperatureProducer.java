package org.gustavooliveira.kafka.streams.producer;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.kafka.Record;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.gustavooliveira.model.City;
import org.gustavooliveira.model.CityTemperature;
import org.jboss.logging.Logger;

/**
 * A bean producing random temperature data every minute.
 * The values are written to a Kafka topic (temperature-values).
 * The Kafka configuration is specified in the application configuration.
 */
@ApplicationScoped
public class TemperatureProducer {

    @Inject
    CityTemperature cityTemperature;

    private static final Logger LOG = Logger.getLogger(TemperatureProducer.class);
    private static final int SECONDS = 30;

    private int currentCityIndex = 0;

    private final List<City> cities = List.of(
            new City(0, "Porto", 41.1496, -8.611),
            new City(1, "New York", 40.7143, -74.006));

    // Populates temperatures into kafka topic
    @Outgoing("temperature-values")
    public Multi<Record<Integer, String>> generate() {
        return Multi.createFrom().ticks().every(Duration.ofMillis(1000 * (SECONDS / cities.size())))
                .onOverflow().drop()
                .map(tick -> {
                    if (currentCityIndex > 1) {
                        currentCityIndex = 0;
                    }

                    City city = cities.get(currentCityIndex++);

                    cityTemperature.getTemperatureFromOpenMeteo(city.getName(), city.getLatitude(), city.getLongitude());
                    LOG.infov("cityTemperature: {0} -> {1}", cityTemperature.getCityName(), cityTemperature.getTemperature());

                    return Record.of(city.getId(), Instant.now() + ";" + cityTemperature.getCityName() + ";" + cityTemperature.getTemperature());
                });
    }
}