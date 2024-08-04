package com.nipuna.bidding.system.dto.responseDto;


import com.nipuna.bidding.system.model.Bid;
import com.nipuna.bidding.system.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionResponseDto {

    private Integer Id;
    private String name;
    private String description;
    private Date startDate;
    private BigDecimal startPrice;
    private Product product;
    private List<Bid> bid;
    private Date createdAt;
    private Date updatedAt;
}
