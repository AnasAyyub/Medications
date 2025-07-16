package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class MedicationClass {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference("medicationclass_medicationclasses1")
    @JoinColumn(name = "medication_class_id1",
    foreignKey = @ForeignKey(name = "fk_medicationclass_medicationclasses1"))
    private MedicationsClasses medicationsClasses;
    public MedicationsClasses getMedicationsClasses() {
        return medicationsClasses;
    }

    public void setMedicationsClasses(MedicationsClasses medicationsClasses) {
        this.medicationsClasses = medicationsClasses;
    }

    @ManyToOne
    @JsonBackReference("medicationclass_medicationclasses2")
    @JoinColumn(name = "medication_class_id2",
    foreignKey = @ForeignKey(name = "fk_medicationclass_medicationclasses2"))
    private MedicationsClasses medicationsClasses2;

    public MedicationsClasses getMedicationsClasses2() {
        return medicationsClasses2;
    }

    public void setMedicationsClasses2(MedicationsClasses medicationsClasses2) {
        this.medicationsClasses2 = medicationsClasses2;
    }

    @OneToMany(mappedBy = "medicationClass1",cascade = CascadeType.ALL)
    @JsonManagedReference("medicationClass_associateddrug1")
    private List<Drug> associatedDrug;

    @OneToMany(mappedBy = "medicationClass2",cascade = CascadeType.ALL)
    @JsonManagedReference("medicationClass_associateddrug2")
    private List<Drug> associatedDrug2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Drug> getAssociatedDrug() {
        return associatedDrug;
    }

    public void setAssociatedDrug(List<Drug> associatedDrug) {
        for (Drug d:associatedDrug)
            d.setMedicationClass1(this);
        this.associatedDrug = associatedDrug;
    }

    public List<Drug> getAssociatedDrug2() {
        return associatedDrug2;
    }

    public void setAssociatedDrug2(List<Drug> associatedDrug2) {
        for (Drug d:associatedDrug2)
            d.setMedicationClass2(this);
        this.associatedDrug2 = associatedDrug2;
    }
}
