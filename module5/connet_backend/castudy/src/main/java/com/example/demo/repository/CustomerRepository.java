package com.example.demo.repository;

import com.example.demo.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = " select * from customer where  is_deleted = 0 and name like %:searchValue% ", nativeQuery = true)
    Page<Customer> findByName(String searchValue, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update customer set is_deleted = 1 where id = :deleteId", nativeQuery = true)
    void delete(@Param("deleteId") int id);

}
