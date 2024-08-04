package com.nipuna.bidding.system.dto.responseDto;

import com.nipuna.bidding.system.model.Auction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BidResponseDto {

    private Integer id;
    private BigDecimal biddingPrice;
    private Auction auction;
    private Date createdAt;
    private Date updatedAt;
}
