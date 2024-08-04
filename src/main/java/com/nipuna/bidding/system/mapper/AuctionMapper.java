package com.nipuna.bidding.system.mapper;

import com.nipuna.bidding.system.dto.requestDto.AuctionRequestDto;
import com.nipuna.bidding.system.dto.responseDto.AuctionResponseDto;
import com.nipuna.bidding.system.exception.ResourceNotFoundException;
import com.nipuna.bidding.system.model.Auction;
import com.nipuna.bidding.system.model.Product;
import com.nipuna.bidding.system.repository.AuctionRepository;
import com.nipuna.bidding.system.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class AuctionMapper {

    private final ProductRepository productRepository;

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

    public Auction requestDtoToEntity(AuctionRequestDto auctionRequestDto) {

        Auction auction = new Auction();

        auction.setStartDate(auctionRequestDto.getStartDate());
        auction.setName(auctionRequestDto.getName());
        if (productRepository.existsById(auctionRequestDto.getProductId())) {
            Product product = productRepository.findById(auctionRequestDto.getProductId()).get();
            auction.setProduct(product);
        } else {
            throw new ResourceNotFoundException("Product is unavailable");
        }
        auction.setCreatedAt(new Date());
        auction.setUpdatedAt(new Date());
        auction.setDescription(auctionRequestDto.getName().toUpperCase());
        auction.setName(auction.getName());
        auction.setStartPrice(auctionRequestDto.getStartPrice());

        return auction;
    }
}
