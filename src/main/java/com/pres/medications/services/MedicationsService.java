package com.pres.medications.services;

import com.pres.medications.models.Medication;
import com.pres.medications.models.MedicationClass;
import com.pres.medications.repositories.MedicationsRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationsService {

//    private MedicationClassService medicationClassService;
//
//    public List<MedicationClass> getAllMedication(int id){
//        return medicationClassService.getAllDrugs(id);
//    }

    private MedicationsRepo medicationsRepo;

    public MedicationsService(MedicationsRepo medicationsRepo) {
        this.medicationsRepo = medicationsRepo;
    }

    public Medication getMedication(int id){
        return medicationsRepo.findById(id).orElseThrow();
    }
}
