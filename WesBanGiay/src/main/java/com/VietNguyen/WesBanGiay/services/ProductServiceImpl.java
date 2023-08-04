package com.VietNguyen.WesBanGiay.services;

import com.VietNguyen.WesBanGiay.DTO.GetProductDTO;
import com.VietNguyen.WesBanGiay.DTO.ProductDTO;
import com.VietNguyen.WesBanGiay.entity.Manufacturer;
import com.VietNguyen.WesBanGiay.entity.Product;
import com.VietNguyen.WesBanGiay.entity.User;
import com.VietNguyen.WesBanGiay.repository.ManufacturerRepository;
import com.VietNguyen.WesBanGiay.repository.ProductRepository;
import com.VietNguyen.WesBanGiay.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements IProductServices{
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @Override
    public Product addProduct(ProductDTO product) {
        Product product1 = new Product();
        if(product != null) {
            User user = userRepository.findById(Long.valueOf(product.getProducer_id())).orElse(null);
            Manufacturer manufacturer = manufacturerRepository.findById(Long.valueOf(product.getManufacturer_id())).orElse(null);

            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setImage(product.getImage());
            product1.setDescription(product.getDescription());
            product1.setUser(user);
            product1.setManufacturer(manufacturer);

            return productRepository.save(product1);
        }
        return null;
    }

    @Override
    public List<GetProductDTO> getAllProduct() {
        List<GetProductDTO> productDTOS = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        products = productRepository.findAll();
        for (Product product : products) {
            GetProductDTO productDTO = new GetProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setPrice(product.getPrice());
            if (product.getUser() != null) {
                productDTO.setProducer_id(String.valueOf(product.getUser().getId()));
            }
            if (product.getManufacturer() != null) {
                productDTO.setManufacturer_id(String.valueOf(product.getManufacturer().getId()));
            }
            productDTO.setDescription(product.getDescription());
            productDTO.setImage(product.getImage());

            productDTOS.add(productDTO);
        }


        return productDTOS;
    }

    public GetProductDTO getProductByUserId(Long id) {
        GetProductDTO productDTO = new GetProductDTO();
        Optional<Product> product = Optional.of(new Product());
        product = productRepository.findById(id);
        Product p = product.orElse(new Product());

        productDTO.setId(p.getId());
        productDTO.setName(p.getName());
        productDTO.setDescription(p.getDescription());
        productDTO.setPrice(p.getPrice());
        productDTO.setImage(p.getImage());
        if (p.getUser() != null) {
            productDTO.setProducer_id(String.valueOf(p.getUser().getId()));
        }
        if (p.getManufacturer() != null) {
            productDTO.setManufacturer_id(String.valueOf(p.getManufacturer().getId()));
        }

        return productDTO;
    }

    @Override
    public Product editProduct(Long id, ProductDTO productDTO) {
        if (productDTO != null) {
            Optional<Product> productOptional = productRepository.findById(id);
            if (productOptional.isPresent()) {
                Product product = productOptional.get();
                product.setName(productDTO.getName());
                product.setPrice(productDTO.getPrice());
                product.setDescription(productDTO.getDescription());
                product.setImage(productDTO.getImage());

                return productRepository.save(product);
            }
        }

        return null;
    }

}
