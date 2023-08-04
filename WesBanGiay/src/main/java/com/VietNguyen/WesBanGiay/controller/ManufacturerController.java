package com.VietNguyen.WesBanGiay.controller;

import com.VietNguyen.WesBanGiay.entity.Manufacturer;
import com.VietNguyen.WesBanGiay.services.IManufacturerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/manufacturer")
public class ManufacturerController {
    @Autowired
    private IManufacturerServices iManufacturerServices;

    @GetMapping("/")
    public List<Manufacturer> getAllMan(){
        return iManufacturerServices.getAllMan();
    }
}
