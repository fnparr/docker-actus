package org.actus.testutils;

import org.actus.events.ContractEvent;
import org.actus.externals.RiskFactorModelProvider;
import org.actus.attributes.ContractModelProvider;
import org.actus.states.StateSpace;
import org.actus.util.CommonUtils;

import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.time.LocalDateTime;


public class DataObserver implements RiskFactorModelProvider {
    HashMap<String,HashMap<LocalDateTime,Double>> multiSeries = new HashMap<String,HashMap<LocalDateTime,Double>>();
    HashMap<String, List<ContractEvent>> eventsObserved = new HashMap<>();
    
    public Set<String> keys() {
        return multiSeries.keySet();
    }

    public void add(String symbol, HashMap<LocalDateTime,Double> series) {
        multiSeries.put(symbol,series);
    }

    public double stateAt(String id, LocalDateTime time, StateSpace contractStates, ContractModelProvider contractAttributes) {
        return multiSeries.get(id).get(time);
    }

    public void setEventsObserved(List<ContractEvent> observedEvents){
        this.eventsObserved.put(observedEvents.get(0).getContractID(),observedEvents);
    }

    public Set<ContractEvent> events(ContractModelProvider model){
        return eventsObserved.values().stream().flatMap(list->list.stream()).collect(Collectors.toSet());
    }
}
