/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.conventions.endofmonth;

import org.actus.conventions.endofmonth.EndOfMonthAdjuster;
import org.actus.types.EndOfMonthConventionEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EndOfMonthAdjusterTest {

    @Test
    public void test_SD_StartDateIsNotEOM_CycleM() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.SD, LocalDateTime.of(2016, 02, 1, 0, 0), "P1ML1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }

    @Test
    public void test_SD_StartDateIsEOM_CycleD() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.SD, LocalDateTime.of(2016, 02, 29, 0, 0), "P1DL1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }
    
        @Test
    public void test_SD_StartDateIsEOM_CycleW() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.SD, LocalDateTime.of(2016, 02, 29, 0, 0), "P1WL1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }

    @Test
    public void test_SD_StartDateIsEOM_CycleM() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.SD, LocalDateTime.of(2016, 02, 29, 0, 0), "P1ML1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }
    
    @Test
    public void test_EOM_StartDateIsNotEOM_CycleM() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.EOM, LocalDateTime.of(2016, 02, 1, 0, 0), "P1ML1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }

    @Test
    public void test_EOM_StartDateIsEOM_CycleD() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.EOM, LocalDateTime.of(2016, 02, 29, 0, 0), "P1DL1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }
    
        @Test
    public void test_EOM_StartDateIsEOM_CycleW() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.EOM, LocalDateTime.of(2016, 02, 29, 0, 0), "P1WL1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }

    @Test
    public void test_EOM_StartDateIsEOM_CycleM() {
        EndOfMonthAdjuster adjuster = new EndOfMonthAdjuster(EndOfMonthConventionEnum.EOM, LocalDateTime.of(2016, 02, 29, 0, 0), "P1ML1");

        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 30, 0, 0));

        // list of expected adjusted times
        List<LocalDateTime> expectedTimes = new ArrayList<LocalDateTime>();
        expectedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedTimes.add(LocalDateTime.of(2016, 5, 31, 0, 0));

        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedTimes.add(adjuster.shift(t)));

        // finally compare unshifted and shifted times
        assertEquals(expectedTimes, shiftedTimes);
    }

}
