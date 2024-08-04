package com.nipuna.bidding.system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "BID")
@Data
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "bidding_price", nullable = false)
    private BigDecimal biddingPrice;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

}
