package com.example.smartphones.repository;

import com.example.smartphones.dto.IBookingDto;
import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.model.OderSmartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
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


    @Query(value = "select count(id) as cartCount " +
            "from oder_smartphone " +
            "where oder_smartphone.customer_id= :id " +
            "and  oder_smartphone.is_delete = 0  " +
            "and oder_smartphone.status = 0 ",nativeQuery = true)
    Optional<IBookingDto> getCartCount(@Param("id") Integer id);

    @Modifying
    @Query(value = "update oder_smartphone set quantity = (quantity + 1) where id = :id and status = 0", nativeQuery = true)
    void ascQuantity(@Param("id") Integer id);

    @Modifying
    @Query(value = "update oder_smartphone set quantity = (quantity - 1) where id = :id and status = 0", nativeQuery = true)
    void descQuantity(@Param("id") Integer id);

    @Query(value = "select * from oder_smartphone where status = 0 and is_delete = 0 and customer_id = :customerId " +
            "and smartphone_id = :smartphoneId", nativeQuery = true)
    Optional<OderSmartphone> getBookingSmartphoneCart(@Param("customerId") Integer customerId,
                                                 @Param("smartphoneId") Integer laptopId);

    @Modifying
    @Query(value = "insert into oder_smartphone (time_book_smartphone , quantity, customer_id,smartphone_id) " +
            "value (now(),:quantity,:customerId,:smartphoneId) ", nativeQuery = true)
    void addSmartphone(@Param("quantity") Integer quantity,
                   @Param("customerId") Integer customerId,
                   @Param("smartphoneId") Integer smartphoneId);
    @Query(value = "update oder_smartphone set quantity = :quantity where status = 0 and customer_id = :customerId " +
            "and smartphone_id = :smartphoneId", nativeQuery = true)
    void setQuantitySmartphone(@Param("quantity") Integer quantity,
                           @Param("customerId") Integer customerId,
                           @Param("smartphoneId") Integer smartphoneId);
}
