package com.nipuna.bidding.system.service.impl;

import com.nipuna.bidding.system.dto.requestDto.BidRequestDto;
import com.nipuna.bidding.system.dto.responseDto.BidResponseDto;
import com.nipuna.bidding.system.mapper.BidMapper;
import com.nipuna.bidding.system.model.Bid;
import com.nipuna.bidding.system.repository.BidRepository;
import com.nipuna.bidding.system.service.BidService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BidServiceImpl implements BidService {

    private final BidRepository bidRepository;
    private final BidMapper bidMapper;

    @Override
    public BidResponseDto createBid(BidRequestDto bidRequestDto) {
        Bid bid = bidMapper.requestDtoToEntity(bidRequestDto);
        bidRepository.save(bid);
        return bidMapper.entityToResponseDto(bid);
    }

    @Override
    public List<BidResponseDto> getAllBids() {
        return null;
    }
}
