package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Drug {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String dose;
    private String strength;

    @ManyToOne
    @JsonBackReference("medicationClass_associateddrug1")
    @JoinColumn(name = "primary_medication_class_id",
            foreignKey = @ForeignKey(name = "fk_drug_medicationclass1"))
    private MedicationClass medicationClass1;


    @ManyToOne
    @JsonBackReference("medicationClass_associateddrug2")
    @JoinColumn(name = "secondary_medication_class_id",
    foreignKey = @ForeignKey(name = "fk_drug_medicationclass2"))
    private MedicationClass medicationClass2;

    public MedicationClass getMedicationClass2() {
        return medicationClass2;
    }

    public void setMedicationClass2(MedicationClass medicationClass2) {
        this.medicationClass2 = medicationClass2;
    }

    public MedicationClass getMedicationClass1() {
        return medicationClass1;
    }

    public void setMedicationClass1(MedicationClass medicationClass1) {
        this.medicationClass1 = medicationClass1;
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
