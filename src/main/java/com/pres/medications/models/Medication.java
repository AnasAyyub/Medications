package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Medication {
    @JsonIgnore
    @Id
    private int id;

    @OneToMany(mappedBy = "medication")
    @JsonManagedReference
    private List<MedicationClass> medicationClassList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MedicationClass> getMedicationClassList() {
        return medicationClassList;
    }

    public void setMedicationClassList(List<MedicationClass> medicationClassList) {
        this.medicationClassList = medicationClassList;
    }
}
