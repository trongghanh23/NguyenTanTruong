package com.example.smartphones.repository.customer;

import com.example.smartphones.dto.ICustomerDto;
import com.example.smartphones.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    //    @Query(value = "select customer.id as id, customer.address as address,customer.day_of_birth as dayOfBirth," +
//            "customer.email as email,customer.gender as gender,customer.id_card as idCard,customer.phone_number as phoneNumber," +
//            "customer_type.id as idCustomerType,customer_type.name as nameCustomerType," +
//            "user.username as username,user.password as password" +
//            "from customer" +
//            "join user on customer.username=user.username" +
//            "join customer_type on customer.customer_type_id=customer_type.id" +
//            "where user.username like %username%" +
//            "and customer.is_delete=0",
//            nativeQuery = true)
//    Customer findCustomer(@Param("username") String username);
    @Query(value = "select * from customer where is_delete = 0 and username = :username", nativeQuery = true)
    Customer findCustomerByUsername(@Param("username") String username);
}
