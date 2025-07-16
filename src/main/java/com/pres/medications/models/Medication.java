package com.pres.medications.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Medication {
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="data_id",
    foreignKey = @ForeignKey(name = "fk_medication_data"))
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @OneToMany(mappedBy = "medication",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MedicationsClasses> medicationsClasses;

    public List<MedicationsClasses> getMedicationsClasses() {
        return medicationsClasses;
    }

    public void setMedicationsClasses(List<MedicationsClasses> medicationsClasses) {
        for (MedicationsClasses med:medicationsClasses)
            med.setMedication(this);
        this.medicationsClasses = medicationsClasses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
