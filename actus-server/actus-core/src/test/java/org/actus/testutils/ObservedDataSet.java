package org.actus.testutils;

import java.util.List;

public class ObservedDataSet {
    String identifier;
    List<ObservedDataPoint> data;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public List<ObservedDataPoint> getData() {
        return data;
    }

    public void setData(List<ObservedDataPoint> data) {
        this.data = data;
    }

}
