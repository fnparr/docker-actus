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
 * TwentyEightThreeThirtySixTest(28/336)
 * 
 */
public class TwentyEightThreeThirtySixTest {

	TwentyEightThreeThirtySix convention = new TwentyEightThreeThirtySix();

	LocalDateTime localDate1 = LocalDateTime.parse("2019-03-01T00:00:00");
	LocalDateTime localDate2 = LocalDateTime.parse("2019-03-31T00:00:00");
	LocalDateTime localDate3 = LocalDateTime.parse("2019-04-30T00:00:00");
	LocalDateTime localDate4 = LocalDateTime.parse("2019-05-30T23:00:00");

	@Test
	public void test_daycount_TwentyEightThreeThirtySix_1() {
		double result = 27.0;
		assertEquals(result, convention.dayCount(localDate1, localDate2), 0);
	}

	@Test
	public void test_dayCountFraction_TwentyEightThreeThirtySix_1() {
		double result = 0.08035714285714286; // 27 divided by 336 (not leap year basis)
		assertEquals(result, convention.dayCountFraction(localDate1, localDate2), 0);
	}

	@Test
	public void test_daycount_TwentyEightThreeThirtySix_2() {
		double result = 55.0;
		assertEquals(result, convention.dayCount(localDate1, localDate3), 0);
	}

	@Test
	public void test_dayCountFraction_TwentyEightThreeThirtySix_2() {
		double result = 0.1636904761904762; // 55 divided by 336 (not leap year basis)
		assertEquals(result, convention.dayCountFraction(localDate1, localDate3), 0);
	}

	@Test
	public void test_daycount_TwentyEightThreeThirtySix_3() {
		double result = 83.0;
		assertEquals(result, convention.dayCount(localDate1, localDate4), 0);
	}

	@Test
	public void test_dayCountFraction_TwentyEightThreeThirtySix_3() {
		double result = 0.24702380952380953; // 83 divided by 336 (not leap year basis)
		assertEquals(result, convention.dayCountFraction(localDate1, localDate4), 0);
	}
}
