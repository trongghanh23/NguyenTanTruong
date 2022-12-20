package com.example.smartphones.service.smartphone;

import com.example.smartphones.dto.SmartphoneDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ISmartphoneService {
    Page<SmartphoneDto>findAllHome(String name,Pageable pageable);

    Optional<SmartphoneDto>detailSmartphone(Integer id);
}
