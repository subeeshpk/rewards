package com.rewards.program.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import static com.rewards.program.Constants.REWARD_REPORT_QUERY;
import static com.rewards.program.Constants.REWARD_REPORT_QUERY_NAME;
import static com.rewards.program.Constants.REWARD_REPORT_QUERY_MAPPER;

@NamedNativeQuery( name = REWARD_REPORT_QUERY_NAME,
        query = REWARD_REPORT_QUERY,
        resultSetMapping = REWARD_REPORT_QUERY_MAPPER)

@SqlResultSetMapping( name = REWARD_REPORT_QUERY_MAPPER,
        classes = @ConstructorResult(targetClass = TransactionReportHelper.class,
                columns = { @ColumnResult(name = "customerId", type = String.class),
                        @ColumnResult(name = "monthAndYear", type = String.class),
                        @ColumnResult(name = "monthlyPoints", type = Integer.class)}) )

@Entity
@Table(name = "Transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "CUSTOMER_ID")
    private String customerId;

    @Column(name = "TRANSACTION_DATE")
    private LocalDateTime transactionDate;

    @Column(name = "REWARD_POINTS")
    private Integer rewardPoints;

    @Column(name = "AMOUNT")
    private Integer amount;

    @PrePersist
    protected void onCreate() {
        transactionDate = LocalDateTime.now();
    }

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(Integer rewardPoints) {
        this.rewardPoints = rewardPoints;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}

