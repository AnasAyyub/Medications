package com.pres.medications.services;

import com.pres.medications.models.Data;
import com.pres.medications.models.Medication;
import com.pres.medications.models.MedicationClass;
import com.pres.medications.repositories.MedicationsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationsService {


    private MedicationsRepo medicationsRepo;

    public MedicationsService(MedicationsRepo medicationsRepo) {
        this.medicationsRepo = medicationsRepo;
    }

    public Data getMedication(int id){
        return medicationsRepo.findById(id).orElseThrow();
    }

    public void save(Data data){
        medicationsRepo.save(data);
    }
}
