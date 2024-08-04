package com.nipuna.bidding.system.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BidRequestDto {

    private BigDecimal biddingPrice;
    private Integer auctionId;
}
