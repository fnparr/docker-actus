/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.conventions.daycount;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * ActualThreeThirtySix(A/336)
 * 
 */
public class ActualThreeThirtySixTest {

	ActualThreeThirtySix convention = new ActualThreeThirtySix();
	
    LocalDateTime localDate1 = LocalDateTime.parse("2019-02-01T00:00:00");
    LocalDateTime localDate2 = LocalDateTime.parse("2019-04-30T00:00:00");
    LocalDateTime localDate3 = LocalDateTime.parse("2019-06-30T00:00:00");
    
    @Test
    public void test_daycount_ActualThreeThirtySix_1() {
        double result = 88.0;
        assertEquals(result, convention.dayCount(localDate1,localDate2),0);
    }

    @Test
    public void test_dayCountFraction_ActualThreeThirtySix_1() {
        double result =0.2619047619047619; // 88 divided by 336
        assertEquals(result, convention.dayCountFraction(localDate1,localDate2),0.0);
    }

    @Test
    public void test_daycount_ActualThreeThirtySix_2() {
        double result = 149.0;
        assertEquals(result, convention.dayCount(localDate1,localDate3),0);
    }
    
    @Test
    public void test_dayCountFraction_ActualThreeThirtySix_2() {
        double result =0.44345238095238093; // 149 divided by 336
        assertEquals(result, convention.dayCountFraction(localDate1,localDate3),0.0);
    }
}
