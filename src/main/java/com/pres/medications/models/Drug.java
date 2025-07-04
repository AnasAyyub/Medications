package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Drug {
    @JsonIgnore
    @Id
    private int id;
    private String name;
    private String dose;
    private String strength;

    @ManyToOne
    @JsonBackReference
    private MedicationClass medicationClass;

    public MedicationClass getMedicationClass() {
        return medicationClass;
    }

    public void setMedicationClass(MedicationClass medicationClass) {
        this.medicationClass = medicationClass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
