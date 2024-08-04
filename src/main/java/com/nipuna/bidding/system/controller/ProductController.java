package com.nipuna.bidding.system.controller;

import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;
import com.nipuna.bidding.system.service.ProductService;
import com.nipuna.bidding.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createProduct(@RequestBody ProductRequestDto productRequestDto) {
        ProductResponseDto result = productService.createProduct(productRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Create product successfully",
                        result
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<StandardResponse> getAllProduct() {
        List<ProductResponseDto> result = productService.getAllProduct();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all product successfully",
                        result
                ),
                HttpStatus.OK
        );
    }
}
