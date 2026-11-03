package com.example.assignment9.models;

import java.io.Serializable;

public class Weather implements Serializable {
    private String cityName;
    private double temp;
    private double tempMax;
    private double tempMin;
    private String description;
    private String icon;
    private int humidity;
    private double windSpeed;
    private double windDegree;
    private int cloudiness;

    public String getCityName() { return cityName; }
    public void setCityName(String cityName) { this.cityName = cityName; }

    public double getTemp() { return temp; }
    public void setTemp(double temp) { this.temp = temp; }

    public double getTempMax() { return tempMax; }
    public void setTempMax(double tempMax) { this.tempMax = tempMax; }

    public double getTempMin() { return tempMin; }
    public void setTempMin(double tempMin) { this.tempMin = tempMin; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public double getWindSpeed() { return windSpeed; }
    public void setWindSpeed(double windSpeed) { this.windSpeed = windSpeed; }

    public double getWindDegree() { return windDegree; }
    public void setWindDegree(double windDegree) { this.windDegree = windDegree; }

    public int getCloudiness() { return cloudiness; }
    public void setCloudiness(int cloudiness) { this.cloudiness = cloudiness; }

    //Helper for the UI person to load the icon image
    public String getIconUrl() {
        return "https://openweathermap.org/img/wn/" + icon + "@2x.png";
    }
}