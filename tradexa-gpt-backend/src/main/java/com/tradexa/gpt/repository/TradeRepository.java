package com.tradexa.gpt.repository;

import com.tradexa.gpt.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<Trade,Integer> {
}
