package com.nipuna.bidding.system.service;

import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDto> getAllProduct();
}
