package org.actus.testutils;

import java.util.Map;
import java.util.List;

public class TestData {
    String identifier;
    Map<String, Object> terms;
    String to;
    Map<String, ObservedDataSet> dataObserved;
    List<ObservedEvent> eventsObserved;
    List<ResultSet> results;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Map<String, Object> getTerms() {
        return terms;
    }

    public void setTerms(Map<String, Object> terms) {
        this.terms = terms;
    }

    public String getto() {
        return to;
    }

    public void setto(String to) {
        this.to = to;
    }

    public Map<String, ObservedDataSet> getDataObserved() {
        return dataObserved;
    }

    public void setDataObserved(Map<String, ObservedDataSet> dataObserved) {
        this.dataObserved = dataObserved;
    }

    public List<ObservedEvent> getEventsObserved() {
        return eventsObserved;
    }

    public void setEventsObserved(List<ObservedEvent> eventsObserved) {
        this.eventsObserved = eventsObserved;
    }

    public List<ResultSet> getResults() { return results; }

    public void setResults(List<ResultSet> results) { this.results = results; }
}