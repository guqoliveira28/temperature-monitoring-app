package org.gustavooliveira.kafka.streams.consumer;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;


@ApplicationScoped
public class TemperatureConsumer {

    @Inject
    TemperatureConsumer temperatureConsumer;

    private static final Logger LOG = Logger.getLogger(TemperatureConsumer.class);

    @Incoming("temperature-values")
    public void consume(String cityTemperature) {
        LOG.infov("New: {0}", cityTemperature);

    }
}
