package com.nipuna.bidding.system.repository;

import com.nipuna.bidding.system.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BidRepository extends JpaRepository<Bid, Integer> {

    List<Bid> findByAuctionId(Integer auctionId);

    boolean existsByBiddingPrice(BigDecimal biddingPrice);
}
