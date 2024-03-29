package com.rewards.program;
import com.rewards.program.api.TransactionsApiDelegate;
import com.rewards.program.model.RewardResponse;
import com.rewards.program.model.Transaction;
import com.rewards.program.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionsApiDelegateImpl implements TransactionsApiDelegate {
    @Autowired
    TransactionService transactionService;

    @Override
    public ResponseEntity<List<RewardResponse>> getRewards() {
        return transactionService.getRewards();
    }

    @Override
    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @Override
    public ResponseEntity<List<Transaction>> getTransactions() {
        return transactionService.getTransactions();
    }

}