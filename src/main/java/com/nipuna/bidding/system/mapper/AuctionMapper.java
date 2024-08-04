package com.nipuna.bidding.system.mapper;

import com.nipuna.bidding.system.dto.responseDto.AuctionResponseDto;
import com.nipuna.bidding.system.model.Auction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuctionMapper {
    public AuctionResponseDto entityToResponseDto(Auction auction) {
        AuctionResponseDto auctionResponseDto = new AuctionResponseDto();
        auctionResponseDto.setId(auction.getId());
        auctionResponseDto.setName(auction.getName());
        auctionResponseDto.setDescription(auction.getDescription());
        auctionResponseDto.setStartDate(auction.getStartDate());
        auctionResponseDto.setStartPrice(auction.getStartPrice());
        auctionResponseDto.setProduct(auction.getProduct());
        auctionResponseDto.setBid(auction.getBid());
        auctionResponseDto.setCreatedAt(auction.getCreatedAt());
        auctionResponseDto.setUpdatedAt(auction.getUpdatedAt());
        return auctionResponseDto;
    }
}
