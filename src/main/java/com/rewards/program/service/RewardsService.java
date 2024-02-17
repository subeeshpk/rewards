package com.rewards.program.service;

import com.rewards.program.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RewardsService {

    @Autowired
    private TransactionRepository transactionRepository;

    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {

        transaction.setCustomerId(transaction.getCustomerId());
        transaction.setAmount(transaction.getAmount());

        transactionRepository.save(transaction);

        return ResponseEntity.ok(transaction);
    }
}
