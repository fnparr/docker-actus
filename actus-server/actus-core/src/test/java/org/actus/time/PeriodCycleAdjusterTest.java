/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.time;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeriodCycleAdjusterTest {

    @Test
    public void test_plus_1Ms() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1ML1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2016-02-01T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_1Ms() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1ML1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2015-12-01T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

    @Test
    public void test_plus_1Ws() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1WL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2016-01-08T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_1Ws() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1WL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2015-12-25T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

    @Test
    public void test_plus_1Ys() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1YL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2017-01-01T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_1Ys() {
        
        // instantiate adjuster
        PeriodCycleAdjuster adjuster = new PeriodCycleAdjuster("P1YL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2016-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2015-01-01T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

}
