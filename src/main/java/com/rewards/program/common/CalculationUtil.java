package com.rewards.program.common;

public class CalculationUtil {
    public static int calculateRewards(double amountSpent) {
        int rewardPoints = 0;
        if (amountSpent > 100) {
            rewardPoints += 2 * (int) (amountSpent - 100);
        }
        if (amountSpent > 50) {
            rewardPoints += (int) Math.min(50, amountSpent - 50);
        }
        return rewardPoints;
    }
}
