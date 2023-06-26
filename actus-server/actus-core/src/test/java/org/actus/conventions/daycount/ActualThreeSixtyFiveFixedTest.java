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
public class ActualThreeSixtyFiveFixedTest {

	ActualThreeSixtyFiveFixed convention = new ActualThreeSixtyFiveFixed();

   // define test inputs
   LocalDateTime start1 = LocalDateTime.parse("2006-01-31T00:00:00");
   LocalDateTime start2 = LocalDateTime.parse("2006-01-30T00:00:00");
   LocalDateTime start3 = LocalDateTime.parse("2006-02-28T00:00:00");
   LocalDateTime start4 = LocalDateTime.parse("2006-02-14T00:00:00");
   LocalDateTime start5 = LocalDateTime.parse("2006-09-30T00:00:00");
   LocalDateTime start6 = LocalDateTime.parse("2006-10-31T00:00:00");
   LocalDateTime start7 = LocalDateTime.parse("2007-08-31T00:00:00");
   LocalDateTime start8 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime start9 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime start10 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime start11 = LocalDateTime.parse("2007-02-26T00:00:00");
   LocalDateTime start12 = LocalDateTime.parse("2007-02-26T00:00:00");
   LocalDateTime start13 = LocalDateTime.parse("2008-02-29T00:00:00");
   LocalDateTime start14 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime start15 = LocalDateTime.parse("2008-02-28T00:00:00");
   
   LocalDateTime end1 = LocalDateTime.parse("2006-02-28T00:00:00");
   LocalDateTime end2 = LocalDateTime.parse("2006-02-28T00:00:00");
   LocalDateTime end3 = LocalDateTime.parse("2006-03-03T00:00:00");
   LocalDateTime end4 = LocalDateTime.parse("2006-02-28T00:00:00");
   LocalDateTime end5 = LocalDateTime.parse("2006-10-31T00:00:00");
   LocalDateTime end6 = LocalDateTime.parse("2006-11-28T00:00:00");
   LocalDateTime end7 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime end8 = LocalDateTime.parse("2008-08-28T00:00:00");
   LocalDateTime end9 = LocalDateTime.parse("2008-08-30T00:00:00");
   LocalDateTime end10 = LocalDateTime.parse("2008-08-31T00:00:00");
   LocalDateTime end11 = LocalDateTime.parse("2008-02-28T00:00:00");
   LocalDateTime end12 = LocalDateTime.parse("2008-02-29T00:00:00");
   LocalDateTime end13 = LocalDateTime.parse("2009-02-28T00:00:00");
   LocalDateTime end14 = LocalDateTime.parse("2008-03-30T00:00:00");
   LocalDateTime end15 = LocalDateTime.parse("2008-03-31T00:00:00");

   // define expected test results
   double days1 = 28.0;
   double days2 = 29.0;
   double days3 = 3.0;
   double days4 = 14.0;
   double days5 = 31.0;
   double days6 = 28.0;
   double days7 = 181.0;
   double days8 = 182.0;
   double days9 = 184.0;
   double days10 = 185.0;
   double days11 = 367.0;
   double days12 = 368.0;
   double days13 = 365.0;
   double days14 = 31.0;
   double days15 = 32.0;

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_1() {
       assertEquals(days1, convention.dayCount(start1,end1),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_2() {
       assertEquals(days2, convention.dayCount(start2,end2),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_3() {
       assertEquals(days3, convention.dayCount(start3,end3),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_4() {
       assertEquals(days4, convention.dayCount(start4,end4),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_5() {
       assertEquals(days5, convention.dayCount(start5,end5),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_6() {
       assertEquals(days6, convention.dayCount(start6,end6),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_7() {
       assertEquals(days7, convention.dayCount(start7,end7),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_8() {
       assertEquals(days8, convention.dayCount(start8,end8),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_9() {
       assertEquals(days9, convention.dayCount(start9,end9),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_10() {
       assertEquals(days10, convention.dayCount(start10,end10),0);
   }
   
   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_11() {
       assertEquals(days11, convention.dayCount(start11,end11),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_12() {
       assertEquals(days12, convention.dayCount(start12,end12),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_13() {
       assertEquals(days13, convention.dayCount(start13,end13),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_14() {
       assertEquals(days14, convention.dayCount(start14,end14),0);
   }

   @Test
   public void test_daycount_ActualThreeSixtyFiveFixed_15() {
       assertEquals(days15, convention.dayCount(start15,end15),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_1() {
       assertEquals(days1/365, convention.dayCountFraction(start1,end1),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_2() {
       assertEquals(days2/365, convention.dayCountFraction(start2,end2),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_3() {
       assertEquals(days3/365, convention.dayCountFraction(start3,end3),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_4() {
       assertEquals(days4/365, convention.dayCountFraction(start4,end4),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_5() {
       assertEquals(days5/365, convention.dayCountFraction(start5,end5),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_6() {
       assertEquals(days6/365, convention.dayCountFraction(start6,end6),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_7() {
       assertEquals(days7/365, convention.dayCountFraction(start7,end7),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_8() {
       assertEquals(days8/365, convention.dayCountFraction(start8,end8),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_9() {
       assertEquals(days9/365, convention.dayCountFraction(start9,end9),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_10() {
       assertEquals(days10/365, convention.dayCountFraction(start10,end10),0);
   }
   
   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_11() {
       assertEquals(days11/365, convention.dayCountFraction(start11,end11),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_12() {
       assertEquals(days12/365, convention.dayCountFraction(start12,end12),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_13() {
       assertEquals(days13/365, convention.dayCountFraction(start13,end13),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_14() {
       assertEquals(days14/365, convention.dayCountFraction(start14,end14),0);
   }

   @Test
   public void test_fraction_ActualThreeSixtyFiveFixed_15() {
       assertEquals(days15/365, convention.dayCountFraction(start15,end15),0);
   }
}
