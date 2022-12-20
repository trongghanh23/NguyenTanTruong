package com.example.smartphones.repository.smartphone;

import com.example.smartphones.model.smartphone.Specifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications,Integer> {
}
