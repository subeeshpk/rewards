package com.rewards.program.common;

import javax.persistence.SqlResultSetMapping;

public class Constants {

    public static final String REWARD_REPORT_QUERY_NAME = "REPORT_QUERY_NAME";
    public static final String REWARD_REPORT_QUERY = "SELECT T.CUSTOMER_ID as customerId, " +
            "  SUM(REWARD_POINTS) AS monthlyPoints, " +
            "  CONCAT(YEAR(TRANSACTION_DATE), '-', MONTH(TRANSACTION_DATE)) AS monthAndYear " +
            "  FROM Transaction T WHERE TRANSACTION_DATE BETWEEN :startDate AND :endDate " +
            "GROUP BY CUSTOMER_ID, CONCAT(YEAR(TRANSACTION_DATE), '-', MONTH(TRANSACTION_DATE))";
    public static final String REWARD_REPORT_QUERY_MAPPER = "REWARD_REPORT_QUERY_MAPPER";


}
