package com.rewards.program.common;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculationUtilTest {
    @Test
    void calculateRewards() {
        double amountSpent1 = 120;
        double amountSpent2 = 80;
        double amountSpent3 = 45;
        int rewards1 = CalculationUtil.calculateRewards(amountSpent1);
        int rewards2 = CalculationUtil.calculateRewards(amountSpent2);
        int rewards3 = CalculationUtil.calculateRewards(amountSpent3);
        assertEquals(90, rewards1);
        assertEquals(30, rewards2);
        assertEquals(0, rewards3);
    }
}