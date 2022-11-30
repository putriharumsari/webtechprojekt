package de.htwberlin.webtech.web.api;

public class PflanzenManipulationRequest {
    private String plantName;
    private String anotherName;
    private boolean vaccinated;

    public PflanzenManipulationRequest(String plantName, String anotherName, boolean vaccinated) {
        this.plantName = plantName;
        this.anotherName = anotherName;
        this.vaccinated = vaccinated;
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

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
}
