package org.gustavooliveira.model;

public class OpenMeteoData {

    private Current current;

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    protected static class Current {

        private String time;

        private int interval;

        private float temperature_2m;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }

        public float getTemperature_2m() {
            return temperature_2m;
        }

        public void setTemperature_2m(float temperature_2m) {
            this.temperature_2m = temperature_2m;
        }
    }
}
