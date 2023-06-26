package org.actus.testutils;

import org.actus.states.StateSpace;

public class ObservedEvent {
    String time;
    String type;
    double value;
    String contractId;
    StateSpace states;

    public String getContractId() { return contractId; }

    public void setContractId(String contractId) { this.contractId = contractId; }

    public StateSpace getStates() { return states; }

    public void setStates(StateSpace states) { this.states = states; }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
