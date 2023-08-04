package com.VietNguyen.WesBanGiay.controller;

import com.VietNguyen.WesBanGiay.DTO.GetProductDTO;
import com.VietNguyen.WesBanGiay.DTO.ProductDTO;
import com.VietNguyen.WesBanGiay.entity.Product;
import com.VietNguyen.WesBanGiay.services.IProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductServices iProductServices;

    @GetMapping("/")
    public List<GetProductDTO> getAllProduct() {
        return iProductServices.getAllProduct();
    }
    @PostMapping("/add")
    public Product addProduct(@RequestBody ProductDTO product){
        return iProductServices.addProduct(product);
    }

    @GetMapping("/{id}")
    public GetProductDTO getProductByUserId (@PathVariable Long id) {
        return iProductServices.getProductByUserId(id);
    }

    @PutMapping("edit/{id}")
    public Product editProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return iProductServices.editProduct(id, productDTO);
    }

}
