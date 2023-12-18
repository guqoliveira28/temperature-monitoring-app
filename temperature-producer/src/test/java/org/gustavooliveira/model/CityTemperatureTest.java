package org.gustavooliveira.model;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gustavooliveira.proxy.TemperatureProxy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@QuarkusTest
public class CityTemperatureTest {

    @Inject
    @InjectMocks
    @RestClient
    private TemperatureProxy temperatureProxyMock;

    private CityTemperature cityTemperatureMock = new CityTemperature();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCityName() {
        cityTemperatureMock.setCityName("TestCity");
        assertEquals("TestCity", cityTemperatureMock.getCityName());
    }

    @Test
    public void testSetCityName() {
        cityTemperatureMock.setCityName("TestCity");
        assertEquals("TestCity", cityTemperatureMock.getCityName());
    }

    @Test
    public void testGetTemperature() {
        cityTemperatureMock.setTemperature(25.0);
        assertEquals(25.0, cityTemperatureMock.getTemperature(), 0.0001);
    }

    @Test
    public void testSetTemperature() {
        cityTemperatureMock.setTemperature(25.0);
        assertEquals(25.0, cityTemperatureMock.getTemperature(), 0.0001);
    }

    @Test
    public void testGetTemperatureFromOpenMeteo() {
        // Mock the behavior of TemperatureProxy
        OpenMeteoData openMeteoDataMock = Mockito.mock(OpenMeteoData.class); // Create a mock instance

        // Create a mock instance for Current and set the temperature
        OpenMeteoData.Current currentMock = Mockito.mock(OpenMeteoData.Current.class);
        Mockito.when(openMeteoDataMock.getCurrent()).thenReturn(currentMock);
        Mockito.when(currentMock.getTemperature_2m()).thenReturn((float) 20.0);
        when(temperatureProxyMock.get(anyDouble(), anyDouble(), eq("temperature_2m"), eq(1)))
                .thenReturn(openMeteoDataMock);

        // Call the method to test
        cityTemperatureMock.getTemperatureFromOpenMeteo("TestCity", 40.7128, -74.0060);

        // Assert the results
        assertEquals("TestCity", cityTemperatureMock.getCityName());
        assertEquals(20.0, cityTemperatureMock.getTemperature(), 0.0001);
    }
}
