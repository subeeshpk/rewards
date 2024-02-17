package com.rewards.program.service;

import com.rewards.program.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {


    @Query("SELECT SUM(rewardPoints) FROM Transaction WHERE customerId = :customerId")
    Integer calculateRewards(Integer customerId);
}

