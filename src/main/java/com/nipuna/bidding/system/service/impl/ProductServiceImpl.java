package com.nipuna.bidding.system.service.impl;

import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;
import com.nipuna.bidding.system.exception.CustomDatabaseException;
import com.nipuna.bidding.system.exception.CustomGenericException;
import com.nipuna.bidding.system.mapper.ProductMapper;
import com.nipuna.bidding.system.model.Product;
import com.nipuna.bidding.system.repository.ProductRepository;
import com.nipuna.bidding.system.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.requestDtoToEntity(productRequestDto);
        try {
            productRepository.save(product);
            return productMapper.entityToResponseDto(product);
        } catch (DataAccessException e) {
            LOGGER.error("Failed to save product due to data access issue: {}", e.getMessage());
            throw new CustomDatabaseException("Error saving product: Database issue", e);
        } catch (Exception e) {
            LOGGER.error("Unexpected error occurred while saving product: {}", e.getMessage());
            throw new CustomGenericException("Error saving product: Unexpected issue");
        }
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for (Product product : productList) {
            productResponseDtoList.add(productMapper.entityToResponseDto(product));
        }
        return productResponseDtoList;
    }
}
