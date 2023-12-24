package org.gustavooliveira.model;

public class CityTemperature {

    private String name;

    private float temperature;

    public CityTemperature(String name, float temperature) {
        this.name = name;
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "CityTemperature{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
