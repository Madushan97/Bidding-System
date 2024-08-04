package com.nipuna.bidding.system.mapper;

import com.nipuna.bidding.system.dto.requestDto.BidRequestDto;
import com.nipuna.bidding.system.dto.responseDto.BidResponseDto;
import com.nipuna.bidding.system.exception.BiddingPriceExistException;
import com.nipuna.bidding.system.model.Auction;
import com.nipuna.bidding.system.model.Bid;
import com.nipuna.bidding.system.repository.AuctionRepository;
import com.nipuna.bidding.system.repository.BidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BidMapper {

    private final AuctionRepository auctionRepository;
    private final BidRepository bidRepository;

    public Bid requestDtoToEntity(BidRequestDto bidRequestDto) {
        Bid bid = new Bid();
        Auction currentAuction = auctionRepository.findById(bidRequestDto.getAuctionId()).get();
        if (auctionRepository.existsById(bidRequestDto.getAuctionId())) {
            bid.setAuction(currentAuction);
        }
        if (bidRepository.existsByBiddingPrice(bidRequestDto.getBiddingPrice())) {
            throw new BiddingPriceExistException("Bid should greater than : " + bidRequestDto.getBiddingPrice());
        } else {
            BigDecimal maxPrice = currentAuction.getStartPrice().max(bidRequestDto.getBiddingPrice());
            bid.setBiddingPrice(maxPrice);
            // if the requested bidding value is greater, then rest of bid values should be inactive
            if (!maxPrice.equals(currentAuction.getStartPrice())) {
                List<Bid> bidList = bidRepository.findByAuctionId(currentAuction.getId());
                BigDecimal requestedBiddingPrice = bidRequestDto.getBiddingPrice();

                for (Bid currentBid : bidList) {
                    if (currentBid.getBiddingPrice().compareTo(requestedBiddingPrice) < 0) {
                        currentBid.setActiveStatus(false);
                        bidRepository.save(currentBid);
                        System.out.println("Bid with ID " + currentBid.getId() + " is deactivated.");
                    }
                }
            }

        }
        bid.setActiveStatus(true);
        bid.setCreatedAt(new Date());
        bid.setUpdatedAt(new Date());

        return bid;
    }

    public BidResponseDto entityToResponseDto(Bid bid) {
        BidResponseDto bidResponseDto = new BidResponseDto();
        bidResponseDto.setId(bid.getId());
        bidResponseDto.setBiddingPrice(bid.getBiddingPrice());
        bidResponseDto.setAuction(bid.getAuction());
        bidResponseDto.setCreatedAt(bid.getCreatedAt());
        bidResponseDto.setUpdatedAt(bid.getUpdatedAt());
        return bidResponseDto;
    }
}
