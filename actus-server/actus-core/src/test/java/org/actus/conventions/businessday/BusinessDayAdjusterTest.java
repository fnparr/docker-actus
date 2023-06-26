/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.conventions.businessday;

import org.actus.conventions.businessday.BusinessDayAdjuster;
import org.actus.time.calendar.NoHolidaysCalendar;
import org.actus.time.calendar.MondayToFridayCalendar;
import org.actus.types.BusinessDayConventionEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessDayAdjusterTest {

    @Test
    public void test_SAME_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.NOS, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SAME_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.NOS, new MondayToFridayCalendar());
        
               // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SCF_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCF, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SCF_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCF, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
        @Test
    public void test_CSF_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSF, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_CSF_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSF, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
        @Test
    public void test_SCMF_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCMF, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SCMF_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCMF, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
            @Test
    public void test_CSMF_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSMF, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_CSMF_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSMF, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
                @Test
    public void test_SCP_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCP, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SCP_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCP, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
    @Test
    public void test_CSP_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSP, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_CSP_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSP, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
    @Test
    public void test_SCMP_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCMP, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_SCMP_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.SCMP, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }
    
                @Test
    public void test_CSMP_NoHolidaysCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSMP, new NoHolidaysCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

    @Test
    public void test_CSMP_MondayToFridayCalendar() {
        BusinessDayAdjuster adjuster = new BusinessDayAdjuster(BusinessDayConventionEnum.CSMP, new MondayToFridayCalendar());
        
        // list of unadjusted times
        List<LocalDateTime> unadjustedTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        unadjustedTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected event times shifted according to the business day convention
        // here in fact unshifted
        List<LocalDateTime> expectedEventTimes = new ArrayList<LocalDateTime>();
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0)); 
        expectedEventTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // list of expected calc times shifted according to the business day convention
        // here in fact unshifted        
        List<LocalDateTime> expectedCalcTimes = new ArrayList<LocalDateTime>();
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 29, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 4, 30, 0, 0));
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 1, 0, 0)); 
        expectedCalcTimes.add(LocalDateTime.of(2016, 5, 2, 0, 0));
        
        // now shift times to event times according to the business day convention, ...
        List<LocalDateTime> shiftedEventTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedEventTimes.add(adjuster.shiftEventTime(t)));
        
        // ... and shift times to calc times according to the business day convention
        List<LocalDateTime> shiftedCalcTimes = new ArrayList<LocalDateTime>();
        unadjustedTimes.forEach(t -> shiftedCalcTimes.add(adjuster.shiftCalcTime(t)));
        
        // finally compare unshifted and shifted times
        assertEquals(expectedEventTimes, shiftedEventTimes);
        assertEquals(expectedCalcTimes, shiftedCalcTimes);
    }

}
