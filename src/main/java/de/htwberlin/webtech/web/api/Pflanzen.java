package de.htwberlin.webtech.web.api;

public class Pflanzen {

    private long id;
    private String plantName;
    private String anotherName;
    private String farbe;

    public Pflanzen(long id, String plantName, String anotherName, String farbe) {
        this.id = id;
        this.plantName = plantName;
        this.anotherName = anotherName;
        this.farbe = farbe;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getAnotherName() {
        return anotherName;
    }

    public void setAnotherName(String anotherName) {
        this.anotherName = anotherName;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }
}
