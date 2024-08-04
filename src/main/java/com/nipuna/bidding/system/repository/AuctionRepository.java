package com.nipuna.bidding.system.repository;

import com.nipuna.bidding.system.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<Auction, Integer> {

}
