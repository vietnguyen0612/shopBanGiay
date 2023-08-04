package com.VietNguyen.WesBanGiay.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetProductDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private String producer_id;
    private String manufacturer_id;
    private Long price;
}
