package com.nipuna.bidding.system.service;

import com.nipuna.bidding.system.dto.requestDto.AuctionRequestDto;
import com.nipuna.bidding.system.dto.responseDto.AuctionResponseDto;

import java.util.List;

public interface AuctionService {

    List<AuctionResponseDto> getAllAuction();
    AuctionResponseDto createAuction(AuctionRequestDto auctionRequestDto);
}
