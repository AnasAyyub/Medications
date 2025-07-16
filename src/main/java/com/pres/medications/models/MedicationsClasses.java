package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class MedicationsClasses {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "medication_id",
            foreignKey = @ForeignKey(name = "fk_medicationClasses_medication"))
    @JsonBackReference
    private Medication medication;

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    @OneToMany(mappedBy = "medicationsClasses",cascade = CascadeType.ALL)
    @JsonManagedReference("medicationclass_medicationclasses1")
    private List<MedicationClass> className;

    @OneToMany(mappedBy = "medicationsClasses2",cascade = CascadeType.ALL)
    @JsonManagedReference("medicationclass_medicationclasses2")
    private List<MedicationClass> className2;

    public List<MedicationClass> getClassName2() {
        return className2;
    }

    public void setClassName2(List<MedicationClass> className2) {
        this.className2 = className2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<MedicationClass> getClassName() {
        return className;
    }

    public void setClassName(List<MedicationClass> className) {
        for (MedicationClass med:className)
            med.setMedicationsClasses(this);
        this.className = className;
    }
}
