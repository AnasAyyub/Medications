package com.pres.medications.controllers;

import com.pres.medications.models.Data;
import com.pres.medications.models.Medication;
import com.pres.medications.models.MedicationClass;
import com.pres.medications.services.MedicationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class medications {
    private MedicationsService mService;

    public medications(MedicationsService mService){
        this.mService=mService;
    }

    @GetMapping("/{id}")
    public Data getAllDrugs(@PathVariable int id){
        return mService.getMedication(id);
    }

    @PostMapping
    public void saveMedication(@RequestBody Data data){
        mService.save(data);
    }

}
