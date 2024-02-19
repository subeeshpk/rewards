package com.rewards.program.service;

import com.rewards.program.model.Transaction;
import com.rewards.program.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

   // @Query(value = "SELECT SUM(rewardPoints) FROM Transaction WHERE customerId = :customerId", nativeQuery = true)

   // Integer calculateRewards(Integer customerId);

    @Query(value = "SELECT \n" +
            "    A.CUSTOMERID AS CUSTOMERID, \n" +
            "    A.monthly_rewards AS rewardPoints, \n" +
            "    SUM(A.monthly_rewards) AS totalRewards \n" +
            "FROM (\n" +
            "    SELECT \n" +
            "        t.CUSTOMERID AS CUSTOMERID,\n" +
            "        CONCAT(YEAR(t.transactionDate), '-', MONTH(t.transactionDate)) AS monthly_rewards \n" +
            "    FROM \n" +
            "        Transaction t \n" +
            "    WHERE \n" +
            "        t.CUSTOMERID = :customerId AND\n" +
            "        t.transactionDate BETWEEN :startDate AND :endDate \n" +
            "    GROUP BY \n" +
            "        t.CUSTOMERID, \n" +
            "        CONCAT(YEAR(t.transactionDate), '-', MONTH(t.transactionDate))\n" +
            ") A;\n", nativeQuery = true)
    List<TransactionEntity> findRewardReportByCustomer(@Param("customerId") String customerId,
                                                       @Param("startDate") LocalDateTime startDate,
                                                       @Param("endDate") LocalDateTime endDate);

}
