package com.nipuna.bidding.system.controller;

import com.nipuna.bidding.system.dto.requestDto.BidRequestDto;
import com.nipuna.bidding.system.dto.requestDto.ProductRequestDto;
import com.nipuna.bidding.system.dto.responseDto.BidResponseDto;
import com.nipuna.bidding.system.dto.responseDto.ProductResponseDto;
import com.nipuna.bidding.system.service.BidService;
import com.nipuna.bidding.system.service.ProductService;
import com.nipuna.bidding.system.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/bid")
public class BidController {

    private final BidService bidService;

    @PostMapping("/create")
    public ResponseEntity<StandardResponse> createBid(@RequestBody BidRequestDto bidRequestDto) {
        BidResponseDto result = bidService.createBid(bidRequestDto);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Create Bid successfully",
                        result
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/getAll")
    public ResponseEntity<StandardResponse> getAllBids() {
        List<BidResponseDto> result = bidService.getAllBids();
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(
                        HttpStatus.OK.value(),
                        "Get all Bids successfully",
                        result
                ),
                HttpStatus.OK
        );
    }
}
