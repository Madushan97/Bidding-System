package com.nipuna.bidding.system.service;

import com.nipuna.bidding.system.dto.requestDto.BidRequestDto;
import com.nipuna.bidding.system.dto.responseDto.BidResponseDto;

import java.util.List;

public interface BidService {

    BidResponseDto createBid(BidRequestDto bidRequestDto);
    List<BidResponseDto> getAllBids();
}
