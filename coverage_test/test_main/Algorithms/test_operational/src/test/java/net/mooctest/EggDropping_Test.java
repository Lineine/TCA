package net.mooctest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EggDropping_Test {

    @Test
    @Timeout(4000)
    public void testMinTrials() {
        assertEquals(3, EggDropping.minTrials(2, 4));
        assertEquals(2, EggDropping.minTrials(1, 2));
        assertEquals(4, EggDropping.minTrials(2, 10));
        assertEquals(1, EggDropping.minTrials(1, 1));
        assertEquals(0, EggDropping.minTrials(1, 0));
        assertEquals(0, EggDropping.minTrials(0, 10));
    }

    @Test
    @Timeout(4000)
    public void testMinTrialsNegativeEggs() {
        EggDropping.minTrials(-1, 10);
    }

    @Test
    @Timeout(4000)
    public void testMinTrialsNegativeFloors() {
        EggDropping.minTrials(1, -1);
    }
}