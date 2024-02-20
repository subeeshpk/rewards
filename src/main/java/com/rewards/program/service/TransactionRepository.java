package com.rewards.program.service;

import com.rewards.program.model.TransactionEntity;
import com.rewards.program.model.TransactionReportHelper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;
import static com.rewards.program.Constants.REWARD_REPORT_QUERY_NAME;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query(name = REWARD_REPORT_QUERY_NAME, nativeQuery = true)
    List<TransactionReportHelper> fetchMonthlyReport(@Param("startDate") LocalDateTime startDate,
                                                     @Param("endDate") LocalDateTime endDate);
}
