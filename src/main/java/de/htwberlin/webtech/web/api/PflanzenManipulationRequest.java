package de.htwberlin.webtech.web.api;

public class PflanzenManipulationRequest {
    private String plantName;
    private String anotherName;
    private String farbe;

    public PflanzenManipulationRequest(String plantName, String anotherName, String farbe) {
        this.plantName = plantName;
        this.anotherName = anotherName;
        this.farbe = farbe;
    }

    public PflanzenManipulationRequest() {}

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
