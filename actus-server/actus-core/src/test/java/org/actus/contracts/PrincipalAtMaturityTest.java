/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.contracts;

import org.actus.testutils.ContractTestUtils;
import org.actus.testutils.TestData;
import org.actus.testutils.ObservedDataSet;
import org.actus.testutils.ResultSet;
import org.actus.testutils.DataObserver;
import org.actus.attributes.ContractModel;
import org. actus.events.ContractEvent;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.DynamicTest;


public class PrincipalAtMaturityTest {
    @TestFactory
    public Stream<DynamicTest> test() {
        String testFile = "./src/test/resources/actus/actus-tests-pam.json";

        // read tests from file
        Map<String, TestData> tests = ContractTestUtils.readTests(testFile);

        // get ids of tests
        Set<String> testIds = tests.keySet();

        // go through test-id and perform test
        return testIds.stream().map(testId -> {
            // extract test for test ID
            TestData test = tests.get(testId);

            // create market model from data
            List<ObservedDataSet> dataObserved = new ArrayList<ObservedDataSet>(test.getDataObserved().values());
            DataObserver observer = ContractTestUtils.createObserver(dataObserved);
          
            // create contract model from data
            ContractModel terms = ContractTestUtils.createModel(tests.get(testId).getTerms());

            // compute and evaluate schedule
            ArrayList<ContractEvent> schedule = PrincipalAtMaturity.schedule(terms.getAs("MaturityDate"), terms);
            schedule = PrincipalAtMaturity.apply(schedule, terms, observer);

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
