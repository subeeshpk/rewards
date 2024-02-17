package com.rewards.program;
import com.rewards.program.api.TransactionsApiDelegate;
import com.rewards.program.model.RewardResponse;
import com.rewards.program.model.Transaction;
import com.rewards.program.service.RewardsService;
import com.rewards.program.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class TransactionsApiDelegateImpl implements TransactionsApiDelegate {
    @Autowired
    TransactionService transactionService;

    @Autowired
    RewardsService rewardsService;

    @Override
    public ResponseEntity<RewardResponse> getRewards(Integer customerId) {
        return transactionService.getRewards(customerId);
    }

    @Override
    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        return rewardsService.saveTransaction(transaction);
    }

}
