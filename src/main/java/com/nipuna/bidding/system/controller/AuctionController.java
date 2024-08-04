package com.nipuna.bidding.system.controller;

import com.nipuna.bidding.system.dto.requestDto.AuctionRequestDto;
import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.AuctionResponseDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;
import com.nipuna.bidding.system.service.AuctionService;
import com.nipuna.bidding.system.service.ProductService;
import com.nipuna.bidding.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/auction")
public class AuctionController {

    private final AuctionService auctionService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createAuction(@RequestBody AuctionRequestDto auctionRequestDto) {
        AuctionResponseDto result = auctionService.createProduct(auctionRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Create auction successfully",
                        result
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<StandardResponse> getAllProduct() {
        List<AuctionResponseDto> result = auctionService.getAllAuction();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all auction successfully",
                        result
                ),
                HttpStatus.OK
        );
    }
}
