/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.attributes;

import org.actus.AttributeConversionException;

import java.util.Map;
import java.util.HashMap;

import org.actus.types.EndOfMonthConventionEnum;
import org.actus.types.ContractTypeEnum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContractModelTest {

    @Test
    public void test_AttributeConversionException() {
        assertThrows(AttributeConversionException.class, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("contractTyp", "PAM"); // should be "contractType"
            ContractModel model = ContractModel.parse(map);
        });    
    }

    @Test
    public void test_AttributeParser_PAM_MandatoryAttributes() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contractType", "PAM");
        map.put("calendar", "NoHolidayCalendar");
        map.put("statusDate", "2016-01-01T00:00:00");
        map.put("contractRole", "RPA");
        map.put("legalEntityIDCounterparty", "CORP-XY");
        map.put("dayCountConvention", "AA");
        map.put("currency", "USD");
        map.put("initialExchangeDate", "2016-01-02T00:00:00");
        map.put("maturityDate", "2017-01-01T00:00:00");
        map.put("notionalPrincipal", "1000.0");
        ContractModel model = ContractModel.parse(map);
        assertTrue(model.getAs("ContractType").equals(ContractTypeEnum.PAM));
    }

    @Test
    public void test_AttributeParser_PAM_AllAttributes() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("contractType", "PAM");
        map.put("calendar", "NC");
        map.put("businessDayConvention", "SCF");
        map.put("endOfMonthConvention", EndOfMonthConventionEnum.SD.toString());
        map.put("statusDate", "2016-01-01T00:00:00");
        map.put("contractRole", "RPA");
        map.put("legalEntityIDCounterparty", "CORP-XY");
        map.put("cycleAnchorDateOfFee", "2016-01-02T00:00:00");
        map.put("cycleOfFee", "P3ML1");
        map.put("feeBasis", "A");
        map.put("feeRate", "0.05");
        map.put("feeAccrued", "0.0");
        map.put("cycleAnchorDateOfInterestPayment", "2016-01-02T00:00:00");
        map.put("cycleOfInterestPayment", "P1ML0");
        map.put("nominalInterestRate", "0.01");
        map.put("dayCountConvention", "AA");
        map.put("accruedInterest", "0.0");
        map.put("capitalizationEndDate", "2016-04-02T00:00:00");
        map.put("cyclePointOfInterestPayment", "E");
        map.put("currency", "USD");
        map.put("initialExchangeDate", "2016-01-02T00:00:00");
        map.put("premiumDiscountAtIED", "-100.0");
        map.put("maturityDate", "2017-01-01T00:00:00");
        map.put("notionalPrincipal", "1000.0");
        map.put("purchaseDate", "2016-05-01T00:00:00");
        map.put("priceAtPurchaseDate", "800.0");
        map.put("terminationDate", "2016-07-01T00:00:00");
        map.put("priceAtTerminationDate", "900.0");
        map.put("marketObjectCodeOfScalingIndex", "Index-XY");
        map.put("scalingIndexAtStatusDate", "1000.0");
        map.put("cycleAnchorDateOfScalingIndex", "2016-01-02T00:00:00");
        map.put("cycleOfScalingIndex", "P6ML1");
        map.put("scalingEffect", "INO");
        map.put("cycleAnchorDateOfRateReset", "2016-04-02T00:00:00");
        map.put("cycleOfRateReset", "P2ML1");
        map.put("rateSpread", "0.05");
        map.put("marketObjectCodeOfRateReset", "ReferenceRate-XY");
        map.put("cyclePointOfRateReset", "B");
        map.put("fixingDays", "P2D");
        map.put("nextResetRate", "0.08");
        map.put("rateMultiplier", "1.1");
        ContractModel model = ContractModel.parse(map);
        assertTrue(model.getAs("ContractType").equals(ContractTypeEnum.PAM));
    }

}
