package com.rewards.program.service;

import com.rewards.program.model.RewardResponse;
import com.rewards.program.model.Transaction;
import com.rewards.program.model.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    public ResponseEntity<RewardResponse> getRewards(Integer customerId) {
    //Get total monthly rewards for the customer

        return null;
    }

    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCustomerId(Integer.parseInt(transaction.getCustomerId()));
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setRewardPoints(calculateRewards(Integer.parseInt(transaction.getAmount())));

        transactionRepository.save(transactionEntity);
        transaction.setId(transactionEntity.getId().toString());
        return ResponseEntity.ok(transaction);
    }

    private int calculateRewards(double amountSpent) {
        int pointsOver100 = (int) Math.max(0, amountSpent - 100) * 2;
        int pointsBetween50And100 = (int) Math.min(50, Math.max(0, amountSpent - 50));
        int totalPoints = pointsOver100 + pointsBetween50And100;
        return totalPoints;
    }


    public ResponseEntity<List<Transaction>> getTransactions() {
        List<TransactionEntity> result = transactionRepository.findAll();
        List<Transaction> transactionList = new ArrayList<Transaction>();
        for (TransactionEntity entity : result) {
            Transaction transaction = new Transaction();
            transaction.setId(entity.getId().toString());
            transaction.setCustomerId(entity.getCustomerId().toString());
            transaction.setAmount(entity.getAmount());
            transactionList.add(transaction);
        }
        return ResponseEntity.ok(transactionList);
    }

}