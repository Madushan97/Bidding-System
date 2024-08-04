package com.nipuna.bidding.system.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionRequestDto {

    private String name;
    private String description;
    private Date startDate;
    private BigDecimal startPrice;
}
