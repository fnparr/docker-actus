/*
 * Copyright (C) 2016 - present by ACTUS Financial Research Foundation
 *
 * Please see distribution for license.
 */
package org.actus.testutils;

import org.actus.attributes.ContractModel;
import org.actus.events.ContractEvent;
import org.actus.events.EventFactory;
import org.actus.types.EventType;
import org.actus.functions.pam.POF_AD_PAM;
import org.actus.functions.csh.STF_AD_CSH;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Paths;

public class ContractTestUtils {
    
    public static ContractModel createModel(Map<String,Object> data) {
        // convert json terms object to a java map (required input for actus model parsing)
        Map<String, Object> map = new HashMap<String, Object>();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            if(entry.getKey().equals("contractStructure")){
                List<Map<String, Object>> contractStructure = new ArrayList<>();

                ((List<Map<String,Object>>)entry.getValue()).forEach(contractReference -> {
                    HashMap<String, Object> attributes = new HashMap<>();

                    contractReference.forEach((key,value) ->{
                        if(key.equals("object")){
                            Map<String, String> objectValues = new HashMap<>();
                            ((Map<String,Object>)value).forEach((childKey,childValue)-> objectValues.put(childKey, childValue.toString()));
                            attributes.put("object", objectValues);
                        }else{
                            attributes.put(key, value.toString());
                        }
                    });
                    contractStructure.add(attributes);
                });
                map.put("contractStructure", contractStructure);
            }else{
                //System.out.println(entry.getKey() + ":" + entry.getValue());

                // capitalize input json keys as required in contract model parser
                map.put(entry.getKey(), entry.getValue().toString());
            }
        }

        // parse attributes
        return ContractModel.parse(map);   
    }

    public static DataObserver createObserver(List<ObservedDataSet> data) {
        DataObserver observer = new DataObserver();

        data.forEach(entry -> {
            String symbol = entry.getIdentifier();
            HashMap<LocalDateTime,Double> series = new HashMap<LocalDateTime,Double>();
            entry.getData().forEach(obs -> {
                series.put(LocalDateTime.parse(obs.getTimestamp()), obs.getValue());
            });
            observer.add(symbol,series);
        });

        return observer;
    }
    public static DataObserver createObserver(List<ObservedDataSet> data, List<ContractEvent> observedEvents) {
        DataObserver observer = createObserver(data);
        HashMap<String, List<ContractEvent>> sortedEvents = new HashMap<>();
        Set<String> creatorIdentifikations = observedEvents.stream().map(ContractEvent::getContractID).collect(Collectors.toSet());
        creatorIdentifikations.forEach(s -> {
            observer.eventsObserved.put(s, observedEvents.stream().filter(c -> c.getContractID().equals(s)).collect(Collectors.toList()));
        });
        return observer;
    }

    public static Map<String, TestData> readTests(String file) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, TestData> tests = new HashMap<String,TestData>();

        try {
            // convert JSON string to Map
            tests = mapper.readValue(Paths.get(file).toFile(), new TypeReference<Map<String, TestData>>() {
            });
        } catch (IOException e) {
            System.err.println("IndexOutOfBounds");
        }

        return tests;
    }

    public static List<ContractEvent> readObservedEvents(List<ObservedEvent> eventsObserved, ContractModel terms) {
        List<ContractEvent> observedEvents = eventsObserved.stream().map(e -> {
            ContractEvent event = EventFactory.createEvent(
                    LocalDateTime.parse(e.getTime()),
                    EventType.valueOf(e.getType()),
                    terms.getAs("Currency"),
                    new POF_AD_PAM(),
                    new STF_AD_CSH(),
                    e.contractId
            );
            event.setStates(e.states);
            return event;
        }
        ).collect(Collectors.toList());
        return observedEvents;
    }
}