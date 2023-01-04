package de.htwberlin.webtech.persistance;

import javax.persistence.*;

@Entity(name = "pflanzens")
public class PflanzenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "plant_Name", nullable = false)
    private String plantName;

    @Column(name = "another_Name", nullable = false)
    private String anotherName;

    @Column(name = "farbe")
    private String farbe;

    @Column(name = "test")
    private String testColumn;


    public PflanzenEntity(String plantName, String anotherName, String farbe) {
        this.plantName = plantName;
        this.anotherName = anotherName;
        this.farbe = farbe;
    }

    protected PflanzenEntity() {}

    public Long getId() {
        return id;
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

    public String getTestColumn() {
        return testColumn;
    }

    public void setTestColumn(String testColumn) {
        this.testColumn = testColumn;
    }
}
