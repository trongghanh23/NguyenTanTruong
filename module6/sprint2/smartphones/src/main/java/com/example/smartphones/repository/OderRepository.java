package com.example.smartphones.repository;

import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.model.OderSmartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OderRepository extends JpaRepository<OderSmartphone,Integer> {
    @Query(value = "select oder_smartphone.id as idOrder, oder_smartphone.quantity as quantity,oder_smartphone.time_book_smartphone as timeBookSmartphone," +
            " smartphone.price as price,smartphone_type.id as smartphoneType,smartphone_type.image as image,smartphone_type.`name`as name," +
            " customer.id as customerId,customer.`name` as customerName " +
            " from oder_smartphone " +
            " join smartphone on smartphone.id=oder_smartphone.smartphone_id " +
            " join customer on customer.id= oder_smartphone.customer_id " +
            " join smartphone_type on smartphone_type.id=smartphone.type_smartphone_id " +
            " where oder_smartphone.is_delete = 0 " +
            "and oder_smartphone.`status` = 0 " +
            "and oder_smartphone.quantity > 0  " +
            "and oder_smartphone.customer_id = :id",nativeQuery = true)
    List<SmartphoneDto> findCartByUser(@Param("id") Integer id);
}
