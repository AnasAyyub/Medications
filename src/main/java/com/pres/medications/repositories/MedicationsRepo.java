package com.pres.medications.repositories;


import com.pres.medications.models.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationsRepo extends JpaRepository<Data,Integer> {

}
