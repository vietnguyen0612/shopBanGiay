package com.VietNguyen.WesBanGiay.services;

import com.VietNguyen.WesBanGiay.DTO.GetProductDTO;
import com.VietNguyen.WesBanGiay.DTO.ProductDTO;
import com.VietNguyen.WesBanGiay.entity.Product;

import java.util.List;

public interface IProductServices {
    public Product addProduct(ProductDTO product);

    public List<GetProductDTO> getAllProduct();

    public GetProductDTO getProductByUserId(Long id);

    public Product editProduct(Long id, ProductDTO productDTO);
}
