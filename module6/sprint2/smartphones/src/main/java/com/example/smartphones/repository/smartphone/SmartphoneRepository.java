package com.example.smartphones.repository.smartphone;

import com.example.smartphones.dto.IHistoryDto;
import com.example.smartphones.dto.SmartphoneDto;
import com.example.smartphones.model.smartphone.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
    @Query(value = "select smartphone.price as price,smartphone.id as id, " +
            "specifications.front_camera as frontCamera,specifications.rear_camera as rearCamera," +
            "specifications.screen as screen," +
            "specifications.storage as storage,specifications.processor_chip as processorChip," +
            "smartphone_type.name as SmartphoneType,smartphone_type.image as image " +
            "from smartphone " +
            "join specifications on smartphone.specifications_id=specifications.id " +
            "join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id " +
            " where smartphone_type.name like %:keyword%",
            countQuery = "select count(*)" +
                    "from smartphone " +
                    "join specifications on smartphone.specifications_id=specifications.id " +
                    "join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id " +
                    "where smartphone_type.name like %:keyword%", nativeQuery = true)
    Page<SmartphoneDto> findAllSmartphone(Pageable pageable, @Param("keyword") String name);

    @Query(value = "select smartphone.price as price,smartphone.id as id, " +
            "specifications.front_camera as frontCamera,specifications.rear_camera as rearCamera," +
            "specifications.screen as screen," +
            "specifications.storage as storage,specifications.processor_chip as processorChip," +
            "smartphone_type.name as SmartphoneType,smartphone_type.image as image " +
            "from smartphone " +
            "join specifications on smartphone.specifications_id=specifications.id " +
            "join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id " +
            " where smartphone_type.name like %:keyword%",
            countQuery = "select count(*)" +
                    "from smartphone " +
                    "join specifications on smartphone.specifications_id=specifications.id " +
                    "join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id " +
                    "where smartphone_type.name like %:keyword%", nativeQuery = true)
    Page<SmartphoneDto> findAllSmartphoneType(Pageable pageable, @Param("keyword") String name);

    @Query(value = "select smartphone.insurance as insurance, smartphone.price as price, smartphone.producer as producer,smartphone.id as id, " +
            "            smartphone_type.image as image, smartphone_type.name as name," +
            "            specifications.bettery as bettery,specifications.charge as charge,specifications.front_camera as frontCamera," +
            "            specifications.operating_system as operatingSystem, " +
            "            specifications.processor_chip as processorChip,specifications.rear_camera as rearCamera," +
            "            specifications.ram as ram, specifications.screen as screen,specifications.storage as storage " +
            "            from smartphone " +
            "            join smartphone_type on smartphone.type_smartphone_id=smartphone_type.id " +
            "            join specifications on smartphone.specifications_id=specifications.id " +
            "            where smartphone.id = :id ", nativeQuery = true)
    Optional<SmartphoneDto> detailSmartphone(@Param("id") Integer id);

    @Query(value = "select oder_smartphone.time_book_smartphone as timeBookSmartphone,oder_smartphone.quantity as quantity,smartphone_type.name as nameType,smartphone.price as price , " +
            "            (oder_smartphone.quantity * smartphone.price) as total " +
            "            from oder_smartphone " +
            "            join customer " +
            "            on oder_smartphone.customer_id=customer.id " +
            "            join smartphone " +
            "            on oder_smartphone.smartphone_id= smartphone.id " +
            "            join smartphone_type " +
            "            on smartphone_type.id=smartphone.type_smartphone_id " +
            "            where  customer.username = username     and oder_smartphone.status=1 and oder_smartphone.is_delete = 0 " +
            "            order by oder_smartphone.time_book_smartphone desc ",
            countQuery = "select count(*) from oder_smartphone " +
                    "            join customer " +
                    "            on oder_smartphone.customer_id=customer.id " +
                    "            join smartphone " +
                    "            on oder_smartphone.smartphone_id= smartphone.id " +
                    "            join smartphone_type " +
                    "            on smartphone_type.id=smartphone.type_smartphone_id " +
                    "            where  customer.username = username     and oder_smartphone.status=1 and oder_smartphone.is_delete = 0 " +
                    "            order by oder_smartphone.time_book_smartphone desc ", nativeQuery = true)
    Page<IHistoryDto> getAll(@Param("username") String username, Pageable pageable);

}
