/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.contracts;

import org.actus.testutils.*;
import org.actus.attributes.ContractModel;
import org. actus.events.ContractEvent;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;

public class CreditEnhancementCollateralTest {
    @TestFactory
    public Stream<DynamicTest> test() {
        String testFile = "./src/test/resources/actus/actus-tests-cec.json";

        // read tests from file
        Map<String, TestData> tests = ContractTestUtils.readTests(testFile);

        // get ids of tests
        Set<String> testIds = tests.keySet();

        // go through test-id and perform test
        return testIds.stream().map(testId -> {

            // extract test for test ID
            TestData test = tests.get(testId);

            // create contract model from data
            ContractModel terms = ContractTestUtils.createModel(tests.get(testId).getTerms());

            // create market model from data
            List<ObservedDataSet> dataObserved = new ArrayList<ObservedDataSet>(test.getDataObserved().values());
            List<ObservedEvent> eventsObserved = new ArrayList<>(test.getEventsObserved());
            DataObserver observer = ContractTestUtils.createObserver(dataObserved, ContractTestUtils.readObservedEvents(eventsObserved,terms));
            
            // compute and evaluate schedule
            LocalDateTime to = LocalDateTime.parse(test.getto());
            ArrayList<ContractEvent> schedule = CreditEnhancementCollateral.schedule(to, terms);            
            schedule = CreditEnhancementCollateral.apply(schedule, terms, observer);

            // extract test results
            List<ResultSet> expectedResults = test.getResults();
            expectedResults.forEach(ResultSet::setValues);

            // transform schedule to event list and return
            List<ResultSet> computedResults = new ArrayList<>();
            ResultSet sampleFields;
            int i = 0;
            for(ContractEvent event : schedule){
                try{
                    sampleFields = expectedResults.get(i);
                    i++;
                }catch (IndexOutOfBoundsException e) {
                    sampleFields = expectedResults.get(i-1);
                }
                ResultSet result = new ResultSet();
                result.setRequiredValues(sampleFields.getValues(), event.getAllStates());
                computedResults.add(result);
            }

            // round results to available precision
            computedResults.forEach(result -> result.roundTo(10));
            expectedResults.forEach(result -> result.roundTo(10));

            // create dynamic test
            return DynamicTest.dynamicTest("Test: " + testId,
                    () -> Assertions.assertArrayEquals(expectedResults.toArray(), computedResults.toArray()));
        });
    }
}