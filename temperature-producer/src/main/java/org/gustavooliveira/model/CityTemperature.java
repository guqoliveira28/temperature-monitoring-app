package org.gustavooliveira.model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.gustavooliveira.proxy.TemperatureProxy;

@ApplicationScoped
public class CityTemperature {

    @Inject
    @RestClient
    TemperatureProxy proxy;

    private String cityName;
    private double temperature;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void getTemperatureFromOpenMeteo(String cityName, double latitude, double longitude) {
        OpenMeteoData openMeteoData = new OpenMeteoData();
        openMeteoData = proxy.get(latitude, longitude, "temperature_2m", 1);
        this.setCityName(cityName);
        this.setTemperature(openMeteoData.getCurrent().getTemperature_2m());
    }
}
