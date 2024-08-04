package com.nipuna.bidding.system.service.impl;

import com.nipuna.bidding.system.dto.requestDto.AuctionRequestDto;
import com.nipuna.bidding.system.dto.responseDto.AuctionResponseDto;
import com.nipuna.bidding.system.mapper.AuctionMapper;
import com.nipuna.bidding.system.model.Auction;
import com.nipuna.bidding.system.repository.AuctionRepository;
import com.nipuna.bidding.system.service.AuctionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final AuctionMapper auctionMapper;

    @Override
    public List<AuctionResponseDto> getAllAuction() {
        List<Auction> auctionList = auctionRepository.findAll();
        List<AuctionResponseDto> auctionResponseDtoList = new ArrayList<>();
        for (Auction auction : auctionList ) {
            auctionResponseDtoList.add(auctionMapper.entityToResponseDto(auction));
        }
        return auctionResponseDtoList;
    }

    @Override
    public AuctionResponseDto createAuction(AuctionRequestDto auctionRequestDto) {
        Auction auction = auctionMapper.requestDtoToEntity(auctionRequestDto);
        auctionRepository.save(auction);
        return auctionMapper.entityToResponseDto(auction);
    }
}
