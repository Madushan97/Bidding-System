package com.nipuna.bidding.system.mapper;

import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;
import com.nipuna.bidding.system.exception.ProductNameExistException;
import com.nipuna.bidding.system.model.Product;
import com.nipuna.bidding.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ProductRepository productRepository;

    public Product requestDtoToEntity(ProductRequestDto productRequestDto) {
        Product product = new Product();
        if (!productRepository.existsByName(productRequestDto.getName())) {
            product.setName(productRequestDto.getName());
            product.setDescription(productRequestDto.getName().toUpperCase());
            product.setCreatedAt(new Date());
            product.setUpdatedAt(new Date());
        } else {
            throw new ProductNameExistException("Product name already added");
        }


        return product;
    }

    public ProductResponseDto entityToResponseDto(Product product) {
        ProductResponseDto studentResponseDto = new ProductResponseDto();
        studentResponseDto.setId(product.getId());
        studentResponseDto.setName(product.getName());
        studentResponseDto.setDescription(product.getDescription());
        studentResponseDto.setCreatedAt(product.getCreatedAt());
        studentResponseDto.setUpdatedAt(product.getUpdatedAt());
        return studentResponseDto;
    }
}
