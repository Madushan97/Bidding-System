package com.nipuna.bidding.system.dto.responseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionResponseDto {

    private Integer Id;
    private String name;
    private String description;
    private Date startDate;
    private BigDecimal startPrice;
    private Date createdAt;
    private Date updatedAt;
}
