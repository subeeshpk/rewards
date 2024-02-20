package com.rewards.program.service;

import com.rewards.program.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    public ResponseEntity<List<RewardResponse>> getRewards() {
        List<TransactionReportHelper>  transactionReportHelper =
                transactionRepository.fetchMonthlyReport(LocalDateTime.now().minusMonths(3),
                        LocalDateTime.now());
        List<RewardResponse> rewardResponses = null;
        if (!CollectionUtils.isEmpty(transactionReportHelper)) {
            Map<String, List<TransactionReportHelper>> customerMap = transactionReportHelper.stream()
                    .collect(Collectors.groupingBy(TransactionReportHelper::getCustomerId));
                   rewardResponses = customerMap.entrySet().stream()
                    .map(entry -> {
                        List<TransactionReportHelper> transactionReportHelpers = entry.getValue();
                        int totalRewards = transactionReportHelpers.stream()
                                .mapToInt(TransactionReportHelper::getMonthlyPoints)
                                .sum();
                        List<RewardResponseMonthlyRewards> monthlyRewardsList = transactionReportHelpers.stream()
                                .map(helper -> {
                                    RewardResponseMonthlyRewards monthlyRewards = new RewardResponseMonthlyRewards();
                                    monthlyRewards.setRewardPoint(helper.getMonthlyPoints());
                                    monthlyRewards.setMonth(helper.getMonthAndYear());
                                    return monthlyRewards;
                                })
                                .collect(Collectors.toList());
                        RewardResponse rewardResponse = new RewardResponse();
                        rewardResponse.setCustomerId(entry.getKey());
                        rewardResponse.setTotalReward(totalRewards);
                        rewardResponse.setMonthlyRewards(monthlyRewardsList);
                        return rewardResponse;
                    })
                    .collect(Collectors.toList());
        }
    return ResponseEntity.ok(rewardResponses);
    }

    public ResponseEntity<Transaction> saveTransaction(Transaction transaction) {
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setCustomerId(transaction.getCustomerId());
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setRewardPoints(calculateRewards(transaction.getAmount()));
        transactionRepository.save(transactionEntity);
        transaction.setId(transactionEntity.getId().toString());
        transaction.setTransactionDate(transactionEntity.getTransactionDate().toString());
        return ResponseEntity.ok(transaction);
    }

    private int calculateRewards(double amountSpent) {
        int rewardPoints = 0;
        if (amountSpent > 100) {
            rewardPoints += 2 * (int) (amountSpent - 100);
        }
        if (amountSpent > 50) {
            rewardPoints += (int) Math.min(50, amountSpent - 50);
        }
        return rewardPoints;

    }

    public ResponseEntity<List<Transaction>> getTransactions() {
        List<TransactionEntity> result = transactionRepository.findAll();
        List<Transaction> transactionList = new ArrayList<Transaction>();
        for (TransactionEntity entity : result) {
            Transaction transaction = new Transaction();
            transaction.setId(entity.getId().toString());
            transaction.setCustomerId(entity.getCustomerId().toString());
            transaction.setAmount(entity.getAmount());
            transaction.setTransactionDate(entity.getTransactionDate().toString());
            transactionList.add(transaction);
        }
        return ResponseEntity.ok(transactionList);
    }

}