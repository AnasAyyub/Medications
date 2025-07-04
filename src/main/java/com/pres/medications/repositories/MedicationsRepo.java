package com.pres.medications.repositories;


import com.pres.medications.models.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepo extends JpaRepository<Medication,Integer> {

}
