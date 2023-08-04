package com.VietNguyen.WesBanGiay.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long price;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    @JsonIgnore
    private Manufacturer manufacturer;
}