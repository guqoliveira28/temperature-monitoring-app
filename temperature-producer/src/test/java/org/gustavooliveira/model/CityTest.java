package org.gustavooliveira.model;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class CityTest {

    @Test
    public void testCityMethods() {
        // Arrange
        City city = new City(1, "TestCity", 40.7128, -74.0060);

        // Act/Assert
        assertEquals(1, city.getId());
        assertEquals("TestCity", city.getName());
        assertEquals(40.7128, city.getLatitude(), 0.0001); // Specify a delta for double comparison
        assertEquals(-74.0060, city.getLongitude(), 0.0001);
    }

    @Test
    public void testGetId() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        assertEquals(1, city.getId());
    }

    @Test
    public void testGetName() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        assertEquals("TestCity", city.getName());
    }

    @Test
    public void testSetName() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        city.setName("NewCity");
        assertEquals("NewCity", city.getName());
    }

    @Test
    public void testGetLatitude() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        assertEquals(40.7128, city.getLatitude(), 0.0001);
    }

    @Test
    public void testSetLatitude() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        city.setLatitude(35.6895);
        assertEquals(35.6895, city.getLatitude(), 0.0001);
    }

    @Test
    public void testGetLongitude() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        assertEquals(-74.0060, city.getLongitude(), 0.0001);
    }

    @Test
    public void testSetLongitude() {
        City city = new City(1, "TestCity", 40.7128, -74.0060);
        city.setLongitude(-90.0);
        assertEquals(-90.0, city.getLongitude(), 0.0001);
    }
}
