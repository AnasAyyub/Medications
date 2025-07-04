package com.pres.medications.controllers;

import com.pres.medications.models.Medication;
import com.pres.medications.models.MedicationClass;
import com.pres.medications.services.MedicationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medications")
public class medications {
    private MedicationsService mService;

    public medications(MedicationsService mService){
        this.mService=mService;
    }

    @GetMapping("/{id}")
    public Medication getAllDrugs(@PathVariable int id){
        return mService.getMedication(id);
    }

}
