package com.VietNguyen.WesBanGiay.services;

import com.VietNguyen.WesBanGiay.entity.Manufacturer;
import com.VietNguyen.WesBanGiay.repository.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufacturerImpl implements IManufacturerServices{
    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @Override
    public List<Manufacturer> getAllMan() {
        return manufacturerRepository.findAll();
    }
}
