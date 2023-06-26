/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.time;

import org.actus.AttributeConversionException;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;;

public class WeekdayCycleAdjusterTest {

    @Test
    public void test_AttributeConversionException_cycle_P1XL0() {
        assertThrows(AttributeConversionException.class, () -> 
                                new WeekdayCycleAdjuster("P1XL0"));
    }
    
    @Test
    public void test_AttributeConversionException_cycle_1FrxShort() {
        assertThrows(AttributeConversionException.class, () -> 
                                new WeekdayCycleAdjuster("1FrxL1"));
    }

    @Test
    public void test_plus_1MonShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("1MonL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2019-02-04T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_1MonShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("1MonL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-01-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2018-12-03T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

    @Test
    public void test_plus_1FriShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("1FriL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-07-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2019-08-02T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_1FriShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("1FriL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-07-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2019-06-07T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

    @Test
    public void test_plus_3SatShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("3SatL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-10-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2019-11-16T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.plusCycle(t0));
    }

    @Test
    public void test_minus_3SatShort() {
        
        // instantiate adjuster
        WeekdayCycleAdjuster adjuster = new WeekdayCycleAdjuster("3SatL1");

        // original and expected shifted time
        LocalDateTime t0 = LocalDateTime.parse("2019-10-01T00:00:00");
        LocalDateTime t1 = LocalDateTime.parse("2019-09-21T00:00:00");
        
        // finally compare expected and generated times
        assertEquals(t1, adjuster.minusCycle(t0));
    }

}
