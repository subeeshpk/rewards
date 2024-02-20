package com.rewards.program.common;

import com.rewards.program.model.TransactionEntity;
import com.rewards.program.service.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    @Autowired
    public SampleDataLoader(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        TransactionEntity transaction1 = new TransactionEntity();
        transaction1.setCustomerId("customer1");
        transaction1.setAmount(120);
        transaction1.setRewardPoints(90);
        transaction1.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction1);

        TransactionEntity transaction2 = new TransactionEntity();
        transaction2.setCustomerId("customer2");
        transaction2.setAmount(80);
        transaction2.setRewardPoints(30);
        transaction2.setTransactionDate(LocalDateTime.now());
        transactionRepository.save(transaction2);

        TransactionEntity transaction3 = new TransactionEntity();
        transaction1.setCustomerId("customer1");
        transaction1.setAmount(120);
        transaction1.setRewardPoints(90);
        transaction1.setTransactionDate(LocalDateTime.now().minusMonths(1));
        transactionRepository.save(transaction1);

        TransactionEntity transaction4 = new TransactionEntity();
        transaction2.setCustomerId("customer2");
        transaction2.setAmount(80);
        transaction2.setRewardPoints(30);
        transaction2.setTransactionDate(LocalDateTime.now().minusMonths(2));
        transactionRepository.save(transaction2);

    }
}

