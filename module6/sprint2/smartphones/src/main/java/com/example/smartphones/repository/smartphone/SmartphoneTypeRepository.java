package com.example.smartphones.repository.smartphone;

import com.example.smartphones.model.smartphone.SmartphoneType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneTypeRepository extends JpaRepository<SmartphoneType,Integer> {
}
